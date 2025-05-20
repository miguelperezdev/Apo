package co.icesi.animation.model;

import co.icesi.animation.model.moveFunctions.MoveFunction;
import co.icesi.animation.model.moveFunctions.MoveSen;
import co.icesi.animation.model.moveFunctions.MoveSenDiag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BirdController {

    private static BirdController instance;

    private ObserverBirds observerBirds;

    public void setObserverBirds(ObserverBirds observerBirds) {
        this.observerBirds = observerBirds;
    }

    public static BirdController getInstance(){
        if(instance == null){
            instance = new BirdController();
        }
        return instance;
    }
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    private List<Bird> birds;
    private BirdAnimation birdAnimation;

    private BirdController(){
        this.birds = new ArrayList<>();
        int birdCount = 75;
        generateBirds(birdCount);
        birdAnimation = new BirdAnimation(birds, this);
        birdAnimation.start();
    }

    public void notifyObservers(){
        if(observerBirds != null)
            observerBirds.update();
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public void generateBirds(int n){
        Random random = new Random();
        MoveFunction[] moves = new MoveFunction[]{new MoveSen(), new MoveSenDiag()};

        for (int i = 0; i < n; i++){
            birds.add(new Bird(random.nextInt(WIDTH), random.nextInt(HEIGHT),moves[i%2]));
        }
    }
}
