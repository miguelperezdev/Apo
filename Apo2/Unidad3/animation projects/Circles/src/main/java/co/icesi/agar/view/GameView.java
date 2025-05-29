package co.icesi.agar.view;

import co.icesi.agar.controllers.GameController;
import co.icesi.agar.model.Board;
import co.icesi.agar.model.Cell;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class GameView {

    private GameController controller;

    private Board board;
    private Pane pane;

    private HashMap<Integer, Label> labels;

    public GameController getController() {
        return controller;
    }
    public GameView(){
        init();
    }
    public void init(){
        controller = new GameController();
        labels = new HashMap<>();
        board = Board.getInstance(this);
        List<Cell> cells = board.getCells();
        pane = new Pane();
        for (int i = 0; i < cells.size(); i++) {
            Label label = new Label(cells.get(i).getId() + "");
            label.setLayoutX(cells.get(i).getX());
            label.setLayoutY(cells.get(i).getY());
            String color = getColor(cells.get(i).getX(), cells.get(i).getY());
            cells.get(i).setColor(color);
            label.setStyle(labelStyle(cells.get(i).getRadius(), color));
            labels.put(cells.get(i).getId(),label);
            pane.getChildren().add(label);
        }

    }

    public void updateView(){
        Platform.runLater(() -> {
            List<Integer> keysToRemove = new ArrayList<>();
            labels.keySet().forEach(key -> {
                Optional<Cell> cell = board.getCells().stream().filter(c -> c.getId() == key).findFirst();
                if(cell.isPresent()){
                    Label label =labels.get(key);
                    label.setLayoutX(cell.get().getX());
                    label.setLayoutY(cell.get().getY());
                    label.setStyle(labelStyle(cell.get().getRadius(), cell.get().getColor()));

                }else{
                    keysToRemove.add(key);
                }
            });
            keysToRemove.forEach(key -> {
                pane.getChildren().remove(labels.get(key));
                labels.remove(key);
            });
        });

    }

    public String labelStyle(int radius, String color){

        return "-fx-background-color:"+color+";" +
                "-fx-text-fill: "+color+";" +
                "-fx-min-width: " + radius + "px; " + // Establecemos el ancho mínimo
                "-fx-min-height: " + radius + "px; " + // Establecemos la altura mínima
                "-fx-max-width: " + radius + "px; " + // Establecemos el ancho máximo
                "-fx-max-height: " + radius + "px; " +
                "-fx-background-radius: " + 100 + "%;";
    }

    public String getColor(double value1, double value2) {
        int red = (int)value1 % 256;
        int green = (int)value2 % 256;
        int blue = (int)(value1 + value2) % 256;


        red = Math.min(Math.max(red, 0), 240);
        green = Math.min(Math.max(green, 0), 256);
        blue = Math.min(Math.max(blue, 0), 240);

        String hex = String.format("#%02X%02X%02X", red, green, blue);

        return hex;
    }

    public Pane getPane() {
        return pane;
    }
}
