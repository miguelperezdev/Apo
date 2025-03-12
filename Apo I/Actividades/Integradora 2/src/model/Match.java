package model;

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

    public Match(Referee centralReferee, Referee assistantReferee1, Referee assistantReferee2,
                 Team homeTeam, Team awayTeam, String matchDate, String location) {
        this.centralReferee = centralReferee;
        this.assistantReferee1 = assistantReferee1;
        this.assistantReferee2 = assistantReferee2;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.location = location;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    public Referee getCentralReferee() {
        return centralReferee;
    }

    public Referee getAssistantReferee1() {
        return assistantReferee1;
    }

    public Referee getAssistantReferee2() {
        return assistantReferee2;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getLocation() {
        return location;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getScore() {
        return homeTeam.getTeamName() + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam.getTeamName();
    }

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
}
