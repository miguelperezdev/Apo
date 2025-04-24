module icesi.com.formularios {
    requires javafx.controls;
    requires javafx.fxml;


    opens icesi.com.formularios to javafx.fxml;
    exports icesi.com.formularios;
}