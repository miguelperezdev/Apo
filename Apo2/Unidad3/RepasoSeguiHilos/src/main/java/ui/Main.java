package ui;
import model.*;

public class Main {
    public static void main (String[] args) {
        Counter counter = new Counter() ;

        Thread t1 = new Thread(new Task(counter));
        Thread t3 = new Thread(new Task(counter));
        Thread t2 = new Thread(new Task(counter));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + counter.getCount());

        //---
        // llamado simple a hilos
        Hilo hilo = new Hilo();
        hilo.start();

        Ejecutable ejecutable = new Ejecutable();
        Thread hilo2 = new Thread(ejecutable);
        hilo2.start();

    }
}
