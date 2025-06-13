package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML private Button mapButton;
    @FXML private Button incidentButton;
    @FXML private Button monitorButton;

    @FXML
    public void initialize() {
        mapButton.setOnAction(e -> {
            // Cerrar menú y abrir mapa, si es que se implementa algo más allá.
            ((Stage) mapButton.getScene().getWindow()).close();
        });

        incidentButton.setOnAction(e -> {
            ControllerMap.openIncidentPanelExternally();
            ((Stage) incidentButton.getScene().getWindow()).close();
        });

        monitorButton.setOnAction(e -> {
            ControllerMap.openMonitoringWindow();  // Aquí llamamos al método correcto
            ((Stage) monitorButton.getScene().getWindow()).close();
        });
    }
}
