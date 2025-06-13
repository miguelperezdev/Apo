package model;

public class Statistic {
    private Team team;
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public Statistic(Team team) {
        this.team = team;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.points = 0;

    }
    public String recordWin(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        wins++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        points += 3;
        return "The win is for the team: " + team.getTeamName();
    }
    public void recordDraw(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        draws++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        points += 1;
        
    }

    public String recordLoss(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        losses++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        return "The team: " + team.getTeamName() + "loss";

    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public Team team(){
        return team;
    }
    @Override
        public String toString() {
            if (team == null) {
                return "No team data available.";
    }
             return String.format("%-20s %-10d %-10d %-10d %-10d %-10d %-10d %-10d",
             team.getTeamName(), gamesPlayed, wins, draws, losses, goalsFor, goalsAgainst, points);
}

}
