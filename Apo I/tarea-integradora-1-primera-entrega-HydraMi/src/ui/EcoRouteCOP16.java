package ui;
import java.util.Scanner;

public class EcoRouteCOP16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n# Welcome volunteer to the COP 16 Ecological Routes Interaction Application - Cali, Colombia.\n");

        System.out.println("# Please enter your name:");
        System.out.print("> ");
        String name = scanner.nextLine();

        requestID(scanner, name);
    }

    /**
     * Description: Requests the user's ID and moves to the next method to choose the route.
     * @param scanner (Scanner) Used to read the user's input.
     * @param name (String) User's name to be used in the interaction.
     */
    public static void requestID(Scanner scanner, String name) {
        System.out.println("\n# Please enter your ID (without dots or commas): ");
        System.out.print("> ");
        String id = scanner.nextLine();

        chooseRoute(scanner, name);
    }

    /**
     * Description: Allows the user to choose one of the three available ecological routes.
     * @param scanner (Scanner) Used to read the user's input.
     * @param name (String) User's name to be used in the interaction.
     */
    public static void chooseRoute(Scanner scanner, String name) {
        System.out.print("\nWelcome, " + name + "!");

        System.out.println("\n# Now, tell me which of the 3 routes you want to choose?");
        System.out.println("# Enter the number (1) to choose the Ladera route");
        System.out.println("# Enter the number (2) to choose the Oriente route");
        System.out.println("# Enter the number (3) to choose the Farallones route");
        System.out.print("> ");
        int option = scanner.nextInt();

        String route = "\n# You chose the route to: ";
        String meetingPoint = "# Meeting point: ";
        String startTime = "# Activity start time: ";
        String endTime = "# Activity end time: ";

        switch (option) {
            case 1:
                System.out.println(route + "Ladera");
                System.out.println(meetingPoint + "Bulevar del Rio");
                System.out.println(startTime + "7:00 AM");
                System.out.println(endTime + "1:30 PM");
                break;

            case 2:
                System.out.println(route + "Oriente");
                System.out.println(meetingPoint + "Bulevar del Rio");
                System.out.println(startTime + "7:00 AM");
                System.out.println(endTime + "1:00 PM");
                break;

            case 3:
                System.out.println(route + "Farallones");
                System.out.println(meetingPoint + "Calle 16 - Universidad del Valle");
                System.out.println(startTime + "6:40 AM");
                System.out.println(endTime + "2:30 PM");
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

        requestParticipants(scanner);
    }

    /**
     * Description: Requests the number of participants and guides to calculate the total.
     * @param scanner (Scanner) Used to read the user's input.
     */
    public static void requestParticipants(Scanner scanner) {
        System.out.println("\nHow many participants will attend the walk today?");
        System.out.print("> ");
        int participants = scanner.nextInt();  

        System.out.println("How many guides will attend the walk today?");
        System.out.print("> ");
        int guides = scanner.nextInt(); 

        int totalPeople = participants + guides;

        requestWeatherData(scanner);
        calculateBuses(totalPeople);
    }

    /**
     * Description: Requests weather data from the user and evaluates whether it is a good day to walk.
     * @param scanner (Scanner) Used to read the user's input.
     */
    public static void requestWeatherData(Scanner scanner) {
        System.out.println("\n# Now enter the weather data so I can tell you how the day will be");
        System.out.println("# Enter the temperature in degrees Celsius °C (use a comma for decimals)");
        System.out.print("> ");
        double temperature = scanner.nextDouble();

        System.out.println("# Enter the relative humidity percentage (use a comma for decimals)");
        System.out.print("> ");
        double humidity = scanner.nextDouble();

        if (temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60) {
            System.out.println("\n# It's a good day for a walk in Cali!");
        } else {
            System.out.println("\n# It's not a good day for a walk in Cali :(");
        }
    }

    /**
     * Description: Calculates and displays the number of buses needed based on the total number of participants and guides.
     * @param totalPeople (int) Total number of participants and guides.
     */
    public static void calculateBuses(int totalPeople) {
        int busCapacity = 25;
        int totalBuses = (int) Math.ceil((double) totalPeople / busCapacity);

        String pluralPeople = (totalPeople == 1) ? "person" : "people";
        String pluralBuses = (totalBuses == 1) ? "bus" : "buses";

        System.out.println("\n# With a total of " + totalPeople + " " + pluralPeople + " participating in the activity,");
        System.out.println("# It is necessary to have " + totalBuses + " " + pluralBuses + " to carry out the activity successfully. See you at COP16!\n");
    }
}