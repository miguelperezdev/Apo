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
                    scanner.close();
                    return;
                default:
                    if (choice < 1 || choice > 7) {
                        System.out.println("Invalid option");
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
        System.out.println("7. Exit");
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
        System.out.println("Start date of the tournament 10/01/2024 ");
        System.out.println("End date of the tournament 10/31/2024 ");
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

        controller.saveTeamMemory(nameTeam, countryTeam, nameDt, assistantCoach);
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
        System.out.print("Enter the index of the match (0 - 7): ");
        int matchIndex = scanner.nextInt();

        System.out.print("Enter the home team score: ");
        int homeScore = scanner.nextInt();

        System.out.print("Enter the away team score: ");
        int awayScore = scanner.nextInt();

        String result = controller.registerMatchScore(matchIndex, homeScore, awayScore);
        System.out.println(result);
    }
}
