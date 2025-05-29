package co.icesi.agar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveThread extends Thread{

    private boolean running = true;

    private Board board;

    public MoveThread( Board board){
        this.board = board;
    }
    @Override
    public void run() {
        while(running){
            List<Cell> cells = new ArrayList<>(board.getCells());
            //List<Cell> cells = board.getCells();

            for(Cell cell: cells){
                board.moveCell(cell);
            }
            board.updateView();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        running = false;
    }
}
