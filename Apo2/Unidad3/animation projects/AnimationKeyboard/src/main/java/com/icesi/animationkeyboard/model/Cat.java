package com.icesi.animationkeyboard.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Cat implements Runnable {
    private int frameIndex = 0 ;
    private int frameCounter = 0;
    private final Image[] frames;
    private double x, y;

    public Cat(Image[] frames, double x, double y) {
        this.frames = frames;
        this.x = x;
        this.y = y;
    }

    // Avanza al siguiente frame cada 10 ciclos
    public void update() {
        frameCounter++;
        if (frameCounter >= 10) {
            frameIndex = (frameIndex + 1) % frames.length;
            frameCounter = 0;
        }
    }

    public void draw (GraphicsContext gc){
        gc.drawImage(frames[frameIndex], x, y);
    }

    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void run() {

    }
}
