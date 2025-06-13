package controller;

import factory.VehicleFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import map.GeneratorGraphMap;
import model.incident.*;
import model.vehicle.PriorityLevel;
import model.vehicle.Vehicle;
import structure.Graph;
import structure.Node;
import threads.VehicleThread;

import java.io.IOException;
import java.util.*;

public class ControllerMap {

    @FXML private Pane rootPane;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image mapImage;
    private Graph cityGraph;
    private GeneratorGraphMap generatorMap;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<VehicleThread> vehicleThreads = new ArrayList<>();
    private final List<ImageView> vehicleViews = new ArrayList<>();
    private final Map<Vehicle, ImageView> vehicleViewMap = new HashMap<>();
    private final List<Incident> activeIncidents = new ArrayList<>();
    private final ObservableList<Incident> pendingIncidents = FXCollections.observableArrayList();

    private static List<Vehicle> vehiclesStatic;
    private static ObservableList<Incident> pendingIncidentsStatic;
    private static Graph cityGraphStatic;
    private static final List<Incident> resolvedIncidents = new ArrayList<>();

    private double cameraX = 0;
    private double cameraY = 0;
    private final double moveSpeed = 10;
    private double viewportWidth;
    private double viewportHeight;

    private Timeline incidentSpawner;
    private Timeline mainLoop;

    @FXML
    public void initialize() {
        mapImage = new Image(getClass().getResourceAsStream("/images/palmira city (1).png"));

        initializeGraph(); // 🔁 Primero el grafo
        vehiclesStatic = vehicles;
        pendingIncidentsStatic = pendingIncidents;

        Platform.runLater(() -> {
            Scene scene = rootPane.getScene();
            viewportWidth = scene.getWidth();
            viewportHeight = scene.getHeight();

            canvas = new Canvas(viewportWidth, viewportHeight);
            gc = canvas.getGraphicsContext2D();
            rootPane.getChildren().add(0, canvas);

            initializeVehicles();
            initializeAutomatas();

            canvas.setFocusTraversable(true);
            canvas.setOnKeyPressed(this::handleKeyPressed);
            rootPane.setOnKeyPressed(this::handleKeyPressed);
            canvas.requestFocus();

            startIncidentGeneration();
            startMainLoop();

            scene.widthProperty().addListener((obs, oldVal, newVal) -> {
                viewportWidth = newVal.doubleValue();
                canvas.setWidth(viewportWidth);
                draw();
            });

            scene.heightProperty().addListener((obs, oldVal, newVal) -> {
                viewportHeight = newVal.doubleValue();
                canvas.setHeight(viewportHeight);
                draw();
            });
        });
    }

    private void initializeGraph() {
        cityGraph = new Graph();
        generatorMap = new GeneratorGraphMap();
        generatorMap.createEdges(cityGraph);

        // ✅ Seteamos el grafo en estático correctamente
        cityGraphStatic = cityGraph;
    }

    private void initializeVehicles() {
        List<Node> nodes = cityGraph.getNodes();
        Random rand = new Random();
        String[] types = { "ambulance", "patrol", "firetruck" };

        for (String type : types) {
            for (int i = 0; i < 4; i++) {
                Node start = nodes.get(rand.nextInt(nodes.size()));
                Vehicle v = VehicleFactory.create(type, start.getX(), start.getY(), 1.5);
                vehicles.add(v);

                ImageView view = new ImageView();
                view.setFitWidth(40);
                view.setFitHeight(40);
                vehicleViews.add(view);
                vehicleViewMap.put(v, view);
                rootPane.getChildren().add(view);

                VehicleThread vt = new VehicleThread(cityGraph, v, view, vehicles, vehicleViewMap, activeIncidents, pendingIncidents);
                vt.setDaemon(true);
                vt.start();
                vehicleThreads.add(vt);
            }
        }
    }

    private void initializeAutomatas() {
        List<Node> nodes = cityGraph.getNodes();
        Random rand = new Random();
        String[] npcs = {
                "gwagonblack", "gwagonwhite", "jeepgreen", "jeepred",
                "sedanblue", "sedanbrown", "sportblue", "sportmagenta", "taxi"
        };

        for (int i = 0; i < 10; i++) {
            String type = npcs[rand.nextInt(npcs.length)];
            Node start = nodes.get(rand.nextInt(nodes.size()));
            Vehicle npc = VehicleFactory.create(type, start.getX(), start.getY(), 1.2);
            vehicles.add(npc);

            ImageView view = new ImageView();
            view.setFitWidth(40);
            view.setFitHeight(40);
            vehicleViews.add(view);
            vehicleViewMap.put(npc, view);
            rootPane.getChildren().add(view);

            VehicleThread vt = new VehicleThread(cityGraph, npc, view, vehicles, vehicleViewMap, activeIncidents, pendingIncidents);
            vt.setDaemon(true);
            vt.start();
            vehicleThreads.add(vt);
        }
    }

    private void draw() {
        gc.clearRect(0, 0, viewportWidth, viewportHeight);

        gc.drawImage(
                mapImage,
                cameraX, cameraY,
                viewportWidth, viewportHeight,
                0, 0,
                viewportWidth, viewportHeight
        );

        drawIncidentZones();

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            ImageView view = vehicleViews.get(i);

            view.setImage(v.getSpriteFrame());
            view.setTranslateX(v.getX() - cameraX);
            view.setTranslateY(v.getY() - cameraY);
        }
    }

    private void drawIncidentZones() {
        for (Incident incident : activeIncidents) {
            if (incident.isResolved()) continue;
            double x = incident.getLocation().getX();
            double y = incident.getLocation().getY();

            switch (incident.getType()) {
                case FIRE -> gc.setFill(Color.rgb(255, 100, 0, 0.5));
                case ROBBERY -> gc.setFill(Color.rgb(0, 100, 255, 0.5));
                case ACCIDENT -> gc.setFill(Color.rgb(200, 0, 0, 0.5));
            }

            gc.fillOval(x - cameraX - 15, y - cameraY - 15, 30, 30);
        }
    }

    private void startIncidentGeneration() {
        incidentSpawner = new Timeline(new KeyFrame(Duration.seconds(12), e -> generateIncident()));
        incidentSpawner.setCycleCount(Timeline.INDEFINITE);
        incidentSpawner.play();
    }

    private void startMainLoop() {
        mainLoop = new Timeline(new KeyFrame(Duration.millis(50), e -> draw()));
        mainLoop.setCycleCount(Timeline.INDEFINITE);
        mainLoop.play();
    }

    private void generateIncident() {
        List<Node> houses = generatorMap.getHouseNodes();
        if (houses.isEmpty()) return;

        Node house = houses.get(new Random().nextInt(houses.size()));
        Location location = new Location("Palmira", house.getId(), house.getX(), house.getY(), house);

        IncidentType[] types = { IncidentType.ROBBERY, IncidentType.FIRE };
        IncidentType type = types[new Random().nextInt(types.length)];

        PriorityLevel priority = switch (type) {
            case FIRE -> PriorityLevel.HIGH;
            case ROBBERY -> PriorityLevel.MEDIUM;
            default -> PriorityLevel.LOW;
        };

        String desc = switch (type) {
            case FIRE -> "Incendio en zona residencial";
            case ROBBERY -> "Robo reportado";
            default -> "Otro incidente";
        };

        Incident incident = new Incident(type, location, desc, priority);
        pendingIncidents.add(incident);
        activeIncidents.add(incident);
        System.out.println("🆕 Incidente generado: " + incident);
    }

    private void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W -> cameraY = Math.max(0, cameraY - moveSpeed);
            case S -> cameraY = Math.min(mapImage.getHeight() - viewportHeight, cameraY + moveSpeed);
            case A -> cameraX = Math.max(0, cameraX - moveSpeed);
            case D -> cameraX = Math.min(mapImage.getWidth() - viewportWidth, cameraX + moveSpeed);
            case C -> openCentralMenuScene();
        }
        draw();
    }

    public static void openCentralMenuScene() {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerMap.class.getResource("/fxml/MenuView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Menú Central");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openIncidentPanelExternally() {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerMap.class.getResource("/fxml/IncidentPanel.fxml"));
            Parent root = loader.load();

            IncidentPanelController controller = loader.getController();
            controller.setAvailableVehicles(vehiclesStatic);
            controller.setCityGraph(cityGraphStatic);
            controller.incidentListView.setItems(pendingIncidentsStatic);

            Stage stage = new Stage();
            stage.setTitle("Panel de Incidentes");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openMonitoringWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerMap.class.getResource("/fxml/monitoring_center.fxml"));
            Parent root = loader.load();

            ControllerMonitoringCenter controller = loader.getController();
            controller.loadIncidents(getResolvedIncidents());

            Stage stage = new Stage();
            stage.setTitle("Centro de Monitoreo");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Incident> getResolvedIncidents() {
        return new ArrayList<>(resolvedIncidents);
    }

    public static void markIncidentAsAssigned(Incident inc) {
        if (pendingIncidentsStatic != null) {
            pendingIncidentsStatic.remove(inc);
        }
    }
}
