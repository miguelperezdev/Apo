module model {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.unsupported.desktop;

    opens model to javafx.fxml;
    opens controller to javafx.fxml;  // <-- NECESARIO para que JavaFX pueda acceder al controlador
    opens main to javafx.fxml;         // <-- NECESARIO si usas FXML en Main
    exports model;
    exports controller;
    exports main;
}
