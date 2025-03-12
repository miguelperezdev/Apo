package model;

public class Team {
    private String teamName;
    private String country;
    private String coachName;
    private String assistantCoach;
    private Player[] players; 
    private int playerCount; 


    public Team(String teamName, String country, String coachName, String assistantCoach) {
        this.teamName = teamName;
        this.country = country;
        this.coachName = coachName;
        this.assistantCoach = assistantCoach;
        this.players = new Player[20]; 
        this.playerCount = 0; 
    }

 
    public boolean addPlayer(Player player) {
        if (playerCount < players.length) { 
            players[playerCount++] = player;
            return true; 
        }
        return false; 
    }

    
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


    
    
