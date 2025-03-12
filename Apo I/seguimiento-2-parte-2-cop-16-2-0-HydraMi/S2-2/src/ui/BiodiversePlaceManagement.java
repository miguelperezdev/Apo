package ui;

import java.util.Scanner;

/**
 * Class representing a biodiverse place with its name, department, and budget.
 * Also, the data types are assigned to it.
 */
class BiodiversePlace {
    String placeName;
    String placeDepartment;
    Double placeBudget;

    /**
     * Constructor for the BiodiversePlace class.
     * This is needed to prevent confusion with the class's instance attributes, which have the same names.
     * 
     * @param placeName:       The name of the biodiverse place.
     * @param placeDepartment: The department where the place is located.
     * @param placeBudget:     The budget assigned to the place.
     */
    BiodiversePlace(String placeName, String placeDepartment, Double placeBudget) {
        this.placeName = placeName;
        this.placeDepartment = placeDepartment;
        this.placeBudget = placeBudget;
    }
}

/**
 * Main class to manage registered biodiverse places.
 */
public class BiodiversePlaceManagement {
    private Scanner scanner;
    private BiodiversePlace[] places;
    private int placeCounter;

    /**
     * Constructor for the BiodiversePlaceManagement class.
     * Initializes the scanner and the array of biodiverse places.
     */
    BiodiversePlaceManagement() {
        scanner = new Scanner(System.in);
        places = new BiodiversePlace[10]; 
        placeCounter = 0;
    }

    /**
     * Main method that runs the biodiverse place management program.
     */
    public void run() {
        boolean flag = false;
        while (!flag) {
            System.out.println("\n# Welcome, volunteer, to the Biodiverse Place Management Application for COP 16 Cali - Colombia.");
             System.out.println("# What would you like to do today?");
            System.out.println("# 1. Register a biodiverse place");
             System.out.println("# 2. Consult the average budget per department");
            System.out.println("# 3. Exit the program");

            System.out.print("> ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    registerPlace();
                    break;
                case 2:
                    consultAverage();
                    break;
                case 3:
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
     * Registers a new biodiverse place if the limit of 10 places has not been reached.
     */
    private void registerPlace() {
        if (placeCounter < 10) {
            System.out.print("# Enter the name of the biodiverse place:\n> ");
                String name = scanner.nextLine();
            System.out.print("# Enter the department where the place is located (Valle, Choco, Cauca, or Nariño):\n> ");
                String department = scanner.nextLine().toLowerCase(); 
            System.out.print("# Enter the national budget allocated to this place:\n> ");
                Double budget = scanner.nextDouble();
                scanner.nextLine(); 

            places[placeCounter] = new BiodiversePlace(name, department, budget);
            placeCounter++;
            System.out.println("# Place successfully registered.");
        } else {
            System.out.println("# No more places can be registered. Limit reached.");
        }
    }

    /**
     * Consults and calculates the average budget for a specific department.
     */
    private void consultAverage() {
        System.out.print("# Select one of the four departments to review the average budget: Valle, Choco, Cauca, or Nariño\n> ");
        String department = scanner.nextLine().toLowerCase();
        double totalBudgets = 0.0;
        int count = 0;

        for (int i = 0; i < placeCounter; i++) {
            if (places[i].placeDepartment.equals(department)) {
                totalBudgets += places[i].placeBudget;
                count++;
            }
        }

        if (count > 0) {
            double average = totalBudgets / count;
            String averageMessage = "# The average budget for the department of " + department + " is " + average + " COP";
            System.out.println(averageMessage);
        } else {
            System.out.println("# No places registered in the department of " + department);
        }
    }

    /**
     * Main method to run the application.
     * 
     * @param args Program arguments.
     */
    public static void main(String[] args) {
        BiodiversePlaceManagement mainApp = new BiodiversePlaceManagement();
        mainApp.run();
    }
}
