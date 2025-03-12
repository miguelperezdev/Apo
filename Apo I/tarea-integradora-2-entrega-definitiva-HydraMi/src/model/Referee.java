package model;

public class Referee extends Person {
    private int matchesOfficiated;
    private RefereeType type;

    public Referee(String id, String name, String country, int matchesOfficiated, RefereeType type) {
        super(id, name, country);
        this.matchesOfficiated = matchesOfficiated;
        this.type= type;
    }
    
    public int getMatchesOfficiated() {
        return matchesOfficiated;
    }

    public void setMatchesOfficiated(int matchesOfficiated) {
        this.matchesOfficiated = matchesOfficiated;
    }

    public RefereeType getType() {
        return type;
    }

    public void setType(RefereeType type) {
        this.type = type;
    }

    

    @Override
    public String toString() {
        return super.toString() + ", Matches Officiated: " + matchesOfficiated + " type referee: " + type;
    }
}
