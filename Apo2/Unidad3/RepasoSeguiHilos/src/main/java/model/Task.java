package model;

public class Task implements Runnable {
    private final Counter counter;

    public Task(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            counter.increment();
        }
    }
}
