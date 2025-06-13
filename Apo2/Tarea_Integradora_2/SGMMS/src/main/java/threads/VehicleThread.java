package threads;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.incident.Incident;
import model.incident.IncidentType;
import model.incident.Location;
import model.vehicle.PriorityLevel;
import model.vehicle.Vehicle;
import structure.Graph;
import structure.Node;
import structure.PathFinder;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class VehicleThread extends Thread {
    private final Vehicle vehicle;
    private final ImageView view;
    private final Graph graph;
    private final Random rand = new Random();
    private final List<Vehicle> allVehicles;
    private final Map<Vehicle, ImageView> vehicleViewMap;
    private final List<Incident> activeIncidents;
    private final ObservableList<Incident> pendingIncidents;
    private volatile boolean running = true;

    public VehicleThread(Graph graph, Vehicle vehicle, ImageView view,
                         List<Vehicle> allVehicles, Map<Vehicle, ImageView> vehicleViewMap,
                         List<Incident> activeIncidents, ObservableList<Incident> pendingIncidents) {
        this.vehicle = vehicle;
        this.view = view;
        this.graph = graph;
        this.allVehicles = allVehicles;
        this.vehicleViewMap = vehicleViewMap;
        this.activeIncidents = activeIncidents;
        this.pendingIncidents = pendingIncidents;
        assignRandomRoute();
    }

    private void assignRandomRoute() {
        Node start = graph.getClosestNode(vehicle.getX(), vehicle.getY());
        Node end;
        do {
            end = graph.getNodes().get(rand.nextInt(graph.getNodes().size()));
        } while (!end.isWalkable() || end == start);

        List<Node> route = PathFinder.findShortestPath(graph, start, end);
        vehicle.setRoute(route);
    }

    @Override
    public void run() {
        while (running) {
            if (!vehicle.isActive()) {
                sleepSafe();
                continue;
            }

            Platform.runLater(() -> view.setImage(vehicle.getSpriteFrame()));

            vehicle.moveStep();
            vehicle.updateAnimation();

            if (vehicle.hasReachedDestination()) {
                if (vehicle.getAssignedIncident() != null) {
                    Incident inc = vehicle.getAssignedIncident();
                    inc.setResolved(true);
                    pendingIncidents.remove(inc);
                    activeIncidents.remove(inc);
                    vehicle.clearAssignedIncident();
                    vehicle.setAvailable(true);
                    vehicle.clearRoute();
                } else {
                    assignRandomRoute();
                }
            }

            checkCollision();
            sleepSafe();
        }
    }

    private void checkCollision() {
        for (Vehicle other : allVehicles) {
            if (other != vehicle && other.isActive() &&
                    vehicle.getBounds().intersects(other.getBounds())) {
                handleCollision(other);
                break;
            }
        }
    }

    private void handleCollision(Vehicle other) {
        vehicle.deactivate();
        other.deactivate();

        double x = vehicle.getX();
        double y = vehicle.getY();

        generateAccidentIncident(x, y);

        Platform.runLater(() -> {
            Image explosion = new Image(getClass().getResource("/images/burst/001.png").toExternalForm());
            ImageView explosionView = new ImageView(explosion);
            explosionView.setX(x);
            explosionView.setY(y);
            explosionView.setFitWidth(40);
            explosionView.setFitHeight(40);

            Pane parent = (Pane) view.getParent();
            parent.getChildren().add(explosionView);
            parent.getChildren().remove(view);

            ImageView otherView = vehicleViewMap.get(other);
            if (otherView != null) parent.getChildren().remove(otherView);

            new Thread(() -> {
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
                Platform.runLater(() -> parent.getChildren().remove(explosionView));
            }).start();
        });

        running = false;
    }

    private void generateAccidentIncident(double x, double y) {
        Node closest = graph.getClosestNode(x, y);
        Location loc = new Location("Palmira", closest.getId(), x, y, closest);
        Incident inc = new Incident(IncidentType.ACCIDENT, loc, "Colisión entre vehículos", PriorityLevel.HIGH);
        Platform.runLater(() -> {
            pendingIncidents.add(inc);
            activeIncidents.add(inc);
            System.out.println("🆘 Accidente generado: " + inc);
        });
    }

    private void sleepSafe() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            running = false;
        }
    }

    public void terminate() {
        running = false;
        interrupt();
    }
}
