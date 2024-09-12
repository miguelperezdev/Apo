package ui;

import java.util.Scanner;

class LugarBiodiverso {
    String nombreLugar;
    String departamentoLugar;
    Double presupuestoLugar;

    LugarBiodiverso(String nombreLugar, String departamentoLugar, Double presupuestoLugar) {
        nombreLugar = nombreLugar;
        departamentoLugar = departamentoLugar;
        presupuestoLugar = presupuestoLugar;
    }
}

public class GestionDeLugaresBiodiversos {
    private Scanner escaner;
    private LugarBiodiverso[] lugares;
    private int contadorLugares;

    GestionDeLugaresBiodiversos() {
        escaner = new Scanner(System.in);
        lugares = new LugarBiodiverso[10]; // Maximo 10 lugares
        contadorLugares = 0;
    }

    public void run() {
        boolean flag = false;
        while (!flag) {
            System.out.println("Bienvenido voluntario a la aplicacion de Gestion de Lugares Biodiversos COP 16 Cali - Colombia.");
            System.out.println("Que deseas hacer hoy en este programa?");
            System.out.println("1. Registrar un lugar con diversidad biologica");
            System.out.println("2. Consultar el promedio de presupuestos por departamento");
            System.out.println("3. Salir del programa");

            int opcion = escaner.nextInt();
            escaner.nextLine(); // Consumir la nueva linea

            switch (opcion) {
                case 1:
                    registrarLugar();
                    break;
                case 2:
                    consultarPromedio();
                    break;
                case 3:
                    flag = true;
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida.");
                    break;
            }
        }
    }

    private void registrarLugar() {
        if (contadorLugares < 10) {
            System.out.println("Ingresa el nombre del lugar biodiverso:");
            String nombre = escaner.nextLine();
            System.out.println("Ingresa el departamento en el cual esta el lugar (Valle, Choco, Cauca o Nariño):");
            String departamento = escaner.nextLine().toLowerCase(); // Ignorar mayusculas
            System.out.println("Ingresa el presupuesto nacional otorgado para este lugar:");
            Double presupuesto = escaner.nextDouble();
            escaner.nextLine(); // Consumir la nueva linea

            lugares[contadorLugares] = new LugarBiodiverso(nombre, departamento, presupuesto);
            contadorLugares++;
            System.out.println("Lugar ingresado con exito.");
        } else {
            System.out.println("No se pueden registrar mas lugares. Limite alcanzado.");
        }
    }

    private void consultarPromedio() {
        System.out.println("Selecciona uno de los cuatro departamentos para revisar el promedio presupuestal: Valle, Choco, Cauca o Nariño");
        String departamento = escaner.nextLine().toLowerCase(); // Ignorar mayusculas

        double sumaPresupuestos = 0.0;
        int contador = 0;

        for (int i = 0; i < contadorLugares; i++) {
            if (lugares[i].departamentoLugar.equals(departamento)) {
                sumaPresupuestos += lugares[i].presupuestoLugar;
                contador++;
            }
        }

        if (contador > 0) {
            double promedio = sumaPresupuestos / contador;
            String mensajePromedio = "El promedio presupuestal para el departamento de " + departamento + " es de " + promedio + " COP";
            System.out.println(mensajePromedio);
        } else {
            System.out.println("No se encontraron lugares registrados en el departamento de " + departamento);
        }
    }

    public static void main(String[] args) {
        GestionDeLugaresBiodiversos mainApp = new GestionDeLugaresBiodiversos();
        mainApp.run();
    }
}
