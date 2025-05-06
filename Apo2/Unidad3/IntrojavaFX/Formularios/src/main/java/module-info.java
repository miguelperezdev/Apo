module ui.ejercicioregistro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens gui to javafx.fxml;
    exports gui;
    exports model;
    exports controller;
    exports customexceptions;
    opens controller to javafx.fxml;
}