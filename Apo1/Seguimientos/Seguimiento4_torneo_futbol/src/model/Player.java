package model;

public class Player extends Person {
    private int number;
    private String country;
    private Position position;
    private int goals;

    public Player(String id, String name, int number, String country, Position position) {
        super(id, name, country);
        this.position = position;
        this.number= number;
    
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Position getPosition() {
        return position;
    }

    public int getGoals() {
        return goals;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

   

    public void setPosition(Position position) {
        this.position = position;
    }

    

    @Override
    public String toString() {
        return super.toString()+ "Name: " + getName() + "Number: " + number + ", Country: " + country + ", Position: " + position + ", Goals: " + goals;
    }
}

