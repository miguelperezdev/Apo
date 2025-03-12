package model;
import java.util.ArrayList;

public class Controller {
    private Matriz matriz1;
    private Matriz matriz2;
    private int dimension;

    public Controller(int dimension) {
        this.dimension = dimension;
        this.matriz1 = new Matriz(dimension);
        this.matriz2 = new Matriz(dimension);
    }

    public void fillMatriz(int matrizNumber, ArrayList<ArrayList<Integer>> values) {
        Matriz matriz = (matrizNumber == 1) ? matriz1 : matriz2;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matriz.assignValue(i, j, values.get(i).get(j));
            }
        }
    }

    public void multiplyAndShowResult() {
        Matriz result = Matriz.multiply(matriz1, matriz2);
        System.out.println(result.displayMatriz());
    }
}
