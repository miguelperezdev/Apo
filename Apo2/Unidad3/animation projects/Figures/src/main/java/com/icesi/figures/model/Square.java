package com.icesi.figures.model;

public class Square extends Figure{

    private final int side;

    public Square(String color, int x, int y, int side) {
        super(color, x, y);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public boolean isOutOfBounds(int canvasWidth, int canvasHeight) {
        return getX()  < 0 ||               // Left bound
                getX() + getSide() > canvasWidth ||    // Right bound
                getY() < 0 ||               // Top bound
                getY() + getSide() > canvasHeight;      // Bottom bound
    }
}
