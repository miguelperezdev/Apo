package model;

public class ControllerSoccer {
    private String organizatorName;
    private String startDate;
    private String endDate;
    private Person[] people;
    private Team[] memoryTeams;
    private int personCount;
    private int teamCount;
    private Match[] matches;
    private int matchesCount;
    private String fixtureOutput;

    /**
     * Initializes a new ControllerSoccer instance.
     * 
     * <pre>
     * pre: organizatorName is not null or empty.
     * post: A new ControllerSoccer instance is created with the given organizatorName.
     * </pre>
     * 
     * @param organizatorName The name of the organizer.
     */
    public ControllerSoccer(String organizatorName) {
        this.organizatorName = organizatorName;
        this.startDate = "10/01/2024";
        this.endDate = "11/16/2024";
        this.people = new Person[180];
        this.memoryTeams = new Team[8];
        this.personCount = 0;
        preloadInformation();
        this.teamCount = 0;
        this.matches = new Match[12];
        this.matchesCount = 0;
        this.fixtureOutput= "";
    }
    /**
     * Searches for a team by name.
     * 
     * <pre>
     * pre: teamName is not null or empty.
     * post: Returns the Team object if found, otherwise returns null.
     * </pre>
     * 
     * @param teamName The name of the team to search.
     * @return The found Team object or null.
     */
    public Team searchTeam(String teamName) {
        for (Team team : memoryTeams) {
            if (team != null && team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }
/**
 * Adds a player to a team in the system.
 * <pre>
 * pre: The player ID must be unique, the team must exist, and the position must be valid.
 * post: A player is added to the specified team if the ID is unique and the team is not full.
 * Returns a success or error message.
 * </pre>
 */
    public String addPerson(String teamName, String id, String name, int number, String country, String positionInput) {
        Position position;
    
        if (!isValidPosition(positionInput)) {
            return "Invalid position. Please enter a valid position.";
        }
        
        position = Position.valueOf(positionInput.toUpperCase());
    
        String added = "";
    
        if (!validateUniquePerson(id)) {
            added += "The player already exists.";
        } else {
            Team team = searchTeam(teamName);
            if (team != null) {
                Player newPlayer = new Player(id, name, number, country, position);
                if (team.addPlayer(newPlayer)) {
                    added += "The player was added to the team " + teamName + ".";
                } else {
                    added += "Unable to add player to the team " + teamName + " as the team is full.";
                }
            } else {
                added += "Team not found.";
            }
        }
    
        return added;
    }
    /**
 * Validates if the given position is valid.
 * <pre>
 * pre: A position string must be provided.
 * post: Returns true if the position is valid; otherwise, false.
 * </pre>
 */
    public boolean isValidPosition(String positionInput){

        for(Position position : Position.values()){
            if(position.name().equalsIgnoreCase(positionInput)){
                return true;
            }
        }
        return false;
    }
    
/**
 * Adds a referee to the system.
 * <pre>
 * pre: The referee ID must be unique and the referee type must be valid.
 * post: A referee is added to the system if the ID is unique and the maximum limit has not been reached. 
 * Returns a success or error message.
 * </pre>
 */
    public String addPerson(String id, String name, String country, int matchesOfficiated, String refereeTypeInput) {
       
        if (!isValidRefereeType(refereeTypeInput)) {
            return "Invalid referee type. Please enter a valid type.";
        }
    
        RefereeType refereeType = RefereeType.valueOf(refereeTypeInput.toUpperCase());
    
        if (!validateUniquePerson(id)) {
            return "Error: ID already exists.";
        }
    
        if (personCount < people.length) {
            people[personCount++] = new Referee(id, name, country, matchesOfficiated, refereeType);
            return "Referee added successfully.";
        } else {
            return "Cannot add referee: maximum limit reached.";
        }
    }
    /**
 * Validates if the provided referee type is valid.
 * <pre>
 * pre: A referee type string must be provided.
 * post: Returns true if the referee type is valid; otherwise, false.
 * </pre>
 */
    public boolean isValidRefereeType(String refereeType){
        for(RefereeType type : RefereeType.values()){
            if(type.name().equalsIgnoreCase(refereeType)){
                return true;
            }



        }
        return false;
    }

/**
     * Validates if a person with the given ID already exists.
     * 
     * <pre>
     * pre: id is not null or empty. 
     * post: Returns true if the person is unique, otherwise false.
     * </pre>
     * 
     * @param id The ID to validate.
     * @return true if the ID is unique, otherwise false.
     */
    public boolean validateUniquePerson(String id) {
        for (int i = 0; i < personCount; i++) {
            if (people[i].getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Saves a team in memory.
     * 
     * <pre>
     * pre: nameTeam, countryTeam, nameDt, and assistantCoach are not null or empty. 
     * post: Returns true if the team was saved successfully, otherwise false.
     * </pre>
     * 
     * @param nameTeam The name of the team.
     * @param countryTeam The country of the team.
     * @param nameDt The name of the head coach.
     * @param assistantCoach The name of the assistant coach.
     * @return true if the team was saved, otherwise false.
     */
    public boolean saveTeamMemory(String nameTeam, String countryTeam, String nameDt, String assistantCoach) {
        Team team = new Team(nameTeam, countryTeam, nameDt, assistantCoach);
        for (int i = 0; i < memoryTeams.length; i++) {
            if (memoryTeams[i] == null) {
                memoryTeams[i] = team;
                return true;
            }
        }
        return false;
    }
/**
     * Preloads information about teams and referees.
     * 
     * <pre>
     * pre: None.
     * post: Returns a report of the preloaded teams and referees.
     * </pre>
     * 
     * @return A report of preloaded information.
     */
    public String preloadInformation() {
        String[] teamNames = {"Team A", "Team B", "Team C", "Team D", "Team E", "Team F", "Team G", "Team H"};
        String[] countries = {"Country A", "Country B", "Country C", "Country D", "Country E", "Country F", "Country G", "Country H"};
        String[] coachNames = {"Coach A", "Coach B", "Coach C", "Coach D", "Coach E", "Coach F", "Coach G", "Coach H"};
        String[] assistantCoachNames = {"Assistant A", "Assistant B", "Assistant C", "Assistant D", "Assistant E", "Assistant F", "Assistant G", "Assistant H"};
        Position[] positions = Position.values();
    
        StringBuilder report = new StringBuilder();
    
        report.append("=== Equipos Precargados ===\n");
        for (int i = 0; i < teamNames.length; i++) {
            if (teamCount >= memoryTeams.length) {
                break;
            }
            Team team = new Team(teamNames[i], countries[i], coachNames[i], assistantCoachNames[i]);
            report.append("Team: ").append(teamNames[i]).append(" (").append(countries[i]).append(")\n");
            report.append("Coach: ").append(coachNames[i]).append(", Assistant Coach: ").append(assistantCoachNames[i]).append("\nPlayers:\n");
    
            for (int j = 0; j < 20; j++) {
                String playerId = "Player_" + i + "_" + j;
                String playerName = "Player " + (j + 1) + " of " + teamNames[i];
                int dorsal = j + 1;
                Position position = positions[j % positions.length];
                String playerCountry = countries[i];
    
                Player player = new Player(playerId, playerName, dorsal, playerCountry, position);
                team.addPlayer(player);
    
                report.append("  - ").append(playerName)
                      .append(" (ID: ").append(playerId).append(", Dorsal: ").append(dorsal)
                      .append(", Position: ").append(position).append(", Country: ").append(playerCountry)
                      .append(")\n");
            }
            memoryTeams[teamCount++] = team;
        }
    
        report.append("\n=== Árbitros Precargados ===\n");
        for (int i = 0; i < 12; i++) {
            String refereeId = "Referee_" + i;
            String refereeName = "Referee " + (i + 1);
            String refereeCountry = "Country " + (char) ('A' + (i % countries.length));
            int matchesOfficiated = (i + 1) * 5;
            String refereeTypeInput = (i % 2 == 0) ? "CENTRAL" : "ASSISTANT"; 
    
            if (personCount < people.length) {
                String result = addPerson(refereeId, refereeName, refereeCountry, matchesOfficiated, refereeTypeInput);
                report.append("  - ").append(refereeName)
                      .append(" (ID: ").append(refereeId).append(", Country: ").append(refereeCountry)
                      .append(", Matches Officiated: ").append(matchesOfficiated)
                      .append(", Type: ").append(refereeTypeInput).append(") - ")
                      .append(result).append("\n"); 
            }
        }
    
        return report.toString();
    }
    /**
     * Generates the fixture for the group stage of the tournament.
     * 
     * <pre>
     * pre: There must be at least 8 teams and 3 referees available.
     * post: Returns a string representation of the generated fixture.
     * </pre>
     * 
     * @return The fixture output for the group stage or an error message if conditions are not met.
     */
    public String generateFixture() {
        fixtureOutput = ""; 
    
        if (memoryTeams == null || memoryTeams.length < 8) {
            return "There aren't enough teams.";
        }
    
        if (personCount < 3) {
            return "There aren't enough referees.";
        }
    
        Team[] groupA = new Team[4];
        Team[] groupB = new Team[4];
    
        for (int i = 0; i < 4; i++) {
            groupA[i] = memoryTeams[i]; 
        }
        for (int i = 4; i < 8; i++) {
            groupB[i - 4] = memoryTeams[i]; 
        }
    
        fixtureOutput += "\n=== Grupo A ===\n";
        startDate = "10/01/2024"; 
        generateGroupMatches(groupA);
    
        fixtureOutput += "\n=== Grupo B ===\n";
        generateGroupMatches(groupB);
    
        return fixtureOutput;
    }
    /**
     * Generates the matches for a specific group.
     * 
     * <pre>
     * pre: The group must contain valid teams and referees must be available.
     * post: Updates the fixtureOutput with the matches and their referees.
     * </pre>
     * 
     * @param group An array of teams representing the group.
     */
    public void generateGroupMatches(Team[] group) {
        boolean[] assignedReferees = new boolean[personCount];
    
        for (int i = 0; i < group.length; i++) {
            for (int j = i + 1; j < group.length; j++) {
                Referee[] referees = assignRefereesForMatch(group[i], group[j], assignedReferees);
                if (referees != null && referees.length == 3) {
                    Match match = new Match(referees[0], referees[1], referees[2],
                                            group[i], group[j], startDate, "Location");
                    matches[matchesCount++] = match; 
                    
                    fixtureOutput += "Match: " + match.getHomeTeam().getTeamName() +
                                     " vs " + match.getAwayTeam().getTeamName() +
                                     " on " + match.getMatchDate() + "\n";
                    fixtureOutput += "Referees: " + referees[0].getName() + ", " + referees[1].getName() + ", " + referees[2].getName() + "\n";
                    
                    startDate = incrementDate(startDate, 2);
                } else {
                    fixtureOutput += "Failed to assign referees for match between " +
                                     group[i].getTeamName() + " and " +
                                     group[j].getTeamName() + "\n";
                }
            }
        }
    }
    
/**
     * Increments a date by a specified number of days.
     * 
     * <pre>
     * pre: The date string must be in the format "MM/DD/YYYY".
     * post: Returns the incremented date in "MM/DD/YYYY" format.
     * </pre>
     * 
     * @param date The original date as a string.
     * @param increment The number of days to increment the date by.
     * @return The incremented date as a string.
     */
    
    private String incrementDate(String date, int increment) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[1]);
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[2]);

        day += increment;

        while (day > 30) { 
            day -= 30;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return String.format("%02d/%02d/%04d", month, day, year); 
    }

    /**
     * Assigns referees for a match between two teams.
     * 
     * <pre>
     * pre: The teams must exist and there must be available referees.
     * post: Returns an array of referees assigned to the match, or null if unable to assign.
     * </pre>
     * 
     * @param homeTeam The home team for the match.
     * @param awayTeam The away team for the match.
     * @param assignedReferees An array indicating which referees have been assigned.
     * @return An array of referees assigned to the match, or null if assignment fails.
     */
    public Referee[] assignRefereesForMatch(Team homeTeam, Team awayTeam, boolean[] assignedReferees) {
        Referee centralReferee = null;
        Referee assistant1 = null;
        Referee assistant2 = null;
    
        for (int i = 0; i < personCount; i++) {
            if (people[i] instanceof Referee) {
                Referee referee = (Referee) people[i];
    
                if (!referee.getCountry().equals(homeTeam.getCountry()) && 
                    !referee.getCountry().equals(awayTeam.getCountry()) &&
                    !assignedReferees[i]) {
    
                    if (referee.getType() == RefereeType.CENTRAL && centralReferee == null) {
                        centralReferee = referee;
                    } else if (referee.getType() == RefereeType.ASSISTANT) {
                        if (assistant1 == null) {
                            assistant1 = referee;
                        } else if (assistant2 == null) {
                            assistant2 = referee;
                        }
                    }
    
                    assignedReferees[i] = true;
    
                    if (centralReferee != null && assistant1 != null && assistant2 != null) {
                        break;
                    }
                }
            }
        }
    
        if (centralReferee != null && assistant1 != null && assistant2 != null) {
            return new Referee[]{centralReferee, assistant1, assistant2};
        }
    
        for (int i = 0; i < personCount; i++) {
            if (people[i] instanceof Referee && assignedReferees[i]) {
                assignedReferees[i] = false;
            }
        }
    
        return null; 
    }
     /**
     * Adds a match to the tournament.
     * 
     * <pre>
     * pre: The referees and teams must exist and be valid.
     * post: The match is added to the matches array.
     * </pre>
     * 
     * @param centralReferee The central referee for the match.
     * @param assistantReferee1 The first assistant referee.
     * @param assistantReferee2 The second assistant referee.
     * @param homeTeam The home team for the match.
     * @param awayTeam The away team for the match.
     * @param matchDate The date of the match.
     * @param location The location of the match.
     */
public void addMatch(Referee centralReferee, Referee assistantReferee1, Referee assistantReferee2,
        Team homeTeam, Team awayTeam, String matchDate, String location) {
        Match match = new Match(centralReferee, assistantReferee1, assistantReferee2, homeTeam, awayTeam, matchDate, location);
        matches[matchesCount] = match; 
        matchesCount++; 
}
/**
     * Registers the score for a specific match.
     * 
     * <pre>
     * pre: The match index must be valid and the match must exist.
     * post: The match score is updated with the provided values.
     * </pre>
     * 
     * @param matchIndex The index of the match to register the score for.
     * @param homeScore The score for the home team.
     * @param awayScore The score for the away team.
     * @return A message indicating the success or failure of the operation.
     */
public String registerMatchScore(int matchIndex, int homeScore, int awayScore) {
    if (matchIndex >= 0 && matchIndex < matchesCount) {
        Match match = matches[matchIndex];
        if (match != null) {
            match.setScore(homeScore, awayScore);
            return "Score updated successfully.";
        } else {
            return "Match does not exist."; 
        }
    } else {
        return "Invalid match index."; 
    }
}

/**
     * Retrieves the score for a specific match.
     * 
     * <pre>
     * pre: The match index must be valid and the match must exist.
     * post: Returns the score of the match as a string.
     * </pre>
     * 
     * @param matchIndex The index of the match to retrieve the score for.
     * @return The score of the match or a message if the match is not found.
     */

    public String getMatchScore(int matchIndex) {
        if (matchIndex >= 0 && matchIndex < matchesCount) {
        return matches[matchIndex].getScore(); 
        }
        return "Match not found."; 
    }     
}