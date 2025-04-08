package ui;
import model.Company;

import java.util.Scanner;
public class main {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Company icesi = new Company("Universidad Icesi");

        boolean flag = false;
        while(!flag){
            System.out.println("Árbol de empleados");
            System.out.println("1. Añadir un empleado (Recursivo)");
            int opt = reader.nextInt();
            reader.nextLine();
            switch (opt){
                case 1:
                    System.out.println("\nIngrese el id");
                    String id = reader.nextLine();
                    System.out.println("Ingrese el nombre");
                    String name = reader.nextLine();
                    System.out.println("Ingrese la oficina");
                    int office = reader.nextInt();
                    icesi.add(id, name, office);
                    break;
                case 2:
                    break;
                default:

            }
        }
    }
}
