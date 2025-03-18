package model;

import java.util.ArrayList;


public class Player extends Person {
    private int number;
    private Position position;
    private int goals;
    private ArrayList<Player> scorers; 
    private ArrayList<Player> assistants; 
    private ArrayList<RegisterCard> registerCards;

    public Player(String id, String name, int number, String country, Position position) {
        super(id, name, country);
        this.position = position;
        this.number = number;
        this.scorers = new ArrayList<>(); 
        this.assistants = new ArrayList<>(); 
        this.registerCards = new ArrayList<>();
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

    public ArrayList<Player> getScorers() {
        return scorers;
    }

    public ArrayList<Player> getAssistants() {
        return assistants;
    }

    public void addScorer(Player scorer) {
        this.scorers.add(scorer);
    }

    public void addAssistant(Player assistant) {
        this.assistants.add(assistant);
    }

    @Override
    public String toString() {
        return super.toString() + " Name: " + getName() + " Number: " + number + ", Country: " + getCountry() + ", Position: " + position + ", Goals: " + goals;
    }
    public void assignCard(RegisterCard card){
        registerCards.add(card);
        
    }
    public ArrayList <RegisterCard> getCards(){
        return registerCards;
    }
}
