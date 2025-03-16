package model;
import java.util.ArrayList;

public class Match {
    private Referee centralReferee;
    private Referee assistantReferee1;
    private Referee assistantReferee2;
    private Team homeTeam;
    private Team awayTeam;
    private String matchDate;
    private String location;
    private int homeTeamScore;
    private int awayTeamScore;
    private ArrayList<RegisterCard> registerCards;

    /**
     * Constructs a Match with specified referees, teams, date, and location.
     * 
     * <pre>
     * pre: Central referee, assistant referees, home team, and away team must not be null.
     * post: A Match object is created with the provided referees, teams, date, and location.
     * </pre>
     * 
     * @param centralReferee The central referee of the match.
     * @param assistantReferee1 The first assistant referee.
     * @param assistantReferee2 The second assistant referee.
     * @param homeTeam The home team playing in the match.
     * @param awayTeam The away team playing in the match.
     * @param matchDate The date of the match.
     * @param location The location of the match.
     */
    public Match(Referee centralReferee, Referee assistantReferee1, Referee assistantReferee2,
                 Team homeTeam, Team awayTeam, String matchDate, String location) {
        this.centralReferee = centralReferee;
        this.assistantReferee1 = assistantReferee1;
        this.assistantReferee2 = assistantReferee2;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.location = location;
        this.homeTeamScore= 0;
        this.awayTeamScore= 0;
        this.registerCards = new ArrayList<>();
        
    }

    /**
     * Gets the central referee of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the central referee of the match.
     * </pre>
     * 
     * @return The central referee.
     */
    public Referee getCentralReferee() {
        return centralReferee;
    }
    /**
     * Gets the first assistant referee of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the first assistant referee of the match.
     * </pre>
     * 
     * @return The first assistant referee.
     */
    public Referee getAssistantReferee1() {
        return assistantReferee1;
    }
    /**
     * Gets the second assistant referee of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the second assistant referee of the match.
     * </pre>
     * 
     * @return The second assistant referee.
     */
    public Referee getAssistantReferee2() {
        return assistantReferee2;
    }
    /**
     * Gets the home team of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the home team.
     * </pre>
     * 
     * @return The home team.
     */
    public Team getHomeTeam() {
        return homeTeam;
    }
    /**
     * Gets the away team of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the away team.
     * </pre>
     * 
     * @return The away team.
     */
    public Team getAwayTeam() {
        return awayTeam;
    }
    /**
     * Gets the date of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the date of the match.
     * </pre>
     * 
     * @return The match date.
     */
    public String getMatchDate() {
        return matchDate;
    }
    /**
     * Gets the location of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns the location of the match.
     * </pre>
     * 
     * @return The match location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Sets the score of the match.
     * 
     * <pre>
     * pre: Home team score and away team score must be non-negative integers.
     * post: The scores for the home and away teams are updated.
     * </pre>
     * 
     * @param homeTeamScore The score of the home team.
     * @param awayTeamScore The score of the away team.
     */
    public void setScore(int homeTeamScore, int awayTeamScore ){
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore= awayTeamScore;
    }
    /**
     * Gets the score of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns a string representation of the score.
     * </pre>
     * 
     * @return A string representing the match score.
     */
    public String getScore(){
        return homeTeam.getTeamName() + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam.getTeamName();
    }
    /**
     * Returns a string representation of the match.
     * 
     * <pre>
     * pre: None.
     * post: Returns a string detailing the referees, teams, date, location, and score.
     * </pre>
     * 
     * @return A string representation of the match.
     */
    @Override
    public String toString() {
        return "Match{" +
                "centralReferee=" + centralReferee.getName() +
                ", assistantReferee1=" + assistantReferee1.getName() +
                ", assistantReferee2=" + assistantReferee2.getName() +
                ", homeTeam=" + homeTeam.getTeamName() +
                ", awayTeam=" + awayTeam.getTeamName() +
                ", matchDate='" + matchDate + '\'' +
                ", location='" + location + '\'' +
                ", score='" + getScore() + '\'' +
                
                '}';
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
    public void addCard(RegisterCard card){
        registerCards.add(card);
    }
    public ArrayList<RegisterCard> getCards(){
        return registerCards;
    }
    public String getMatchDetails(){
        return homeTeam  + " vs " + awayTeam;
    }
    public int getCardsByReferee(Referee referee) {
        int cardsByReferee = 0;
        for (RegisterCard cards : registerCards) {
            if (cards.getReferee() != null && cards.getReferee().equals(referee)) {
                cardsByReferee++;
            }
        }
        return cardsByReferee;
    }
    
    public boolean isPlayerInMatch(Player player) {
        for (Player players : homeTeam.getPlayers()) {
            if (players != null && players.equals(player)) {
                return true;
            }
    }
    for (Player players : awayTeam.getPlayers()) {
        if (players != null && players.equals(player)) {
            return true;
        }
    }
    return false;
    }
}
