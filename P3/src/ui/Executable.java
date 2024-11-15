package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private boolean flag;
    private boolean turnoHumano;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;
        turnoHumano = true;
    }

    public void run() {
        while (!flag) {
            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" +
                               "1. Imprimir tablero \n" +
                               "2. Jugar \n" + 
                               "3. Verificar ganador \n" +
                               "4. Salir del programa \n");

            try {
                int option = reader.nextInt();
                reader.nextLine();

                switch (option) {
                    case 1:
                        imprimirTablero();
                        break;
                    case 2:
                        jugar();
                        if (validarGanador()) {
                            flag = true;
                        }
                        break;
                    case 3:
                        if (validarGanador()) {
                            flag = true;
                        } else {
                            System.out.println("No hay ganador todavia.");
                        }
                        break;
                    case 4:
                        flag = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida. Por favor ingrese un numero.");
                reader.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run();
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugar() {
        if (turnoHumano) {
            System.out.println("Es el turno del jugador humano:");
            jugadaHumano();
            turnoHumano = false;
        } else {
            System.out.println("Es el turno de la maquina:");
            jugadaMaquina();
            turnoHumano = true;
        }
    }

    private void jugadaMaquina() {
        if (cont.jugadaAleatoria()) {
            System.out.println("La maquina ha realizado su jugada.");
        } else {
            System.out.println("No quedan posiciones disponibles para la maquina.");
        }
        imprimirTablero();
    }

    private void jugadaHumano() {
        boolean jugadaValida = false;
        while (!jugadaValida) {
            System.out.println("Ingrese la fila (0-2) y columna (0-2) de su jugada:");
            int fila = reader.nextInt();
            int columna = reader.nextInt();
            reader.nextLine();

            if (cont.realizarJugadaHumano(fila, columna)) {
                System.out.println("Jugada realizada con exito.");
                jugadaValida = true;
            } else {
                System.out.println("Posicion invalida o ya ocupada, por favor intente nuevamente.");
            }
        }
        imprimirTablero();
    }

    private boolean validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador != null) {
            System.out.println("El ganador es: " + ganador);
            return true;
        } else if (cont.tableroLleno()) {
            System.out.println("Es un empate.");
            return true;
        }
        return false;
    }
}