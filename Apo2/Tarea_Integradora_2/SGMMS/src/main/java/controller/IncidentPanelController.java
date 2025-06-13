package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.incident.Incident;
import model.vehicle.Vehicle;
import structure.Graph;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class IncidentPanelController {

    @FXML public ListView<Incident> incidentListView;
    @FXML private Button assignButton;
    @FXML private StackPane rootPane;
    @FXML private ImageView backgroundImage;

    private Graph cityGraph;
    private List<Vehicle> availableVehicles;

    public void initialize() {
        try {
            Image bg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/incidents_background.jpg")));
            backgroundImage.setImage(bg);
            backgroundImage.setOpacity(0.2);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen de fondo.");
        }

        assignButton.setOnAction(e -> assignIncident());
    }

    public void setAvailableVehicles(List<Vehicle> vehicles) {
        this.availableVehicles = vehicles;
    }

    public void setCityGraph(Graph graph) {
        this.cityGraph = graph;
    }

    private void assignIncident() {
        Incident selected = incidentListView.getSelectionModel().getSelectedItem();
        if (selected == null || availableVehicles == null) {
            System.out.println("❌ No hay incidente seleccionado o vehículos disponibles.");
            return;
        }

        List<Vehicle> matching = availableVehicles.stream()
                .filter(Vehicle::isAvailable)
                .filter(v -> switch (selected.getType()) {
                    case FIRE -> v instanceof model.vehicle.FireTruck;
                    case ROBBERY -> v instanceof model.vehicle.Patrol;
                    case ACCIDENT -> v instanceof model.vehicle.Ambulance;
                }).toList();

        if (matching.isEmpty()) {
            System.out.println("❌ No hay vehículos disponibles para este tipo.");
            return;
        }

        ChoiceDialog<Vehicle> dialog = new ChoiceDialog<>(matching.get(0), matching);
        dialog.setTitle("Asignar Vehículo");
        dialog.setHeaderText("Selecciona el vehículo adecuado:");
        dialog.setContentText("Vehículo:");

        Optional<Vehicle> result = dialog.showAndWait();
        result.ifPresent(vehicle -> {
            if (cityGraph == null) {
                System.err.println("❌ ERROR: El grafo (cityGraph) es null.");
                return;
            }

            vehicle.setGraph(cityGraph);
            vehicle.assignIncident(selected, cityGraph);
            incidentListView.getItems().remove(selected);
            ControllerMap.markIncidentAsAssigned(selected);

            System.out.println("✅ Vehículo asignado al incidente: " + selected);
        });
    }
}
