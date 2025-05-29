module com.icesi.animationkeyboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Abres el paquete controller para FXML (necesario para que JavaFX pueda instanciar el controlador)
    opens com.icesi.animationkeyboard.controller to javafx.fxml;

    // También abre el modelo si lo necesitas (por ejemplo si accedes desde FXML o se serializa algo)
    opens com.icesi.animationkeyboard.model to javafx.fxml;

    // Exportas el paquete base (con tu clase Main)
    exports com.icesi.animationkeyboard.gui;
}
