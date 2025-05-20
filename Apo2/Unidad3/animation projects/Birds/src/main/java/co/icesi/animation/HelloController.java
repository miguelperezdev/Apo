package co.icesi.animation;

import co.icesi.animation.model.Bird;
import co.icesi.animation.model.BirdController;
import co.icesi.animation.model.ObserverBirds;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable, ObserverBirds {

    @FXML
    private Pane pane;

    private List<ImageView> imageViews;

    private HashMap<String, Image> imageHashMap;

    private BirdController birdController = BirdController.getInstance();

     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageViews = new ArrayList<>();
        imageHashMap = new HashMap<>();
        pane.setPrefWidth(BirdController.WIDTH);
        pane.setPrefHeight(BirdController.HEIGHT);
        birdController.getBirds().forEach(bird -> {
            String imagePath = bird.getImagePath();
            Image image = null;
            if(!imageHashMap.containsKey(imagePath)){
                image = new Image(imagePath);
                imageHashMap.put(imagePath, image);
            }else {
                image = imageHashMap.get(imagePath);
            }
            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(Bird.WIDTH);
            imageView.setFitHeight(Bird.HEIGHT);
            imageView.setLayoutX(bird.getX());
            imageView.setLayoutY(bird.getY());
            pane.getChildren().add(imageView);
            imageViews.add(imageView);
        });
        birdController.setObserverBirds(this);
    }

    public void update(){
        Platform.runLater(this::updateBirds);
    }
    public void updateBirds(){
        List<Bird> birds = birdController.getBirds();
        for (int i = 0; i < birds.size(); i++) {
            Bird bird = birds.get(i);
            ImageView imageView = imageViews.get(i);
            imageView.setLayoutX(bird.getX());
            imageView.setLayoutY(bird.getY());
            String imagePath = bird.getImagePath();
            Image image = null;
            if(!imageHashMap.containsKey(imagePath)){
                image = new Image(imagePath);
                imageHashMap.put(imagePath, image);
            }else {
                image = imageHashMap.get(imagePath);
            }
            imageView.setImage(image);
        }
    }
}