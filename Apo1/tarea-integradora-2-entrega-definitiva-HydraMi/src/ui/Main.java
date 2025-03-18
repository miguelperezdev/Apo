package ui;
import java.util.Scanner;
import model.ControllerSoccer;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ControllerSoccer controller;

    public static void main(String[] args) {
        createControllerSoccer();

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    addReferee();
                    break;
                case 4:
                    preloadInformation();
                    break;
                case 5:
                    generateFixture();
                    break;
                case 6:
                    registerMatchScore();
                    break;
                case 7:
                    registerGoal();
                    break;
                case 8:
                    assignCardToPlayer();
                    break;
                case 9:
                    getAllStandings();
                    break;
                case 10:
                    displayTheTopScorer();
                    break;
                case 11:
                    displayTeamFairPlay();
                    break;
                case 12: 
                    displayTeamEfficiency();
                    break;
                case 13: 
                    displayPlayerEfficiency();
                    break;
                case 14:
                    displayRefereeCardIndex();
                case 15:
                    System.out.println("thanks for use the program...");
                    return;

                default:
                    if (choice < 1 || choice > 15) {
                        System.out.println("Invalid option, please select a number between 1 and 15");
                    }
            }
        }
    }

    /**
     * Displays the menu options to the user.
     * <pre>
     * pre: None
     * post: The menu options are displayed on the screen.
     * </pre>
     */
    private static void showMenu() {
        System.out.println("1. Register Team");
        System.out.println("2. Add Player");
        System.out.println("3. Add Referee");
        System.out.println("4. Preload information");
        System.out.println("5. Generate fixture and assign the referees");
        System.out.println("6. Register the match score");
        System.out.println("7. Register goal");
        System.out.println("8. Assign card to player");
        System.out.println("9. Consult group stage information");
        System.out.println("10. Display the top scorer");
        System.out.println("11. Display the team with more fair play");
        System.out.println("12. Display the team with most efficience");
        System.out.println("13. Display the player with most efficience");
        System.out.println("14. Display the referee card index");
        System.out.println("15. exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Creates a ControllerSoccer instance.
     * <pre>
     * pre: The organizer's name is provided by the user.
     * post: A new instance of ControllerSoccer is created with the provided organizer name.
     * </pre>
     */
    public static void createControllerSoccer() {
        System.out.print("Add the name of the organizer: ");
        String organizatorName = scanner.nextLine();
        System.out.println("Start date of the tournament 11/01/2024 ");
        System.out.println("End date of the tournament 11/31/2024 ");
        controller = new ControllerSoccer(organizatorName);
    }
    /**
     * Registers a team based on user input.
     * <pre>
     * pre: The team name must be unique and not already registered.
     * post: The team is successfully registered in the controller if the name is unique.
     * </pre>
     */
    public static void registerTeam() {
        System.out.println("Enter the team name:");
        String nameTeam = scanner.nextLine();
        if (controller.searchTeam(nameTeam) != null) {
            System.out.println("The team already exists.");
            return;
        }
        System.out.println("Enter the team country: ");
        String countryTeam = scanner.nextLine();
        System.out.println("Enter the name of the coach for the team: ");
        String nameDt = scanner.nextLine();
        System.out.println("Enter the name of the assistant coach for the team: ");
        String assistantCoach = scanner.nextLine();

        controller.addTeam(nameTeam, countryTeam, nameDt, assistantCoach);
        System.out.println("Team registered successfully");
    }

    /**
     * Adds a player to a team based on user input.
     * <pre>
     * pre: The player ID must be unique and valid.
     * post: The player is added to the specified team if the ID is unique and position is valid.
     * </pre>
     */
    public static void addPlayer() {
        while (true) {
            System.out.print("Enter Player ID: ");
            String playerId = scanner.nextLine();

            if (!controller.validateUniquePerson(playerId)) {
                System.out.println("Player ID already exists. Please enter a unique ID.");
                continue; 
            }

            System.out.print("Enter Player Name: ");
            String playerName = scanner.nextLine();
            System.out.print("Enter your number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Player Country: ");
            String playerCountry = scanner.nextLine();

            String positionInput;
            while (true) {
                System.out.print("Choose Player Position (FORWARD, MIDFIELDER, DEFENDER, GOALKEEPER): ");
                positionInput = scanner.nextLine().toUpperCase();
                if (controller.isValidPosition(positionInput)) { 
                    break; 
                } else {
                    System.out.println("Invalid position. Please enter a valid position.");
                }
            }

            System.out.print("Enter the team for the player: ");
            String teamName = scanner.nextLine();

            String result = controller.addPerson(teamName, playerId, playerName, number, playerCountry, positionInput);
            System.out.println(result);

            System.out.println("Do you want to add another player (yes/no)? ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break; 
            }
        }
    }

    /**
     * Adds a referee based on user input.
     * <pre>
     * pre: The referee ID must be unique and valid.
     * post: The referee is added if the ID is unique and the referee type is valid.
     * </pre>
     */
    public static void addReferee() {
        System.out.print("Enter Referee ID: ");
        String refereeId = scanner.nextLine();

        if (!controller.validateUniquePerson(refereeId)) {
            System.out.println("Referee ID already exists. Please enter a unique ID.");
            return;
        }

        System.out.print("Enter Referee Name: ");
        String refereeName = scanner.nextLine();
        System.out.print("Enter Referee Country: ");
        String refereeCountry = scanner.nextLine();
        System.out.print("Enter Matches Officiated: ");
        int matchesOfficiated = scanner.nextInt();
        scanner.nextLine();
        
        String refereeTypeInput;
        while (true) {
            System.out.print("Choose Referee Type (CENTRAL, ASSISTANT): ");
            refereeTypeInput = scanner.nextLine().toUpperCase();
            
            if (controller.isValidRefereeType(refereeTypeInput)) {
                break; 
            } else {
                System.out.println("Invalid referee type. Please enter a valid type.");
            }
        }

        String result = controller.addPerson(refereeId, refereeName, refereeCountry, matchesOfficiated, refereeTypeInput);
        System.out.println(result);
    }

    /**
     * Preloads information into the controller.
     * <pre>
     * pre: None
     * post: Information is preloaded successfully.
     * </pre>
     */
    public static void preloadInformation() {
        String result = controller.preloadInformation();
        System.out.println("Result of the preload:");
        System.out.println(result);
    }

    /**
     * Generates the fixture for the matches.
     * <pre>
     * pre: The teams must be registered.
     * post: The fixture is generated successfully and displayed.
     * </pre>
     */
    public static void generateFixture() {
        String result = controller.generateFixture();
        System.out.println(result);
    }

    /**
     * Registers the score of a match based on user input.
     * <pre>
     * pre: A valid match index and scores must be provided.
     * post: The match score is registered successfully.
     * </pre>
     */
    public static void registerMatchScore() {
        System.out.print("Enter the index of the match (0 - 11): ");
        int matchIndex = scanner.nextInt();

        System.out.print("Enter the home team score: ");
        int homeScore = scanner.nextInt();

        System.out.print("Enter the away team score: ");
        int awayScore = scanner.nextInt();

        String result = controller.registerMatchScore(matchIndex, homeScore, awayScore);
        System.out.println(result);
    }
    /**
     * Registers a goal scored in a specific match, including details of the scorer, assistant, and minute.
     * <pre>
     * pre: A valid match index, scorer ID, assistant ID, and goal minute must be provided.
     * post: The goal is recorded in the system with all its details.
     * </pre>
     */
    public static void registerGoal(){
        System.out.println("Enter the index of the match (0-11): ");
        int matchIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the id player that do the goal: ");
        String idScorer = scanner.nextLine();
        System.out.println("Enter the id player that do the assistance goal: ");
        String idAssistant= scanner.nextLine();
        System.out.print("Enter the minute the goal was scored: ");
        int minute = scanner.nextInt(); 
        
        String result = controller.registerGoal(matchIndex, idScorer, idAssistant, minute);
        System.out.println(result); 
    }

    /**
     * Assigns a card (yellow or red) to a player during a match.
     * <pre>
     * pre: A valid player ID, card type, referee name, minute, and match index must be provided.
     * post: The card is assigned to the player, and if red, the player is marked as expelled from the match.
     * </pre>
     */
    public static void assignCardToPlayer(){
        System.out.println("Enter the ID of the player: ");
        String id= scanner.nextLine();
        System.out.println("Choose the type card: ");
        System.out.println("1. YELLOW");
        System.out.println("2. RED");
        System.out.println("Option: ");
        int card= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the referee:");
        String refereeName= scanner.nextLine();
        System.out.println("Enter the minute the card was shown: ");
        int minute= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the index of the match:");
        int matchIndex= scanner.nextInt();
        scanner.nextLine();
        String result= controller.assignCardToPlayer(id, card, minute, refereeName, matchIndex);
        System.out.println(result);
        if(card == 2){
            System.out.println("The player was expelled of the match.");
        }
    /**
     * Displays the standings of all groups in the tournament.
     * <pre>
     * pre: The group standings data must exist in the system.
     * post: The standings are displayed to the user.
     * </pre>
     */
    }
    public static void getAllStandings(){
        String getStanding= controller.getGroupStandings();
        System.out.println(getStanding);
    }
    /**
     * Displays the team with the best Fair Play score in the tournament.
     * <pre>
     * pre: The Fair Play scores must have been calculated for all teams.
     * post: The team with the best Fair Play score is displayed to the user.
     * </pre>
     */
    public static void displayTheTopScorer(){
        String result= controller.getTopScorer();
        System.out.println(result);
    }
    /**
     * Displays the efficiency of a specific team in the tournament.
     * <pre>
     * pre: The team name must exist in the system, and efficiency data must be available.
     * post: The efficiency of the specified team is displayed to the user.
     * </pre>
     */
    public static void displayTeamFairPlay(){
        String display= controller.getFairPlayTeam();
        System.out.println(display);
    }
    /**
     * Displays the efficiency of a specific player in the tournament.
     * <pre>
     * pre: A valid player ID must be provided, and the player's efficiency data must be available.
     * post: The efficiency of the specified player is displayed to the user.
     * </pre>
     */
    public static void displayTeamEfficiency() {
        System.out.print("Enter team name to check efficiency: ");
        String teamName = scanner.nextLine();
        System.out.println(controller.getTeamEfficiency(teamName));
    }
    public static void displayPlayerEfficiency() {
        System.out.print("Enter player ID to check efficiency: ");
        String playerId = scanner.nextLine();  
        System.out.println(controller.getPlayerEfficiency(playerId));
    }
    public static void displayRefereeCardIndex() {
        System.out.print("Enter referee name to check card index: ");
        String refereeName = scanner.nextLine(); 
        System.out.println(controller.getRefereeCardIndex(refereeName));
    }
}