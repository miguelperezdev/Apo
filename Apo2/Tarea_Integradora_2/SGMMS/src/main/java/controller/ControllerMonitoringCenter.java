package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.incident.Incident;

import java.util.List;

public class ControllerMonitoringCenter {

    @FXML private TableView<IncidentRow> incidentTable;
    @FXML private TableColumn<IncidentRow, String> idColumn;
    @FXML private TableColumn<IncidentRow, String> typeColumn;
    @FXML private TableColumn<IncidentRow, String> priorityColumn;
    @FXML private TableColumn<IncidentRow, Long> timeResolvedColumn;
    @FXML private TableColumn<IncidentRow, Integer> scoreColumn;
    @FXML private TableColumn<IncidentRow, String> vehicleColumn;

    @FXML private Label totalIncidentsLabel;
    @FXML private Label totalScoreLabel;
    @FXML private Label avgTimeLabel;

    private ObservableList<IncidentRow> incidentRows = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        timeResolvedColumn.setCellValueFactory(new PropertyValueFactory<>("timeResolved"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("assignedVehicle"));

        incidentTable.setItems(incidentRows);
    }

    public void loadIncidents(List<Incident> resolvedIncidents) {
        incidentRows.clear();
        int totalScore = 0;
        long totalTime = 0;

        for (Incident inc : resolvedIncidents) {
            int score = calculateScore(inc);
            long time = inc.getElapsedMinutes();

            IncidentRow row = new IncidentRow(
                    inc.getId(),
                    inc.getType().toString(),
                    inc.getPriority().toString(),
                    time,
                    score,
                   inc.getAssignedVehicleId()
            );

            incidentRows.add(row);
            totalScore += score;
            totalTime += time;
        }

        // Actualizar estadísticas
        totalIncidentsLabel.setText(String.valueOf(resolvedIncidents.size()));
        totalScoreLabel.setText(String.valueOf(totalScore));

        if (!resolvedIncidents.isEmpty()) {
            long avgTime = totalTime / resolvedIncidents.size();
            avgTimeLabel.setText(avgTime + " min");
        } else {
            avgTimeLabel.setText("0 min");
        }
    }

    private int calculateScore(Incident incident) {
        int baseScore = switch (incident.getPriority()) {
            case HIGH -> 100;
            case MEDIUM -> 50;
            case LOW -> 20;
        };

        long minutes = incident.getElapsedMinutes();
        int timeBonus = (minutes < 10) ? 20 : 0;

        return baseScore + timeBonus;
    }

    @FXML
    private void showStatistics() {
        // Implementar lógica para mostrar estadísticas
        System.out.println("Mostrando estadísticas...");
    }

    public static class IncidentRow {
        private final String id;
        private final String type;
        private final String priority;
        private final long timeResolved;
        private final int score;
        private final String assignedVehicle;

        public IncidentRow(String id, String type, String priority,
                           long timeResolved, int score, String assignedVehicle) {
            this.id = id;
            this.type = type;
            this.priority = priority;
            this.timeResolved = timeResolved;
            this.score = score;
            this.assignedVehicle = assignedVehicle != null ? assignedVehicle : "N/A";
        }

        // Getters
        public String getId() { return id; }
        public String getType() { return type; }
        public String getPriority() { return priority; }
        public long getTimeResolved() { return timeResolved; }
        public int getScore() { return score; }
        public String getAssignedVehicle() { return assignedVehicle; }
    }
}



