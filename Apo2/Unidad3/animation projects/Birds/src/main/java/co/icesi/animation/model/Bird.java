package co.icesi.animation.model;

import co.icesi.animation.model.moveFunctions.MoveFunction;

import java.security.PublicKey;

public class Bird {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 60;
    public static final int DELTA = 5;
    public static final int IMAGE_COUNT = 8;
    public static final String BASE_PATH = "co/icesi/animation/imgs/birds/bird";
    public static final String IMAGE_EXTENSION = ".png";
    private double x;
    private double y;
    private int imageIndex;
    private String imagePath;

    private MoveFunction moveFunction;

    public Bird(int x, int y , MoveFunction moveFunction) {
        this.x = x;
        this.y = y;
        this.imageIndex = 0;
        this.moveFunction = moveFunction;
        this.imagePath = BASE_PATH + (imageIndex+1) + IMAGE_EXTENSION;
    }

    public void changeImage() {
        imageIndex = (imageIndex + 1) % IMAGE_COUNT;
        imagePath = BASE_PATH + (imageIndex+1) + IMAGE_EXTENSION;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void move() {
        changeImage();
        x = (x + DELTA) % BirdController.WIDTH;
        y = moveFunction.move(x);
    }
}
