package model;

public class Team {
    private String teamName;
    private String country;
    private String coachName;
    private String assistantCoach;
    private Player[] players; 
    private int playerCount; 
    private Statistic statistics;

    public Team(String teamName, String country, String coachName, String assistantCoach) {
        this.teamName = teamName;
        this.country = country;
        this.coachName = coachName;
        this.assistantCoach = assistantCoach;
        this.players = new Player[20]; 
        this.playerCount = 0; 
    }

    /**
     * Adds a player to the team if there is space available.
     * <pre>
     * pre: The player object must not be null. The team must have space for the player (playerCount < players.length).
     * post: If the player is successfully added to the team, the player count is incremented, and true is returned. 
     *       If the team is full, false is returned, and no changes are made.
     * </pre>
     * @param player The player to be added to the team.
     * @return True if the player was successfully added, false if the team is full and the player cannot be added.
     */
    public boolean addPlayer(Player player) {
        if (playerCount < players.length) { 
            players[playerCount++] = player;
            return true; 
        }
        return false; 
    }

        /**
     * Validates that the player's ID is unique within the team.
     * <pre>
     * pre: The player's ID must be a non-null string.
     * post: If the player's ID is found to be unique (not already assigned to a player in the team), true is returned.
     *       If the player's ID already exists, false is returned.
     * </pre>
     * @param id The ID of the player to be checked for uniqueness.
     * @return True if the player's ID is unique, false if the ID is already assigned to another player.
     */

    public boolean validateUniquePlayer(String id) {
        for (int i = 0; i < playerCount; i++) { 
            if (players[i].getId().equalsIgnoreCase(id)) { 
                return false; 
            }
        }
        return true; 
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCountry() {
        return country;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getAssistantCoach() {
        return assistantCoach;
    }

    public Player[] getPlayers() {
        return players;
    }

    
    public int getPlayerCount() {
        return playerCount;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public void setAssistantCoach(String assistantCoach) {
        this.assistantCoach = assistantCoach;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Statistic getStstistics(){
        return statistics;
  }
  public void recordWin(int goalsScored, int goalsConceded) {
    statistics.recordWin(goalsScored, goalsConceded);
    }

    public void recordDraw(int goalsScored, int goalsConceded) {
        statistics.recordDraw(goalsScored, goalsConceded);
    }

    public void recordLoss(int goalsScored, int goalsConceded) {
        statistics.recordLoss(goalsScored, goalsConceded);
    }
    /**
     * Calculates the total number of cards received by all players in the team.
     * <pre>
     * pre: The players array must contain valid player objects, and the players must have a card count.
     * post: Returns the total number of cards accumulated by the players in the team. 
     *       The card count of each player is summed, and the total is returned.
     * </pre>
     * @return The total number of cards received by the players.
     */

    public int getTotalCards(){
        int totalCards = 0;
        for(Player player : players){
            if(player != null){
                totalCards += player.getCards().size();
            }
        }
        return totalCards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Name: ").append(teamName)
          .append(", Country: ").append(country)
          .append(", Coach: ").append(coachName)
          .append(", Assistant Coach: ").append(assistantCoach)
          .append(", Players: ").append(playerCount);
        return sb.toString();
    }
}

   

    


    
    
