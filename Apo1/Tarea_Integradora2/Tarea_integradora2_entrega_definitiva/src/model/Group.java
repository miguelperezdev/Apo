package model;

public class Group {
    private String groupName;
    private Team[] teams; 
    private int[][] stats; 

    public Group(Team[] teams) {
        this.teams = teams;
        this.stats = new int[teams.length][7]; 
    }

    public void playMatch(int team1Index, int team2Index, int team1Goals, int team2Goals) {
        stats[team1Index][0]++;
        stats[team2Index][0]++;

        stats[team1Index][4] += team1Goals;
        stats[team1Index][5] += team2Goals;
        stats[team2Index][4] += team2Goals;
        stats[team2Index][5] += team1Goals;

        if (team1Goals > team2Goals) {
            stats[team1Index][1]++; 
            stats[team2Index][3]++; 
            stats[team1Index][6] += 3; 
        } else if (team1Goals < team2Goals) {
            stats[team2Index][1]++; 
            stats[team1Index][3]++; 
            stats[team2Index][6] += 3; 
        } else {
            stats[team1Index][2]++; 
            stats[team2Index][2]++; 
            stats[team1Index][6]++; 
            stats[team2Index][6]++;
        }
    }

    public String getStandings() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group ").append(groupName).append(" Standings:\n");
        sb.append("| Team Name      | Played | Wins | Draws | Losses | GF  | GA  | Points |\n");

        for (int i = 0; i < teams.length; i++) {
            sb.append(String.format("| %-14s | %-6d | %-4d | %-5d | %-6d | %-3d | %-3d | %-6d |\n",
                    teams[i].getTeamName(),
                    stats[i][0],  
                    stats[i][1],  
                    stats[i][2],  
                    stats[i][3],  
                    stats[i][4],  
                    stats[i][5],  
                    stats[i][6])); 
        }
        return sb.toString();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public int[][] getStats() {
        return stats;
    }

    public void setStats(int[][] stats) {
        this.stats = stats;
    }

}

    

