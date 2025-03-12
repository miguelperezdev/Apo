package ui;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that represents a biodiverse place with its name, department, and area in square kilometers.
 */
class BiodiversePlace {
    String placeName;
    String placeDepartment;
    Double kmPlaces;

    /**
     * Description: Constructor that initializes a biodiverse place with its name, department, and area in square kilometers.
     * @param placeName       The name of the biodiverse place.
     * @param placeDepartment The department where the place is located.
     * @param kmPlaces        The number of square kilometers of the place.
     */
    BiodiversePlace(String placeName, String placeDepartment, Double kmPlaces) {
        this.placeName = placeName;
        this.placeDepartment = placeDepartment;
        this.kmPlaces = kmPlaces;
    }
}

/**
 * Main class for managing the registered biodiverse places.
 */
public class BiodiversityPlaceManagement {
    private Scanner scanner;
    private BiodiversePlace[] places;
    private int placeCounter;

    /**
     * Constructor of the BiodiversityPlaceManagement class.
     * Description: Initializes the BiodiversityPlaceManagement object with a scanner and an array to store up to 30 biodiverse places.
     */
    public BiodiversityPlaceManagement() {
        scanner = new Scanner(System.in);
        places = new BiodiversePlace[30];
        placeCounter = 0;
    }

    /**
     * Main method that runs the biodiverse place management program.
     * Description: Displays the main menu and handles the user's selected options to register places, show ordered places, or show the department with the most places.
     */
    public void run() {
        boolean flag = false;
        while (!flag) {
            System.out.println("\n# Welcome, volunteer, to the Biodiverse Place Management Application for COP 16 Cali - Colombia.");
            System.out.println("# Here are your options, enter:");
            System.out.println("# 1. Register a biodiverse place");
            System.out.println("# 2. View places ordered from smallest to largest with respect to area");
            System.out.println("# 3. View the department with the most biodiverse places registered so far");
            System.out.println("# 4. Exit the program");

            System.out.print("> ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerPlace();
                    break;
                case 2:
                    showPlacesByArea();
                    break;
                case 3:
                    showDepartmentWithMostPlaces();
                    break;
                case 4:
                    flag = true;
                    System.out.println("# Thank you for using the system.");
                    break;
                default:
                    System.out.println("# Please enter a valid option.");
                    break;
            }
        }
    }

    /**
     * Description: Allows the user to register a biodiverse place, validating that the provided information is not empty and that the values are correct.
     */
    private void registerPlace() {
        if (placeCounter < 30) {
            String name;
            String department;
            Double km;

            // Validate that the name is not empty
            do {
                System.out.print("# Enter the name of the biodiverse place:\n> ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("# The name cannot be empty.");
                }
            } while (name.isEmpty());

            // Validate that the department is one of the allowed ones and is not empty
            do {
                System.out.print("# Enter the department where the place is located (Valle, Choco, Cauca, Narino):\n> ");
                department = scanner.nextLine().trim().toLowerCase();
                if (department.isEmpty()) {
                    System.out.println("# The department cannot be empty.");
                } else if (!department.equals("valle") && !department.equals("choco") &&
                           !department.equals("cauca") && !department.equals("narino")) {
                    System.out.println("# Invalid department. It must be one of the following: Valle, Choco, Cauca, Narino.");
                    department = "";
                }
            } while (department.isEmpty());

            // Validate that the number of kilometers is a valid number
            do {
                System.out.print("# Enter the number of square kilometers of the place:\n> ");
                if (scanner.hasNextDouble()) {
                    km = scanner.nextDouble();
                    if (km <= 0) {
                        System.out.println("# The number of kilometers must be greater than 0.");
                        km = null;
                    }
                } else {
                    System.out.println("# You must enter a valid numeric value for kilometers.");
                    km = null;
                    scanner.next(); // Consume the invalid input
                }
                scanner.nextLine(); // Consume the newline after the number
            } while (km == null);

            places[placeCounter] = new BiodiversePlace(name, department, km);
            placeCounter++;
            System.out.println("# Place successfully registered.");
        } else {
            System.out.println("# No more places can be registered. Limit reached.");
        }
    }

    /**
     * Description: Orders and displays the registered biodiverse places from smallest to largest according to their area in square kilometers.
     */
    private void showPlacesByArea() {
        if (placeCounter == 0) {
            System.out.println("# No places are registered.");
            return;
        }

        BiodiversePlace[] sortedPlaces = Arrays.copyOf(places, placeCounter);
        Arrays.sort(sortedPlaces, (p1, p2) -> p1.kmPlaces.compareTo(p2.kmPlaces));

        System.out.println("# Places ordered from smallest to largest with respect to area are:");
        for (BiodiversePlace place : sortedPlaces) {
            System.out.println(place.placeName + " - " + place.kmPlaces + " square kilometers.");
        }
    }

    /**
     * Description: Calculates and shows the department with the highest number of registered biodiverse places.
     */
    private void showDepartmentWithMostPlaces() {
        if (placeCounter == 0) {
            System.out.println("# No places are registered.");
            return;
        }

        int valleCount = 0, chocoCount = 0, caucaCount = 0, narinoCount = 0;

        for (int i = 0; i < placeCounter; i++) {
            switch (places[i].placeDepartment) {
                case "valle":
                    valleCount++;
                    break;
                case "choco":
                    chocoCount++;
                    break;
                case "cauca":
                    caucaCount++;
                    break;
                case "narino":
                    narinoCount++;
                    break;
            }
        }

        String mostPlacesDept = "valle";
        int maxCount = valleCount;

        if (chocoCount > maxCount) {
            mostPlacesDept = "choco";
            maxCount = chocoCount;
        }
        if (caucaCount > maxCount) {
            mostPlacesDept = "cauca";
            maxCount = caucaCount;
        }
        if (narinoCount > maxCount) {
            mostPlacesDept = "narino";
            maxCount = narinoCount;
        }

        System.out.println("# The department with the most biodiverse places registered is:");
        System.out.println("# " + mostPlacesDept + ", with " + maxCount + " biodiverse places.");
    }

    /**
     * Description: Creates an instance of BiodiversityPlaceManagement and runs the run method to start the program.
     * @param args Program arguments.
     */
    public static void main(String[] args) {
        BiodiversityPlaceManagement mainApp = new BiodiversityPlaceManagement();
        mainApp.run();
    }
}
