package co.icesi.animation.model;

import java.util.List;

public class BirdAnimation extends Thread{


    private List<Bird> birds;
    private BirdController birdController;

    public BirdAnimation(List<Bird> birds, BirdController birdController){
        this.birds = birds;
        this.birdController = birdController;
    }
    @Override
    public void run() {
        while(true){
            for (Bird bird : birds){
                bird.move();
            }
            birdController.notifyObservers();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
