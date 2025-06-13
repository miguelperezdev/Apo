package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu del juego Triqui o Tres en raya:\n");
            System.out.println("Opciones:\n" + 
                                "1. Imprimir tablero \n" + 
                                "2. Jugada de la máquina \n"+
                                "3. Jugada de humano \n" +
                                "4. Verificar ganador \n" +
                                "5. Salir del programa \n");

            System.out.print("Ingresa tu opcion: ");
            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
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

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha hecho su jugada");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("\n Recuerde ingresar la fila (0 a 2) de arriba hacia abajo y columna (0 a 2) de derecha a izquierda de su jugada:");
        System.out.print("\n Ingresa la fila: ");
        int fila = reader.nextInt();
        System.out.print("Ingresa la columna: ");
        int columna = reader.nextInt();
        reader.nextLine();

        if (cont.realizarJugadaHumano(fila, columna)) {
            System.out.println("Jugada realizada con exito.");
        }   
        else {
            System.out.println("Posicion invalida, por favor intente nuevamente.");
        }
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador != null) {
            System.out.println("\nEl ganador es: " + ganador);
            flag = true;  
        } 
        else if (cont.tableroLleno()) {
            System.out.println("\nEs un empate");
            flag = true; 
        } 
        else {
            System.out.println("\nNo hay ganador por ahora");
        }
    }
}