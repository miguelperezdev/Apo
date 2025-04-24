module org.example.introjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.introjavafx to javafx.fxml;
    exports org.example.ui;
}