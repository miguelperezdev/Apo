package model;

public class Referee extends Person {
    private TypeR type; // Central o Asistente

    public Referee(String name, String country, String id, TypeR type) {
        super(name, country, id);
        this.type = type;
    }

    @Override
    public void showInfo() {
        System.out.println("Referee [Name=" + getName() + ", Country=" + getCountry() + ", Type=" + type + "]");
    }

    @Override
    public String toString() {
        return "Referee [ID=" + getId() + ", Name=" + getName() + ", Country=" + getCountry() + ", Type=" + type + "]";
    }

    // Getters and setters for the referee type
    public TypeR getType() {
        return type;
    }

    public void setType(TypeR type) {
        this.type = type;
    }
}
