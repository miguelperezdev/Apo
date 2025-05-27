package com.icesi.figures.model;

public class FigureThread implements Runnable {
    private final Figure figure;
    private boolean running = true;

    public FigureThread(Figure figure) {
        this.figure = figure;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            try {
                figure.move();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}