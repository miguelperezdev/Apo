package com.icesi.figures.model;

public abstract class Figure{
    private String color;

    private int x;
    private int y;

    public Figure(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Movimiento
    public void move() {
        this.setX(getX() + 1);
        this.setY(getY() + 1);
    }

    //Colisiones
    public abstract boolean isOutOfBounds(int canvasWidth, int canvasHeight);
}