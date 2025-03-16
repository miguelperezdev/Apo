package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Scanner escaner;
    private Controller controladora;
    private static boolean flag;

    public Executable() {
        escaner = new Scanner(System.in);
        controladora = new Controller();
    }

    public void run(boolean flag) {

        flag = false;

		while (!flag) {

			System.out.println("\n \n Bienvenido al menu:\n");
			System.out.println("Opciones:\n"
                    + "1. Precargar informacion \n" 
					+ "2. Fixture \n"
                     + "3. Realizar partido entre 2 equipos \n" 
                     + "4. Salir del programa \n");

			int option = escaner.nextInt();

			escaner.nextLine();

			switch (option) {
					case 1:
                        preload();
						break;
					case 2:
                        fixture();
						break;
					case 3:
                        partido();
						break;
					case 4:
                        System.out.println("Saliendo de la app...");
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

    }

    public static void main(String[] args) {

        Executable mainApp = new Executable();
        mainApp.run(flag);

    }

    public void preload() {
        controladora.preload();
        System.out.println("Informacion precargada exitosamente.");

        System.out.println(controladora.mostrarEquipos());
        System.out.println(controladora.mostrarArbitros());
    }

    public void fixture() {
        System.out.println(controladora.fixture());
    }

    public void partido() {
        System.out.println(controladora.jugada());
    }

}