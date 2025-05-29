package co.icesi.agar.model;

import javafx.geometry.Point2D;

public class Cell {

    public static final int FOOD_TYPE = 0;
    public static final int PLAYER_TYPE = 1;

    private double delta;
    private double x;
    private double y;
    private int radius;

    private int type;
    private int id;

    private double velocity;

    private String color;
    private Point2D direction;

    private double m;
    private double b;

    private int mode;
    public Cell(int x, int y, int radius, Point2D dir, int type) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.direction = dir;
        this.mode = Board.MOVE_RIGHT;
        this.type = type;
        this.velocity = 3;
        calculateEquation();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {

        this.radius = radius;
        velocity = 45.0/(radius);
        delta = (1/Math.sqrt(1+m*m))*velocity;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMode() {
        if(mode == Board.MOVE_LEFT) {
            mode = Board.MOVE_RIGHT;
        } else {
            mode = Board.MOVE_LEFT;
        }
        setDirection();
    }

    public void setDirection(){
        m=-m;
        b = y - m * x;
    }

    private void calculateEquation() {
        m = (double) (y - direction.getY()) / (x - direction.getX());
        b = y - m * x;
        delta = (1/Math.sqrt(1+m*m))*velocity;
    }

    public void move() {
        if(type == FOOD_TYPE) {
            return;
        }
        switch (mode) {
            case Board.MOVE_LEFT:
                x -= delta;
                break;
            case Board.MOVE_RIGHT:
                x += delta;
                break;
        }
        y = (int) ((x*m + b));
        if(x+radius >= Board.width) {
            x = Board.width - radius-1;
            setMode();
        } else if(x <= 0) {
            x = 1;
            setMode();
        }
        if(y + radius >= Board.height) {
            y = Board.height - radius-1;
            setDirection();
        }else if(y < 0){
            y = 1;
            setDirection();
        }
    }

}

