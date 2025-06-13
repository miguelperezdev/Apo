package ui;

import java.util.Scanner;

public class BurgerTown{

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: El Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("\nBienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

    }
    /**
     * Descripcion: Este metodo solicita al usuario el precio y la cantidad vendida de cada plato
     * y llena los arreglos correspondientes.
     */

    public static void solicitarDatos(){

      for (int i= 0; i <precios.length; i++){

        System.out.println("Ingresa el precio del plato " + (i+1) + ":");
            precios[i] = reader.nextDouble();
        System.out.println("Ingresa cuantas unidades vendiste del plato " + (i+1) + ":");
            unidades[i] = reader.nextInt();

      }

    }
    /**
     * Descripcion: Este metodo calcula el total de platos vendidos durante el dia sumando las cantidades de cada plato.
     */
    public static int calcularTotalPlatosVendidos(){
        int totalPlatos= 0;
        for (int cantidad: unidades){
            totalPlatos += cantidad;
        }
        return totalPlatos;

    }
    /**
     * Descripcion: Este metodo calcula el precio promedio de los platos vendidos, ponderando los precios
     * por la cantidad vendida.
     */
    public static double calcularPrecioPromedio(){
        double totalPrecio= 0;
        for (int i=0; i <precios.length; i++){
            totalPrecio += precios[i] * unidades[i];
        }
        return totalPrecio/ calcularTotalPlatosVendidos();

    }
    /**
     * Descripcion: Este metodo calcula el total de dinero recaudado durante el día, multiplicando
     * el precio de cada plato por la cantidad vendida y sumando los resultados.
     */
    public static double calcularVentasTotales(){
        double totalVentas= 0;
        for (int i=0 ; i<precios.length; i++){
            totalVentas += precios[i] * unidades[i];
        }
        return totalVentas;

    }
    /**
     * Descripcion: Este metodo analiza cuántos platos han superado un limite minimo de ventas.
     * @param limite El limite minimo de ventas a analizar.
     */
    public static int consultarPlatosSobreLimite(double limite){
        int contador= 0 ; 
        for (int i=0;i<precios.length; i++){
            if (precios [i]* unidades[i]> limite){
                contador++ ;
            }
        }
        return contador ;

    }

}