package com.icesi.figures.control;

import com.icesi.figures.model.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FigureController {

    @FXML
    private Canvas canvas;

    private FigureThread ft1, ft2;
    private AnimationTimer animationTimer;
    private Figure circle, square;

    @FXML
    private void initialize(){
        circle = new Circle("BLUE", 0,0,25);
        ft1 = new FigureThread(circle);

        square = new Square("RED", 50,50, 50);
        ft2 = new FigureThread(square);

        setupAnimationTimer();

        new Thread(ft1).start();
        new Thread(ft2).start();
    }

    @FXML
    private void setupAnimationTimer() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                drawFigure(circle);
                drawFigure(square);
            }
        };
        animationTimer.start();
    }

    @FXML
    private void drawFigure(Figure figure) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.valueOf(figure.getColor()));
        if (figure instanceof Circle c) {
            gc.fillOval(c.getX(), c.getY(), c.getRadius() * 2, c.getRadius() * 2);
        } else if (figure instanceof Square s) {
            gc.fillRect(s.getX(), s.getY(), s.getSide(), s.getSide());
        }
        isOutOfBounds();
    }

    private void isOutOfBounds(){
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();

        if(circle.isOutOfBounds(width,height)){
            ft1.setRunning(false);
        }
        else if(square.isOutOfBounds(width,height)){
            ft2.setRunning(false);
        }
        else if(circle.isOutOfBounds(width,height) &&square.isOutOfBounds(width,height)){
            animationTimer.stop();
        }
    }
}
