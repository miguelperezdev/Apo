module icesi.com.tresenlinea {
        requires javafx.controls;
        requires javafx.fxml;

        opens gui to javafx.fxml;
        opens controller to javafx.fxml;
        exports controller;
        exports gui;
        exports model;
        }
