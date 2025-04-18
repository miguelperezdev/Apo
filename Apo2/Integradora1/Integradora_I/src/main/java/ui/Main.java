package ui;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Exceptions.EmptyListException;
import Exceptions.InvalidRouteException;
import model.Controller;
import java.time.LocalDateTime;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Controller controller = new Controller();
    public static void main(String[] args) throws EmptyListException, InvalidRouteException {
        int option;
        do {
            System.out.println("\n Main Menu:");
            System.out.println("1. Add Route");
            System.out.println("2. Add Incident");
            System.out.println("3. Add Passenger");
            System.out.println("4. Add Driver");
            System.out.println("5. Show Routes");
            System.out.println("6. Show Incidents");
            System.out.println("7. Show Passengers");
            System.out.println("8. Show Drivers");
            System.out.println("9. Sort Routes by Distance");
            System.out.println("10. Sort Routes by Estimated Time");
            System.out.println("11. Sort Incidents by Date");
            System.out.println("12. Search the best route by time");
            System.out.println("13. Search an incident");
            System.out.println("14. Search a driver");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addRoute();
                    break;
                case 2:
                    addIncident();
                    break;
                case 3:
                    addPassenger();
                    break;
                case 4:
                    addDriver();
                    break;
                case 5:
                    System.out.println("\n Registered Routes:");
                    System.out.println(controller.showRoutes());
                    break;
                case 6:
                    System.out.println("\n Registered Incidents:");
                    System.out.println(controller.showIncidents());
                    break;
                case 7:
                    System.out.println("\n Registered Passengers:");
                    System.out.println(controller.showPassengers());
                    break;
                case 8:
                    System.out.println("\n Registered Drivers:");
                    System.out.println(controller.showDriver());
                    break;
                case 9:
                    controller.sortRoutesByDistance();
                    System.out.println("\n Routes sorted by distance.");
                    break;
                case 10:
                    controller.sortRoutesByTime();
                    System.out.println("\n Routes sorted by estimated time.");
                    break;
                case 11:
                    controller.sortIncidentsByDate();
                    System.out.println("\n Incidents sorted by date.");
                    break;
                case 12:
                    String bestRoute = controller.getBestRouteByTime();
                    System.out.println("The best route is: " + bestRoute);

                    break;
                case 13 :
                    searchAnIncident();
                    break;
                case 14 :
                    searchDriver();
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }


    public static void addRoute() throws InvalidRouteException {
        System.out.println("\n Add New Route:");
        System.out.print("Enter route ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter route distance (km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter estimated time (minutes): ");
        int estimatedTime = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter starting point: ");
        String startPoint = scanner.nextLine();

        System.out.print("Enter destination: ");
        String endPoint = scanner.nextLine();

        controller.addRoute(id, distance, estimatedTime, startPoint, endPoint);
        System.out.println(" Route added successfully.");
    }


    public static void addIncident() {
        System.out.println("\n Add New Incident:");
        System.out.print("Enter incident ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter incident type: ");
        String type = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter date and time (YYYY-MM-DD HH:MM): ");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm[:ss]");

        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter status (PENDING, IN_PROCESS, RESOLVED): ");
        String status = scanner.nextLine();

        controller.addIncident(id, type, location, dateTime, description, controller.getStateOfIncident(status));
        System.out.println(" Incident added successfully.");
    }


    public static void addPassenger() {
        System.out.println("\n Add New Passenger:");
        System.out.print("Enter passenger ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter assigned route ID: ");
        String routeId = scanner.nextLine();

        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();

        controller.addPassenger(id, name, routeId, phoneNumber);
        System.out.println(" Passenger added successfully.");
    }


    public static void addDriver() {
        System.out.println("\n Add New Driver:");
        System.out.print("Enter driver ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();

        System.out.print("Enter assigned vehicle ID: ");
        String assignedVehicle = scanner.nextLine();

        System.out.print("Enter status (AVAILABLE, ON_ROUTE): ");
        String status = scanner.nextLine();

        controller.addDriver(id, name, assignedVehicle, controller.getStateDriver(status));
        System.out.println(" Driver added successfully.");
    }
    public static void searchAnIncident(){
        System.out.println("\n Search an incident:");
        System.out.println("Enter the ID of the incident that you want find:");
        String incidentId= scanner.nextLine();
        System.out.println(controller.searchIncidentById(incidentId));
    }
    public static void searchDriver(){
        System.out.println("\n Search a driver:");
        System.out.println("Enter the name of the driver that you want find:");
        String driverName= scanner.nextLine();
        System.out.println(controller.searchDriverByName(driverName));
    }

}
