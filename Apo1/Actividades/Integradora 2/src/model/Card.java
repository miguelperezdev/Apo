package model;

public class Card {
    private Player player;
    private String cardType; // "Yellow" o "Red"
    private int minute;
    private Team team;
    
        public Card(Player player,String team2 , String cardType, int minute) {
            this.player = player;
            this.cardType = cardType;
            this.minute = minute;
            this.team= team;
    }

    public Player getPlayer() {
        return player;
    }

    public String getCardType() {
        return cardType;
    }

    public int getMinute() {
        return minute;
    }
    public Team getTeam(){
        return team;
    }

    @Override
    public String toString() {
        return "Card: " + cardType + " given to " + player.getName() + " at minute " + minute;
    }
}
