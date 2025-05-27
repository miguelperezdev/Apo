package com.icesi.figures.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/icesi/figures/figure.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Figures");
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
