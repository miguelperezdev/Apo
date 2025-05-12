package gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentFormApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        openWindow("/gui/register/register.fxml");
    }

    //Metodo para volver dinamico la apertura de vistas .fxml
    public static void openWindow(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentFormApplication.class.getResource(fxmlFile));
        Scene scene;
        if (fxmlFile.contains("students.fxml")) {
            scene = new Scene(fxmlLoader.load(), 920, 540);
        } else {
            scene = new Scene(fxmlLoader.load(), 680, 540);
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Classroom Application!");
        stage.setScene(scene);
        //Agregar icono a la app
        stage.getIcons().add(new Image("https://yt3.googleusercontent.com/2__G-ckA66-4JgXPlHTGZvg8CoUIgDU6qYFnJqW-AsVeJvBRT4hCjXz4XMOjIqm4m7v431lT=s900-c-k-c0x00ffffff-no-rj"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}