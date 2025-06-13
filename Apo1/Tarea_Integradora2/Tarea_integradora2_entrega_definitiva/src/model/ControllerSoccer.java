package model;
import java.util.ArrayList;

public class ControllerSoccer {
    private String startDate;
    private Person[] people;
    public Team[] memoryTeams;
    private int personCount;
    private int teamCount;
    private Match[] matches;
    private int matchesCount;
    private String fixtureOutput;
    private ArrayList<Goal> goals;
    private ArrayList<RegisterCard> registerCards;

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
        this.startDate = "11/01/2024";
        this.people = new Person[188];
        this.memoryTeams = new Team[8];
        this.personCount = 0;
        this.teamCount = 0;
        this.matches = new Match[20];
        this.matchesCount = 0;
        this.fixtureOutput = "";
        new ArrayList<>();
        goals = new ArrayList<>();
        registerCards = new ArrayList<>();
       new Group(memoryTeams);
    }

    public String addTeam(String teamName, String country, String coachName, String assistantCoach) {
        for (int i = 0; i < teamCount; i++) {
            if (memoryTeams[i].getTeamName().equalsIgnoreCase(teamName)) {
                return "Team already exists.";
            }
        }

        if (teamCount >= memoryTeams.length) {
            return "Cannot add team: memory full.";
        }

        Team newTeam = new Team(teamName, country, coachName, assistantCoach);
        memoryTeams[teamCount] = newTeam;
        teamCount++;

        return "Team added successfully: " + newTeam.toString();
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
     * 
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

        Team team = searchTeam(teamName);
        if (team == null) {
            String availableTeams = "Available teams: ";
            boolean first = true;
            for (Team t : memoryTeams) {
                if (t != null) {
                    if (!first) {
                        availableTeams += ", ";
                    }
                    availableTeams += t.getTeamName();
                    first = false;
                }
            }
            return "Error: Team '" + teamName + "' not found. " + availableTeams;
        }

        if (!validateUniquePerson(id)) {
            added += "The player already exists.";
        } else {
            Player newPlayer = new Player(id, name, number, country, position);
            if (team.addPlayer(newPlayer)) {
                added += "The player was added to the team " + teamName + ".";
            } else {
                added += "Unable to add player to the team " + teamName + " as the team is full.";
            }
        }

        return added;
    }

    /**
     * Validates if the given position is valid.
     * 
     * <pre>
     * pre: A position string must be provided.
     * post: Returns true if the position is valid; otherwise, false.
     * </pre>
     */
    public boolean isValidPosition(String positionInput) {

        for (Position position : Position.values()) {
            if (position.name().equalsIgnoreCase(positionInput)) {
                return true;
            }
        }
        return false;
    }

    public Person findPlayerById(String id) {
        for (int i = 0; i < personCount; i++) {
            if (people[i] instanceof Player) {
                Player player = (Player) people[i];
                if (player.getId().equals(id)) { 
                    return player; 
                }
            }
        }
        return null; 
    }
    

    /**
     * Adds a referee to the system.
     * 
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
     * 
     * <pre>
     * pre: A referee type string must be provided.
     * post: Returns true if the referee type is valid; otherwise, false.
     * </pre>
     */
    public boolean isValidRefereeType(String refereeType) {
        for (RefereeType type : RefereeType.values()) {
            if (type.name().equalsIgnoreCase(refereeType)) {
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
     * @param nameTeam       The name of the team.
     * @param countryTeam    The country of the team.
     * @param nameDt         The name of the head coach.
     * @param assistantCoach The name of the assistant coach.
     * @return true if the team was saved, otherwise false.
     */
    public String saveTeamMemory(String nameTeam, String countryTeam, String nameDt, String assistantCoach) {
        Team team = new Team(nameTeam, countryTeam, nameDt, assistantCoach);
        for (int i = 0; i < memoryTeams.length; i++) {
            if (memoryTeams[i] == null) {
                memoryTeams[i] = team;
                return "Team '" + nameTeam + "' saved successfully.";
            }
        }
        return "Error: Unable to save team. Memory full.";
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
        String result = "";
        int existingTeams = countExistingTeams(); 
        int existingReferees = countExistingReferees(); 
        
        // Bucle para agregar los equipos existentes
        for (int i = 0; i < existingTeams; i++) {
            Team team = memoryTeams[i];
            result += completeTeamData(team); 
            result += getTeamData(team); 
        }
    
        // Países disponibles para asignar a los equipos y jugadores
        String[] countries = {"Argentina", "Brasil", "Chile", "Colombia", "Uruguay", "Perú", "Paraguay", "Venezuela", "Ecuador", "Bolivia", "México", "Estados Unidos"};
        
        // Agregar equipos nuevos (hasta un máximo de 8)
        for (int i = existingTeams; i < existingTeams + 8; i++) {
            if (personCount + 20 > 180) break;  // Limite de jugadores (180 personas en total)
    
            // Usamos el índice `i % countries.length` para asignar los países cíclicamente
            String teamCountry = countries[i % countries.length]; 
            String playerCountry = countries[i % countries.length];  // Asignamos el mismo país al equipo y a los jugadores
            
            // Crear el nuevo equipo
            Team newTeam = new Team("Team_" + (i + 1), teamCountry, "Coach_Team_" + (i + 1), "Assistant_Team_" + (i + 1));
    
            // Crear jugadores para el equipo
            for (int j = 0; j < 20; j++) {
                if (personCount >= 180) break;  // Si ya se alcanzaron los 180 jugadores, salimos
    
                // Crear un jugador con el país correspondiente
                Player player = new Player(
                    "ID_" + newTeam.getTeamName() + "_" + (j + 1),
                    "Player_" + newTeam.getTeamName() + "_" + (j + 1),
                    j + 1,
                    playerCountry, 
                    Position.values()[j % Position.values().length]  // Asignar una posición cíclica
                );
    
                // Añadir jugador a la lista de personas
                people[personCount++] = player;
                newTeam.addPlayer(player);  // Añadir el jugador al equipo
            }
    
            // Añadir el nuevo equipo a la memoria
            memoryTeams[teamCount++] = newTeam; 
            result += getTeamData(newTeam);  // Añadir los datos del equipo al resultado
        }
    
        // Agregar árbitros (hasta un máximo de 12)
        int refereeCount = 0; 
        for (int i = existingReferees; refereeCount < 12 && i < countries.length; i++) {
            String refereeCountry = countries[i % countries.length];  // Usamos el mismo ciclo de países para los árbitros
    
            // Crear un árbitro con su país asignado
            Referee referee = new Referee(
                "ID_Referee_" + (i + 1),
                "Referee_" + (i + 1),
                refereeCountry,
                0,  // Asumimos que el árbitro no tiene más estadísticas por el momento
                RefereeType.values()[i % RefereeType.values().length]  // Asignamos un tipo de árbitro cíclico
            );
    
            // Añadir árbitro a la lista de personas
            people[personCount++] = referee;
            refereeCount++; 
            
            result += "Referee added: " + referee.getName() + " from " + referee.getCountry() + "\n";
        }
    
        result += "\nTotal Referees Loaded: " + refereeCount + "\n";
        return result; 
    }
    
    // Completar los jugadores faltantes en un equipo
    private String completeTeamData(Team team) {
        StringBuilder data = new StringBuilder();
        
        int existingPlayers = team.getPlayerCount();  // Número de jugadores ya existentes en el equipo
        int playersToAdd = 20 - existingPlayers;      // Jugadores que faltan para completar el equipo
    
        if (playersToAdd <= 0) {
            data.append("The team ").append(team.getTeamName()).append(" already full with ").append(existingPlayers).append(" players.\n");
            return data.toString();  // No se necesitan más jugadores, el equipo ya está completo
        }
    
        for (int j = 0; j < playersToAdd; j++) {
            if (personCount >= 180) {
                break;  // Si alcanzamos el límite de personas, salimos
            }
            
            // Crear un jugador para completar el equipo
            Player player = new Player(
                "ID_" + team.getTeamName() + "_" + (existingPlayers + j + 1), 
                "Player_" + team.getTeamName() + "_" + (existingPlayers + j + 1), 
                existingPlayers + j + 1, 
                team.getCountry(),
                Position.values()[(existingPlayers + j) % Position.values().length]  // Asignación de posición cíclica
            );
    
            // Añadir jugador al equipo y a la lista de personas
            people[personCount++] = player; 
            team.addPlayer(player); 
        }
    
        data.append("Data complete to the team: ").append(team.getTeamName()).append("\n");
        return data.toString(); 
    }
    
    // Obtener los datos de un equipo específico
    private String getTeamData(Team team) {
        StringBuilder data = new StringBuilder("Team: " + team.getTeamName() + "\n"
                + "Trainer: " + team.getCoachName() + "\n"
                + "Assistant: " + team.getAssistantCoach() + "\n"
                + "Players:\n");
        for (int j = 0; j < team.getPlayerCount(); j++) {
            Player player = team.getPlayers()[j];
            data.append(" - Name: ").append(player.getName())
                    .append(", ID: ").append(player.getId())
                    .append(", Dorsal: ").append(player.getNumber())
                    .append(", Country: ").append(player.getCountry())
                    .append(", Position: ").append(player.getPosition()).append("\n");
        }
        data.append("\n");
        return data.toString();
    }
    
    // Contar equipos existentes en la memoria
    public int countExistingTeams() {
        int count = 0; 
        for (int i = 0; i < memoryTeams.length; i++) {
            if (memoryTeams[i] != null) { 
                count++; 
            }
        }
        return count; 
    }
    
    // Contar árbitros existentes en la lista de personas
    public int countExistingReferees() {
        int count = 0; 
        for (int i = 0; i < people.length; i++) {
            if (people[i] instanceof Referee) { 
                count++; 
            }
        }
        return count; 
    }
    
    
    
    /**
     * Generates the fixture for the group stage of the tournament.
     * 
     * <pre>
     * pre: There must be at least 8 teams and 3 referees available.
     * post: Returns a string representation of the generated fixture.
     * </pre>
     * 
     * @return The fixture output for the group stage or an error message if
     *         conditions are not met.
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

        fixtureOutput += "\n=== Group A ===\n";
        startDate = "10/01/2024";
        generateGroupMatches(groupA);
        

        fixtureOutput += "\n=== Group B ===\n";
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

        for (Team team : group) {
            if (team == null) {
                fixtureOutput += "One of the teams is null in the group.\n";
                return;
            }
        }

        for (int i = 0; i < group.length; i++) {
            for (int j = i + 1; j < group.length; j++) {
                Referee[] referees = assignRefereesForMatch(group[i], group[j], assignedReferees);

                if (referees == null || referees.length < 3) {
                    fixtureOutput += "Failed to assign referees for match between " +
                            group[i].getTeamName() + " and " +
                            group[j].getTeamName() + "\n";
                    continue;
                }

                Match match = new Match(referees[0], referees[1], referees[2],
                        group[i], group[j], startDate, "Location");
                matches[matchesCount++] = match;

                fixtureOutput += "Match: " + match.getHomeTeam().getTeamName() +
                        " vs " + match.getAwayTeam().getTeamName() +
                        " on " + match.getMatchDate() + "\n";
                fixtureOutput += "Referees: " + referees[0].getName() + ", " + referees[0].getCountry() +
                        ", " + referees[1].getName() + ", " + referees[1].getCountry() +
                        ", " + referees[2].getName() + ", " + referees[2].getCountry() + "\n";

                startDate = incrementDate(startDate, 2);
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
     * @param date      The original date as a string.
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
     * @param homeTeam         The home team for the match.
     * @param awayTeam         The away team for the match.
     * @param assignedReferees An array indicating which referees have been
     *                         assigned.
     * @return An array of referees assigned to the match, or null if assignment
     *         fails.
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
            return new Referee[] { centralReferee, assistant1, assistant2 };
        }

        // Resetear árbitros asignados si no se pudo asignar
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
     * @param centralReferee    The central referee for the match.
     * @param assistantReferee1 The first assistant referee.
     * @param assistantReferee2 The second assistant referee.
     * @param homeTeam          The home team for the match.
     * @param awayTeam          The away team for the match.
     * @param matchDate         The date of the match.
     * @param location          The location of the match.
     */
    public void addMatch(Referee centralReferee, Referee assistantReferee1, Referee assistantReferee2,
            Team homeTeam, Team awayTeam, String matchDate, String location) {
        Match match = new Match(centralReferee, assistantReferee1, assistantReferee2, homeTeam, awayTeam, matchDate,
                location);
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
     * @param homeScore  The score for the home team.
     * @param awayScore  The score for the away team.
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

    public String registerGoal(int matchIndex, String idScorer, String idAssistant, int minute) {
        Person scorerPerson = findPlayerById(idScorer);
        Person assistantPerson = (idAssistant != null) ? findPlayerById(idAssistant) : null;
        if (scorerPerson == null || !(scorerPerson instanceof Player)) {
            return "the player doesn't exist";

        } else {
            Player scorer = (Player) scorerPerson;
            Player assistant = (assistantPerson instanceof Player) ? (Player) assistantPerson : null;

            Goal newGoal = new Goal(scorer, assistant, minute);
            goals.add(newGoal);
            scorer.setGoals(scorer.getGoals() + 1);

            return "registered goal: " + newGoal.toString();

        }
    }
    public Person findRefereeByName(String name) {
        for (int i = 0; i < personCount; i++) {
            if (people[i] instanceof Referee) {
                Referee referee = (Referee) people[i];
                if (referee.getName().equals(name)) {
                    return referee;
                }
            }
        }
        return null;
    }
    public Match findMatchById(int matchIndex) {
        if (matchIndex >= 0 && matchIndex < matches.length) {
            return matches[matchIndex];  
        }
        return null;  
    }
    
    
    
    
    public String assignCardToPlayer(String id, int card, int minute, String refereeName, int matchIndex) {
    
        Person person = findPlayerById(id);
        if (person != null && person instanceof Player) {
            Player player = (Player) person;  
        
           
            Person refereePerson = findRefereeByName(refereeName);  
            if (refereePerson != null && refereePerson instanceof Referee) {
                Referee referee = (Referee) refereePerson;  
                
                
                Match match = findMatchById(matchIndex); 
                
                if (referee != null && match != null) {
                    
                    RegisterCard registerCard = new RegisterCard(player, referee, card, minute, match);
                    
                    
                    registerCards.add(registerCard);  
                    
                    return "Assign card successfully to  " + player.getName();
                } else {
                    return "Referee or match don't found.";
                }
            } else {
                return "Referee don't found.";
            }
        } else {
            return "Player don't found.";
        }
    }
    public String getGroupStandings() {
        Group groupStage= new Group(memoryTeams);
        StringBuilder sb = new StringBuilder();
        sb.append("Group Stage Standings:\n");
        sb.append("| Team Name      | Played | Wins | Draws | Losses | GF  | GA  | Points |\n");
    
        for (int i = 0; i < memoryTeams.length; i++) {
            String teamName = memoryTeams[i].getTeamName();
            int played = groupStage.getStats()[i][0];
            int wins = groupStage.getStats()[i][1];
            int draws = groupStage.getStats()[i][2];
            int losses = groupStage.getStats()[i][3];
            int goalsFor = groupStage.getStats()[i][4];
            int goalsAgainst = groupStage.getStats()[i][5];
            int points = groupStage.getStats()[i][6];
    
            sb.append(String.format("| %-14s | %-6d | %-4d | %-5d | %-6d | %-3d | %-3d | %-6d |\n",
                    teamName, played, wins, draws, losses, goalsFor, goalsAgainst, points));
        }
    
        return sb.toString();
    }
    
    public String getTopScorer() {
        Player topScorer = null;
        for (int i = 0; i < personCount; i++) {
            if (people[i] instanceof Player) {
                Player player = (Player) people[i];
                if (topScorer == null || player.getGoals() > topScorer.getGoals()) {
                    topScorer = player;
                }
            }
        }

        if (topScorer != null) {
            return "Top Scorer: " + topScorer.getId() + " with " + topScorer.getGoals() + " goals.";
        } else {
            return "No players found.";
        }
    }
    public String getFairPlayTeam() {
        Team fairPlayTeam = null;
        int fewestCards = Integer.MAX_VALUE;
    
        for (Team team : memoryTeams) {
            if (team != null) {
                int totalCards = 0;
                for (Match match : matches) {
                    if (match != null) {
                        if (match.getHomeTeam() == team || match.getAwayTeam() == team) {
                            for (RegisterCard card : match.getCards()) {
                                if (card.getTeam() == team) {
                                    totalCards++;
                                }
                            }
                        }
                    }
                }
                if (totalCards < fewestCards) {
                    fewestCards = totalCards;
                    fairPlayTeam = team;
                }
            }
        }
        return fairPlayTeam != null ? "Fair Play Team: " + fairPlayTeam.getTeamName() : "No team with Fair Play found";
    }
    
    /**
     * 
     * @param teamName name of the team with the most wins
     * @return return of the team with the most wins
     *
     *<b>Precondition</b>
     *The "teamName" must correspond to an existing team in the tournament, the "matches" array/list must contain valid data.
     *   
     *<b>Postcondition</b>
     *If the team has not played any matches, the method will return "Team has not played any matches", if the team is not found, returns "Team not found".
     */
    public String getTeamEfficiency(String teamName) {
        Team team = findTeamByName(teamName);
        if (team != null) {
            int totalMatches = 0;
            int totalWins = 0;
    
            for (Match match : matches) {
                if (match != null && (match.getHomeTeam() == team || match.getAwayTeam() == team)) {
                    totalMatches++;
                    if ((match.getHomeTeam() == team && match.getHomeTeamScore() > match.getAwayTeamScore()) ||
                        (match.getAwayTeam() == team && match.getAwayTeamScore() > match.getHomeTeamScore())) {
                        totalWins++;
                    }
                }
            }
            return totalMatches > 0 ? "Team " + teamName + 
                                      " Efficiency: " + (totalWins * 100 / totalMatches) + "%" : "Team has not played any matches";
        }
        return "Team not found";
    }
    
    public Team findTeamByName(String teamName){
        for(Team teams : memoryTeams){
            if(teams != null && teams.getTeamName().equalsIgnoreCase(teamName)){
                return teams;
            }
        }
        return null;

    }
    /**
     * 
     * @param playerId id of the player
     * @return return of the player with the most goals
     * 
     *<b>Precondition</b>
     *The "playerId" must correspond to an existing player in the tournament, the "matches" array/list must contain valid data on match participation.
     *   
     *<b>Postcondition</b>
     *If the player has not played any matches, the method will return "Player has not played any matches", if the player is not found, returns "Player not found".
     */
    public String getPlayerEfficiency(String playerId) {
        Person person = findPlayerById(playerId);
        if (person != null && person instanceof Player) {
            Player player = (Player) person;
            
            int totalMatches = 0;
            int totalGoals = 0;
    
            for (Match match : matches) {
                if (match != null && match.isPlayerInMatch(player)) {
                    totalMatches++;
                    totalGoals += player.getGoals();
                }
            }
            return totalMatches > 0 ? 
                   "Player " + player.getName() + " Efficiency: " + (totalGoals * 100 / totalMatches) + "%" 
                   : "Player has not played any matches";
        }
        
        return "Player not found";
    }
    
   /**
     * Retrieves the card index for a central referee based on their performance in matches.
     *
     * <pre>
     * pre: The referee's name must not be null. The matches must be scheduled, and the referees must have officiated them.
     * post: Returns a string containing the referee's card index if the referee is found and is central. 
     *       Returns an appropriate message if the referee is not found or has not officiated any matches.
     * </pre>
     * 
     * @param refereeName The name of the referee to search for.
     * @return A string containing the referee's card index or an appropriate error message.
     */
    public String getRefereeCardIndex(String refereeName) {
        Person referee = findRefereeByName(refereeName);
        
        if (referee != null && referee instanceof Referee && ((Referee) referee).getType() == RefereeType.CENTRAL) {
            int totalMatches = 12;
            int totalCards = 0;

            for (Match match : matches) {
                if (match != null && match.getCentralReferee() == referee) {
                    totalMatches++;
                    totalCards += match.getCardsByReferee((Referee) referee);
                }
            }

            return totalMatches > 0 ? 
                "Referee " + referee.getName() + " Card Index: " + (totalCards * 100 / totalMatches) + "%" 
                : "Referee hasn't officiated any matches";
        }
        
        return "Referee not found or not a central referee";
        }
}




    
    
