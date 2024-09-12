package ui;

import java.util.Scanner;

public class GestionDeLugaresBiodiversos {
    // Atributos de la clase Ejecutable
	private Scanner escaner;
	private static boolean flag;

	private GestionDeLugaresBiodiversos() {
		escaner = new Scanner(System.in);
	}
	
	public void run(boolean flag)
	{
		flag = false;

		while (!flag) {

            System.out.println("Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
			System.out.println("\n \n What do you want to do today in this program? \n");
			System.out.println("Enter:\n" + "1. To register a place with biological diversity (1) \n" + "2.To consult, according to a given department, the average budgets of biodiverse places (2)\n"
							   +"3. To exit the program (3) \n");

			int option = escaner.nextInt();

			escaner.nextLine();

			switch (option) {
					case 1:
						System.out.println("Enter the name of the biodiverse place");
                            String biodiversePlace= escaner.nextLine ();
                        System.out.println("Enter the department in which the place is located (Valle, Chocó, Cauca o Nariño)");
                            String department= escaner.nextLine ();
                         System.out.println("Enter the national budget granted for this place");
                            String nationalBudget= escaner.nextLine ();

                            System.out.println("Location successfully entered.");
						    break;
					case 2:
						System.out.println("Select one of the four departments to review the budget average: Valle, Chocó, Cauca or Nariño");

						    break;
					case 3:
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
		GestionDeLugaresBiodiversos mainApp = new GestionDeLugaresBiodiversos();
		mainApp.run(flag);
	}

    public void opcionUno() {
        System.out.println("Elegiste opcion uno");
    }

    public void opcionDos() {
        System.out.println("Elegiste opcion dos");
    }

    public void opcionTres() {
        System.out.println("Elegiste opcion tres");
    }

    public void opcionCuatro() {
        System.out.println("Elegiste opcion cuatro");
    }

	

	
}