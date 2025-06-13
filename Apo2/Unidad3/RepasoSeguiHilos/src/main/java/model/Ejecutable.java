package model;

public class Ejecutable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Ejecutando");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
