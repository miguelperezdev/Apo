package ui;
import java.util.Scanner;

import javax.swing.text.Position;

import model.Controller;

public class Executable {
 
 private Controller controller; 
 private Scanner scanner;
 private static boolean flag;

 private Executable(){
    controller= new Controller();
    scanner = new Scanner(System.in);
 }
    public void run(){
        boolean flag= false;

     flag= false;

        while (!flag){


                System.out.println("\nWelcome to the best soccer tournament\n");
                System.out.println("What would you like to do today?\n");
                
                    System.out.println("1. Register Team");
                    System.out.println("2. Register Player");
                    System.out.println("3. Register Referee");
                    System.out.println("4. preload information");
                    System.out.println("5. Consult information about a team (player information) ");
                    System.out.println("6. consult information about referees registered so far");
                    System.out.println("0. Exit");
                    System.out.print("Choose an option: ");

                    int option = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (option) {
                                    case 1:
                                        registerTeam();
                                        break;
                                    case 2:
                                        registerPlayer();
                                        break;
                                    case 3:
                                        registerReferee();
                                        break;
                                    case 4:
                                        controller.loadInitialData();// la precarga 
                                        break;
                                    case 5:
                                        informationTeam();
                                        break;
                                    case 6:
                                        informationReferee();
                                        break;
                                    case 0:
                                        System.out.println("Exiting the program.");
                                        flag = true;
                                        System.exit(0);
                                        break;
                                    default:
                                        System.out.println("Invalid option, please try again.");
                                        continue;
                    }
         }

    }

    public void registerTeam(){
        System.out.println("Enter team name: ");
        String name = scanner.nextLine();
        System.out.println("Enter team country: ");
        String country = scanner.nextLine();
        System.out.println("Enter coach name: ");
        String coachName = scanner.nextLine();
        System.out.println("Enter team country: ");
        String coachCountry = scanner.nextLine();

    }

     public void registerPlayer() {
        System.out.println("What team does it belong to?");
        String Team = scanner.nextLine();
        System.out.println("Enter the ID (Shirt Number)");
        String id = scanner.nextLine();
        System.out.println("Enter team name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Position: ");
        String Position= scanner.nextLine().toUpperCase();
        System.out.println("Enter team country: ");
        String country = scanner.nextLine();
    }

    public void registerReferee() {
        System.out.println("Enter the ID");
        String id = scanner.nextLine();
        System.out.println("Enter the name : ");
        String name = scanner.nextLine();
        System.out.println("Enter the country");
        String Country = scanner.nextLine();
        System.out.println("What type of referee is he? : ");
        String TypeR = scanner.nextLine().toUpperCase();
    }

    public void informationTeam() {
        // Implementar consulta de información de un equipo
    }

    public void informationReferee() {
        // Implementar consulta de información de árbitros
    }
    public static void main(String[] args) {

        Executable mainApp = new Executable();
        mainApp.run();

    }

    
}