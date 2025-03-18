package ui;

import model.*;

import java.util.Scanner;

/**
 * Represents the main menu of the application.
 */
public class MainMenu {
    private RealEstate realEstate;
    private Scanner scanner;

    /**
     * Constructs the MainMenu object.
     */
    public MainMenu() {
        realEstate = new RealEstate();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu.
     */
    public void displayMenu() {
        System.out.println("\nWelcome to the Real Estate Vivendo!\n");
        System.out.println("What would you like to do today?");
        
        int option;
        do {
            System.out.println("1. Register Building");
            System.out.println("2. Register Apartment");
            System.out.println("3. Check Available Apartments");
            System.out.println("4. Check Income for Real Estate and Owners");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    registerBuilding();
                    break;
                case 2:
                    registerApartment();
                    break;
                case 3:
                    checkAvailableApartments();
                    break;
                case 4:
                    checkIncome();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);
    }

    private void registerBuilding() {
        System.out.print("Enter building name: ");
        String name = scanner.nextLine();
        System.out.print("Enter building address: ");
        String address = scanner.nextLine();
        System.out.print("Enter number of apartments: ");
        int apartmentCount = scanner.nextInt();
        scanner.nextLine(); 

        Building building = new Building(name, address, apartmentCount);
        realEstate.addBuilding(building);
    }

    private void registerApartment() {
        System.out.print("Enter building name: ");
        String buildingName = scanner.nextLine();
        Building building = realEstate.getBuilding(buildingName);

        if (building != null) {
            System.out.print("Enter apartment number: ");
            int number = scanner.nextInt();
            System.out.print("Select apartment type\n 1 for PENTHOUSE\n 2 for REGULAR\n 3 for FIRST_FLOOR: ");
            int typeOption = scanner.nextInt();
            ApartmentType type = ApartmentType.values()[typeOption - 1];
            System.out.print("Enter monthly rent: ");
            double monthlyRent = scanner.nextDouble();
            scanner.nextLine(); 

            Apartment apartment = new Apartment(number, type, monthlyRent);
            building.addApartment(apartment);
        } else {
            System.out.println("Building not found.");
        }
    }

    private void checkAvailableApartments() {
        System.out.print("Enter building name: ");
        String buildingName = scanner.nextLine();
        Building building = realEstate.getBuilding(buildingName);

        if (building != null) {
            System.out.println("Available apartments: " + building.getAvailableApartments());
        } else {
            System.out.println("Building not found.");
        }
    }

    private void checkIncome() {
        double realEstateIncome = realEstate.getRealEstateIncome();
        double ownerIncome = realEstate.getOwnerIncome();
        System.out.printf("Real Estate Income (10%%): %.2f\n", realEstateIncome);
        System.out.printf("Owner Income (90%%): %.2f\n", ownerIncome);
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.displayMenu();
    }
}
