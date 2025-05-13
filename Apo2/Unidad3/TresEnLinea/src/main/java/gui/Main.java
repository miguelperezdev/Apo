package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TresEnLineaFront/TresEnLinea.fxml")); // ruta de donde esta el Front
        Parent root = loader.load();

        // Configurar la ventana principal
        primaryStage.setTitle("Tres en Raya - JavaFX MVC");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image( "Triqui.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

