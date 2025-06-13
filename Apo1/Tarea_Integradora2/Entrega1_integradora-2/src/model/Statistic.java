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

    public void recordWin(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        wins++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        points += 3;
    }

    public void recordDraw(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        draws++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        points += 1;
    }

    public void recordLoss(int goalsScored, int goalsConceded) {
        gamesPlayed++;
        losses++;
        goalsFor += goalsScored;

    }
}
