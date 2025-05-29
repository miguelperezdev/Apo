package com.icesi.figures.model;

public class Circle extends Figure{

    private final int radius;

    public Circle(String color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void move(){
        int y = getY();
        this.setY(y+1);
    }

    @Override
    public boolean isOutOfBounds(int canvasWidth, int canvasHeight) {
        return getX()  < 0 ||               // Left bound
                getX() + (getRadius()*2) > canvasWidth ||    // Right bound
                getY() < 0 ||               // Top bound
                getY() + (getRadius()*2) > canvasHeight;      // Bottom bound
    }

    public int getRadius() {
        return radius;
    }
}
