package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;
    }

    public void run() {
        while (!flag) {
            System.out.println("\n\nWelcome to the menu:\n");
            System.out.println("Options:\n" +
                               "1. Print board \n" +
                               "2. Machine move \n" +
                               "3. Human move \n" +
                               "4. Check winner \n" +
                               "5. Exit program \n");

            try {
                int option = reader.nextInt();
                reader.nextLine();

                switch (option) {
                    case 1:
                        printBoard();
                        break;
                    case 2:
                        machineMove();
                        break;
                    case 3:
                        humanMove();
                        break;
                    case 4:
                        checkWinner();
                        break;
                    case 5:
                        flag = true;
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                reader.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run();
    }

    private void printBoard() {
        System.out.println(cont.getBoardAsString());
    }

    private void machineMove() {
        cont.randomMove();
        System.out.println("The machine has made its move.");
        printBoard();
    }

    private void humanMove() {
        System.out.println("Enter the row (0 to 2) and column (0 to 2) for your move (format 1 2; row 1 column 2):");
        int row = reader.nextInt();
        int column = reader.nextInt();
        reader.nextLine();

        if (cont.humanMove(row, column)) {
            System.out.println("Move successfully made.");
        } else {
            System.out.println("Invalid position, please try again.");
        }
        printBoard();
    }

    private void checkWinner() {
        String winner = cont.checkWinner();
        if (winner != null) {
            System.out.println("The winner is: " + winner);
            flag = true;
        } else if (cont.isBoardFull()) {
            System.out.println("It's a draw.");
            flag = true;
        } else {
            System.out.println("No winner yet.");
        }
    }
}
