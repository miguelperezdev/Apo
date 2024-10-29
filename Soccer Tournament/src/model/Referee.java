package model;

public class Referee extends Person {
    private String type; // Central o Asistente

    public Referee(String name, String country, String id, String type) {
        super(name, country, id);
        this.type = type;
    }

    @Override
    public void showInfo() {
        System.out.println("Referee [Name=" + name + ", Country=" + country + ", Type=" + type + "]");
    }

    @Override
    public String toString() {
        return "Referee [ID=" + id + ", Name=" + name + ", Country=" + country + ", Type=" + type + "]";
    }
}
