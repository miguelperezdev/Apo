package ui;

import model.ShiftManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ShiftManager controller = new ShiftManager();
        Scanner reader = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("\nBienvenido a la gestión de turnos de la empresa," +
                    "elija una opción para continuar");
            System.out.println("1. Añadir una persona");
            System.out.println("2. Buscar una persona");
            int opt = reader.nextInt();
            reader.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("Ingrese el nombre de la persona");
                    String name = reader.nextLine();
                    System.out.println("Ingrese el id de la persona");
                    String id = reader.nextLine();
                    if (controller.addPerson(name, id)) {
                        System.out.println("La persona se agregó");
                    }
                    else{
                        System.out.println("La persona no pudo ser agregada");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el id de la persona a buscar");
                    String iD = reader.nextLine();
                    if(controller.searchPerson(iD)!=null){
                        System.out.println("Persona Encontrada");
                    }
                    else{
                        System.out.println("Persona no Encontrada");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
