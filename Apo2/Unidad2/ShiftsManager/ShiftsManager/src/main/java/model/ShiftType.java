package model;

public class ShiftType {
    private String name;
    private double time;

    private ShiftType next;

    public ShiftType(String name, double time) {
        this.name = name;
        this.time = time;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public ShiftType getNext() {
        return next;
    }

    public void setNext(ShiftType next) {
        this.next = next;
    }
}
