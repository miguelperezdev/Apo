package model;

public class Hilo extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Hilo entrando");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
