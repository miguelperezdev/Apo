package model;

public class RegisterCard {
    private Player player;
    private Card card;
    private Referee referee;
    private int minute;
    private Match match;
    private Team team;
    public RegisterCard(Player player, Referee referee, int card, int minute, Match match){
        this.player= player;
        this.referee= referee;
        this.minute = minute;
        this.match= match;
        switch(card){
            case 1: 
            this.card = Card.YELLOW;
            break;
            case 2:
            this.card = Card.RED;
            break;
            default:
            this.card= Card.YELLOW;

        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    @Override
    public String toString(){
        return "Player: " + player.getName() + " , Arbitro: " + referee.getName() + " , Card: " + card +  " , Match: " + match.getMatchDetails() + " , Minute: " + minute;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    


    
}
