package ui;
import model.Controller;
import java.util.ArrayList;
import java.util.Scanner;

public class Executable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the matrix multiplication system.");
        System.out.print("\nPlease, tell me the size of your square matrices: ");
        int dimension = sc.nextInt();

        Controller controller = new Controller(dimension);

        System.out.println("\nFilling the first matrix...");
        ArrayList<ArrayList<Integer>> matriz1 = fillMatrizData(sc, dimension);

        System.out.println("\nFilling the second matrix...");
        ArrayList<ArrayList<Integer>> matriz2 = fillMatrizData(sc, dimension);

        controller.fillMatriz(1, matriz1);
        controller.fillMatriz(2, matriz2);

        System.out.println("\nGreat! The result of the matrix multiplication is:");
        controller.multiplyAndShowResult();

        sc.close();
    }

    private static ArrayList<ArrayList<Integer>> fillMatrizData(Scanner sc, int dimension) {
        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                System.out.print("Enter the number for position " + (i + 1) + "," + (j + 1) + ": ");
                row.add(sc.nextInt());
            }
            matriz.add(row);
        }

        return matriz;
    }
}
