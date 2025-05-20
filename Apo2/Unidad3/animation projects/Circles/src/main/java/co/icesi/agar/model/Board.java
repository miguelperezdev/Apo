package co.icesi.agar.model;

import co.icesi.agar.view.GameView;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Board {
    public static final int MOVE_UP = 0;
    public static final int MOVE_DOWN = 1;
    public static final int MOVE_LEFT = 2;
    public static final int MOVE_RIGHT = 3;

    public static final int width = 800;
    public static final int height=600;

    private static Board instance;

    private GameView view;

    public void setView(GameView view) {
        this.view = view;
    }

    public void updateView() {
        view.updateView();
    }

    public static Board getInstance(GameView view) {
        if(instance == null) {
            instance = new Board(view);
        }
        return instance;
    }

    private List<Cell> cells;

    private Random random;

    private MoveThread thread;

    private Board(GameView view) {
        this.view = view;
        cells = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 10; i++) {
            addCell(Cell.FOOD_TYPE, 10);
        }
        for (int i = 0; i < 3; i++) {
            addCell(Cell.PLAYER_TYPE, 30);
        }
        thread = new MoveThread( this);
        thread.start();

    }

    public int addCell(int type, int radius) {

        cells.add(new Cell(random.nextInt(width-2*radius), random.nextInt(height-2*radius), radius,new Point2D(random.nextInt(width), random.nextInt(height)),type));
        if(cells.size() == 1) {
            cells.get(0).setId(1);
            return  1;
        } else {
            cells.get(cells.size() - 1).setId(cells.get(cells.size() - 2).getId() + 1);
            return cells.get(cells.size() - 1).getId();
        }

    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void removeCell(Cell cell) {

    }

    public void moveCell(Cell cell) {
        cell.move();
        getCollideCell(cell);
    }

    public void getCollideCell(Cell cell) {
        List<Cell> col =cells.stream().filter(c -> {
            if(c.getId() != cell.getId()){
                Point2D center1 = new Point2D(cell.getX() +  cell.getRadius()/2.0, cell.getY() + cell.getRadius()/2.0);
                Point2D center2 = new Point2D(c.getX() +  c.getRadius()/2.0, c.getY() + c.getRadius()/2.0);
                return center1.distance(center2) < Math.max(cell.getRadius(), c.getRadius())/2.0;
            }
            return false;
          }
        ).collect(Collectors.toList());

        if(!col.isEmpty()) {
            for (Cell c : col) {
                if (cell.getRadius() > c.getRadius()) {
                    cell.setRadius(cell.getRadius() + c.getRadius());
                    cells.remove(c);
                } else if (cell.getRadius() < c.getRadius()){
                    c.setRadius(c.getRadius() + cell.getRadius());
                    cells.remove(cell);
                    break;
                }
            }
        }

    }



}
