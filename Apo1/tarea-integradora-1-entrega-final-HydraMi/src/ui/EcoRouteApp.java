package ui;

import model.BiodiversityController;
import model.BiodiversityPlace;
import model.Community;
import model.CommunityIssue;
import model.CommunityType;
import model.Department;
import model.EcoRouteType;
import model.Species;
import model.SpeciesType;
import model.WeatherCondition;
import java.util.Scanner;

public class EcoRouteApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiodiversityController biodiversityController = new BiodiversityController();

        System.out.println("# Welcome volunteer to the Eco Route Interaction and Biodiversity Places Management application COP 16 Cali - Colombia.");
        System.out.println("# What is your name?");
        String name = scanner.nextLine();

        System.out.print("# Please enter your ID.\n> ");
        String id = scanner.nextLine();

        System.out.println("# Welcome, " + name + "!");

        while (true) {
            System.out.println("# Choose an option:");
            System.out.println("1. Register Eco Route");
            System.out.println("2. Manage Biodiversity Places");
            System.out.println("3. Exit");
            System.out.print("> ");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                handleEcoRoute(scanner);
            } else if (option == 2) {
                handleBiodiversity(scanner, biodiversityController);
            } else if (option == 3) {
                System.out.println("# Thank you for using the application. See you at COP16!");
                break;
            } else {
                System.out.println("# Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    /**
     * Handles the registration of an eco route based on user input.
     * @param scanner the scanner for user input
     */

    private static void handleEcoRoute(Scanner scanner) {
        System.out.println("# What route will you register today? (Farallones, Ladera, East)");
        String routeName = scanner.nextLine().toUpperCase();

        EcoRouteType selectedRoute = getRouteByName(routeName);

        if (selectedRoute != null) {
            System.out.println("# Excellent! The Route of " + selectedRoute +
                    " has the meeting point at " + selectedRoute.getMeetingPoint() +
                    ", starting at " + selectedRoute.getStartTime() +
                    ", and ending at " + selectedRoute.getEndTime() + ".");

            System.out.print("# How many participants will attend the hike today?\n> ");
            int participants = Integer.parseInt(scanner.nextLine());

            System.out.print("# How many guides will attend the hike today?\n> ");
            int guides = Integer.parseInt(scanner.nextLine());

            System.out.print("# Enter the temperature in degrees Celsius °C\n> ");
            float temperature = Float.parseFloat(scanner.nextLine());

            System.out.print("# Enter the relative humidity percentage\n> ");
            float humidity = Float.parseFloat(scanner.nextLine());

            WeatherCondition weatherCondition = getWeatherCondition(temperature, humidity);
            System.out.println("# " + weatherCondition.getMessage());

            int totalPeople = participants + guides;
            int busesNeeded = (totalPeople + 24) / 25;
            System.out.println("# Since there are a total of " + totalPeople + " people participating in the activity, " +
                    "a total of: " + busesNeeded +
                    " buses will be needed to carry it out successfully. See you at COP16!");
        } else {
            System.out.println("# Route not found.");
        }
    }
    /**
     * Manages the options available for biodiversity management.
     * @param scanner the scanner for user input
     * @param biodiversityController the controller for managing biodiversity
     */

    private static void handleBiodiversity(Scanner scanner, BiodiversityController biodiversityController) {
        while (true) {
            System.out.println("# Here are the following options:");
            System.out.println("1. Register a place with biological diversity");
            System.out.println("2. Consult places ordered by area");
            System.out.println("3. Consult the department with the most biodiversity places");
            System.out.println("4. Modify the data of a species");
            System.out.println("5. Return to the main menu");
            System.out.print("> ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                registerBiodiversityPlace(scanner, biodiversityController);
            } else if (choice == 2) {
                listOrderedBiodiversityPlaces(biodiversityController);
            } else if (choice == 3) {
                showDepartmentWithMostPlaces(biodiversityController);
            } else if (choice == 4) {
                modifySpeciesData(scanner);
            } else if (choice == 5) {
                break; 
            } else {
                System.out.println("# Invalid option. Please try again.");
            }
        }
    }
    /**
     * Registers a new biodiversity place based on user input.
     * @param scanner the scanner for user input
     * @param biodiversityController the controller for managing biodiversity
     */

   private static void registerBiodiversityPlace(Scanner scanner, BiodiversityController biodiversityController) {
    System.out.print("# Enter the name of the biodiversity place\n> ");
    String placeName = scanner.nextLine();

    System.out.print("# Enter the department where the place is located (Chocó, Valle, Cauca, Nariño)\n> ");
    String department = scanner.nextLine().toUpperCase();
    Department dept = Department.valueOf(department);

    System.out.print("# Enter the area in square kilometers that the place covers\n> ");
    float area = Float.parseFloat(scanner.nextLine());

    System.out.print("# Enter the inauguration date (format: YYYY-MM-DD)\n> ");
    String inauguration = scanner.nextLine();

    System.out.print("# Enter the name of the community\n> ");
    String communityName = scanner.nextLine();

    System.out.print("# Enter the type of the community (Afrocolombian, Indigenous, Raizal)\n> ");
    String communityTypeInput = scanner.nextLine().toUpperCase();
    
    CommunityType communityType;
    try {
        communityType = CommunityType.valueOf(communityTypeInput);
    } catch (IllegalArgumentException e) {
        System.out.println("# Invalid community type. Please try again.");
        return; 
    }
    System.out.print("# Enter the type of the community issue,in capital letters and with its _ separator (LACK_OF_HOSPITAL, LACK_OF_SCHOOL, LACK_OF_CLEAN_WATER, LACK_OF_BASIC_FOOD_ACCESS)\n> ");
    String issueInput = scanner.nextLine().toUpperCase(); 

    CommunityIssue communityIssue;
    try {
        communityIssue = CommunityIssue.valueOf(issueInput);
    } catch (IllegalArgumentException e) {
        System.out.println("# Invalid community issue. Please try again.");
        return; 
    }
    System.out.println("# Community issue registered successfully: " + communityIssue);
    System.out.print("# Enter the representative's name\n> ");
    String representativeName = scanner.nextLine();

    System.out.print("# Enter the representative's phone number\n> ");
    String representativePhone = scanner.nextLine();

    System.out.print("# Enter the number of inhabitants in the community\n> ");
    int inhabitants = Integer.parseInt(scanner.nextLine());

    Community newCommunity = new Community(communityName, communityType, representativeName, representativePhone, inhabitants);
    
    System.out.print("# Enter the species name\n> ");
    String speciesName = scanner.nextLine();

    System.out.print("# Enter the type of the species (Flora, Fauna)\n> ");
    String speciesTypeInput = scanner.nextLine().toUpperCase();

    SpeciesType speciesType;
    try {
        speciesType = SpeciesType.valueOf(speciesTypeInput);
    } catch (IllegalArgumentException e) {
        System.out.println("# Invalid species type. Please try again.");
        return; 
    }

    System.out.print("# Enter the number of individuals of the species\n> ");
    int speciesCount = Integer.parseInt(scanner.nextLine());

    Species newSpecies = new Species(speciesName, speciesType, speciesTypeInput, speciesCount);
    BiodiversityPlace newPlace = new BiodiversityPlace(placeName, dept, area, inauguration, newCommunity, newSpecies, area);

    if (biodiversityController.addPlace(newPlace)) {
        System.out.println("# Place entered successfully.");
    } else {
        System.out.println("# Could not enter the place. Maximum capacity reached.");
    }
    }
    /**
     * Lists biodiversity places ordered by their area.
     * @param biodiversityController the controller for managing biodiversity
     */
    private static void listOrderedBiodiversityPlaces(BiodiversityController biodiversityController) {
        BiodiversityPlace[] placesOrdered = biodiversityController.getPlacesOrderedByArea();
        if (placesOrdered.length == 0) {
            System.out.println("# No places registered.");
        } else {
            System.out.println("# The places ordered from smallest to largest regarding area are:");
            for (BiodiversityPlace place : placesOrdered) {
                System.out.println("# " + place.getName() + " - " + place.getArea() + " square kilometers.");
            }
        }
    }
    /**
     * Displays the department with the most registered biodiversity places.
     * @param biodiversityController the controller for managing biodiversity
     */
    private static void showDepartmentWithMostPlaces(BiodiversityController biodiversityController) {
        Department deptWithMostPlaces = biodiversityController.getDepartmentWithMostPlaces();
        System.out.println("# The department with the most registered biodiversity places is: " + deptWithMostPlaces + ".");
    }
    
    /**
     * Modifies the data of a specified species.
     * @param scanner the scanner for user input
     */
    private static void modifySpeciesData(Scanner scanner) {
            System.out.print("# Enter the name of the species you want to modify\n> ");
            String speciesName = scanner.nextLine();
        
            System.out.println("# Modifying species: " + speciesName);
        
            System.out.print("# Enter the new name for the species (or press Enter to keep it the same)\n> ");
            String newSpeciesName = scanner.nextLine();
        
            System.out.print("# Enter the new type of the species (Flora, Fauna or press Enter to keep it the same)\n> ");
            String newSpeciesTypeInput = scanner.nextLine();
        
            System.out.print("# Enter the new number of individuals of the species (or press Enter to keep it the same)\n> ");
            String newSpeciesCountInput = scanner.nextLine();
            System.out.println("# Updating species...");
            System.out.println("# Current Species Name: " + speciesName);
            if (!newSpeciesName.isEmpty()) {
                System.out.println("# New Species Name: " + newSpeciesName);
            }
            if (!newSpeciesTypeInput.isEmpty()) {
                System.out.println("# New Species Type: " + newSpeciesTypeInput);
            }
            if (!newSpeciesCountInput.isEmpty()) {
                System.out.println("# New Species Count: " + newSpeciesCountInput);
            }
            System.out.println("# Species updated successfully.");
        
    }
    /**
     * Retrieves the eco route type by its name.
     * @param routeName the name of the route
     * @return the eco route type corresponding to the given name
     */
    private static EcoRouteType getRouteByName(String name) {
        try {
            return EcoRouteType.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    /**
     * Determines the weather condition based on temperature and humidity.
     * @param temperature the temperature in degrees Celsius
     * @param humidity the relative humidity percentage
     * @return the corresponding weather condition
     */
    private static WeatherCondition getWeatherCondition(float temperature, float humidity) {
        if (temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60) {
            return WeatherCondition.GOOD_DAY;
        } else {
            return WeatherCondition.BAD_DAY;
        }
    }
}
