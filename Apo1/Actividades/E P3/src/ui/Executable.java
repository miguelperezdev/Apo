package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private boolean flag;
    private boolean isHumanTurn;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;
        isHumanTurn = true;
    }

    public void run() {
        while (!flag) {
            System.out.println("\n\nWelcome to the menu:\n");
            System.out.println("Options:\n" +
                               "1. Print board \n" +
                               "2. Play \n" +
                               "3. Check winner \n" +
                               "4. Exit the program \n");

            try {
                int option = reader.nextInt();
                reader.nextLine();

                switch (option) {
                    case 1:
                        printBoard();
                        break;
                    case 2:
                        play();
                        if (checkWinner()) {
                            flag = true;
                        }
                        break;
                    case 3:
                        if (checkWinner()) {
                            flag = true;
                        } else {
                            System.out.println("No winner yet.");
                        }
                        break;
                    case 4:
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

    private void play() {
        if (isHumanTurn) {
            System.out.println("It's the human player's turn:");
            humanMove();
            isHumanTurn = false;
        } else {
            System.out.println("It's the machine's turn:");
            machineMove();
            isHumanTurn = true;
        }
    }

    private void machineMove() {
        if (cont.randomMove()) {
            System.out.println("The machine has made its move.");
        } else {
            System.out.println("No available positions for the machine.");
        }
        printBoard();
    }

    private void humanMove() {
        boolean validMove = false;
        while (!validMove) {
            System.out.println("Enter the row (0-2) and column (0-2) for your move:");
            System.out.println("row:" );
             int row = reader.nextInt();
             System.out.println("column:" );
            int column = reader.nextInt();
            reader.nextLine();

            if (cont.humanMove(row, column)) {
                System.out.println("Move successfully made.");
                validMove = true;
            } else {
                System.out.println("Invalid or occupied position, please try again.");
            }
        }
        printBoard();
    }

    private boolean checkWinner() {
        String winner = cont.checkWinner();
        if (winner != null) {
            System.out.println("The winner is: " + winner);
            return true;
        } else if (cont.isBoardFull()) {
            System.out.println("It's a draw.");
            return true;
        }
        return false;
    }
}
