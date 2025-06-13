package model;

public class Referee extends Person implements Punishable{
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

    public String whistle(int faultLevel) {
        if(type == RefereeType.CENTRAL){
        switch (faultLevel) {
            case 0:
                return "Referee " + getName() + ": verbal amonestation";
            case 1:
                return "Referee " + getName() + ": yellow card";
            case 2:
                return "Referee " + getName() + ": red card";
            default:
                return "fault level no available.";
        }

    }else{
        return "this referee isn't central";
    }
}
    public String upFlag(String fault) {
        if (type == RefereeType.ASSISTANT) { 
            switch (fault) {
                case "outside":
                    return "Assistant referee " + getName() + " raises the flag for outside.";
                case "corner":
                    return "Assistant referee " + getName() + " raises the flag for corner.";
                case "goal kick":
                    return "Assistant referee " + getName() + " raises the flag for goal kick";
                case "lateral kick":
                    return "Assistant referee " + getName() + " raises the flag for lateral kick";
                default:
                    return "fault no valide.";
            }
        } else {
            return "this referee isn't assistant.";
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", Matches Officiated: " + matchesOfficiated + " type referee: " + type;
    }
}
