package com.icesi.animationkeyboard.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/icesi/animationkeyboard/gui/animation.fxml"));
            AnchorPane root = loader.load();

            // Crear y mostrar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Cat Animation");
            primaryStage.show();

            // Muy importante: enfocar para que capte eventos de teclado
            root.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Punto de entrada del programa
    public static void main(String[] args) {
        launch(args);
    }
}
