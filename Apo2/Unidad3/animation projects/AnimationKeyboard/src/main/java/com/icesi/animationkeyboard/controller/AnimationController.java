package com.icesi.animationkeyboard.controller;

import com.icesi.animationkeyboard.model.Cat;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
public class AnimationController {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Cat cat ;
    private boolean up, down, left, right;
    private Thread animationThread;
    private volatile boolean running = true;


    // Este metodo se ejecuta apenas inicie el controllador
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        cat = new Cat(loadAnimations(), 200,200);
        startAnimationThread();
    }

    private void startAnimationThread (){
        animationThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(16);
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            update ();
            Platform.runLater(this::draw);
            }
        });
        animationThread.setDaemon(true);//daemon?
        animationThread.start();
    }

    //vamos a actualizar la posicion del gato
    private void update() {
        double dx = 0, dy = 0;

        if (up) {
            dy -= 2;
        }
        if (down) {
            dy += 2;
        }
        if (left) {
            dx -= 2;
        }
        if (right) {
            dx += 2;
        }

        if (dx != 0 || dy != 0) {
            cat.move(dx, dy);
            cat.update();
        }

    }

        //Limpiar el canvas y volver a dibujar el gato
        private void draw () {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            cat.draw(gc);
        }

        // teclas en pulsacion
        @FXML
        public void onKeyPressed (KeyEvent event){
            switch (event.getCode()) {
                case W -> up = true;
                case S -> down = true;
                case A -> left = true;
                case D -> right = true;
            }
        }

        // Evento al soltar teclas
        @FXML
        public void onKeyReleased(KeyEvent event) {
            switch (event.getCode()) {
                case W -> up = false;
                case S -> down = false;
                case A -> left = false;
                case D -> right = false;
            }
        }
        private Image[] loadAnimations() {
            Image[] frames = new Image [6];

            for (int dir = 0; dir < 4; dir++) {
                for (int i = 0; i < 6 ; i++) {
                    String path = ("/com/icesi/animationkeyboard/assets/cat" + (i + 1) + ".png");
                    frames[i] = new Image(getClass().getResourceAsStream(path));
                }
            }
            return frames;
        }


        // detiene el hilo cuando la aplicacion se cierra
            public void stop () {
                running = false;
                if (animationThread != null) {
                    animationThread.interrupt();
                }
            }
        }

