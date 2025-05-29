module com.icesi.figures {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.icesi.figures.gui to javafx.fxml;
    opens com.icesi.figures.control to javafx.fxml;

    exports com.icesi.figures.control;
    exports com.icesi.figures.model;
    exports com.icesi.figures.gui;
}