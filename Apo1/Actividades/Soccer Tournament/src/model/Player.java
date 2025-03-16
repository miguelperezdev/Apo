package model;

public class Player extends Person {

    private Position position;

    public Player(String name, String  country, String id, Position position) {
        super(name, country ,id);
        this.position= position;

    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    @Override
    public void showInfo() {
        System.out.println("Player [Name=" + getName() + ", ID (Shirt Number)=" + getId() + 
                           ", Country=" + getCountry() + ", Position=" + position + "]");
    }

    @Override
    public String toString() {
        return "Player [Name=" + getName() + ", ID (Shirt Number)=" + getId() + ", Country=" + getCountry() + ", Position=" + position + "]";
    }
    
}