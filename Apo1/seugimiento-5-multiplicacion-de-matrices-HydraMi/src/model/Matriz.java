package model;
import java.util.ArrayList;

public class Matriz {
    private int dimension;
    private ArrayList<ArrayList<Integer>> data;
   
    public Matriz(int dimension) {
        this.dimension = dimension;
        this.data = new ArrayList<>(dimension);

        for (int i = 0; i < dimension; i++) {
            data.add(new ArrayList<>(dimension));
            for (int j = 0; j < dimension; j++) {
                data.get(i).add(0); 
            }
        }
    }

    public void assignValue(int row, int column, int value) {
        data.get(row).set(column, value);
    }

    public int getValue(int row, int column) {
        return data.get(row).get(column);
    }

    public static Matriz multiply(Matriz m1, Matriz m2) {
        int dimension = m1.dimension;
        Matriz result = new Matriz(dimension);

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int sum = 0;
                for (int k = 0; k < dimension; k++) {
                    sum += m1.getValue(i, k) * m2.getValue(k, j);
                }
                result.assignValue(i, j, sum);
            }
        }

        return result;
    }

    public String displayMatriz() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(data.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    
    public ArrayList<ArrayList<Integer>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<Integer>> data) {
        this.data = data;
    }
}
