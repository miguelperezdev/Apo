package ui;

import model.Department;
import java.util.Scanner;

public class Main {

    private static Department department;
    private static Scanner scanner;

    public static void main(String[] args){
        department = new Department();
        scanner = new Scanner(System.in);
        menu();
    }

    public static void menu(){
        boolean flag = false;
        while(!flag) {
            System.out.println("Bienvenido a la gestión de departamentos");
            System.out.println("Elija una opción para continuar\n");
            System.out.println("1. Añadir una oficina\n");
            System.out.println("2. Buscar una oficina\n");
            System.out.println("3. Eliminar una oficina\n");
            System.out.println("4. Ordenar oficinas\n");
            int opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("Ingrese un código");
                    String code = scanner.nextLine();
                    System.out.println("Ingrese un piso");
                    int floor = scanner.nextInt();
                    department.addOffice(code, floor);
                    break;
                case 2:
                    System.out.println("Ingrese un código para buscar");
                    String codeS = scanner.nextLine();
                    if(department.searchOffice(codeS) != null){
                        System.out.println("Oficina Encontrada");
                    }
                    else{
                        System.out.println("No se pudo encontrar la oficina");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese un código para eliminar");
                    String codeR = scanner.nextLine();
                    department.removeOffice(codeR);
                    break;
                case 4:
                    System.out.println("Ordenando Oficinas");
                    department.sortByCode();
                    break;
                default:
                    flag = true;
                    break;
            }
        }
    }
}
