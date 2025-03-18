package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;  // Inicia como falso
    }

    public void run() {
        while (!flag) {
            System.out.println("\n\nBienvenido al menú:\n");
            System.out.println("Opciones:\n" +
                               "1. Imprimir tablero \n" +
                               "2. Jugada de la máquina \n" +
                               "3. Jugada de humano \n" +
                               "4. Verificar ganador \n" +
                               "5. Salir del programa \n");

            try {
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
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                reader.nextLine();  // Limpiar el buffer
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

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese la fila (0 a 2) y columna (0 a 2) de su jugada(formato tipo 1 2; fila 1 columna 2):");
        int fila = reader.nextInt();
        int columna = reader.nextInt();
        reader.nextLine();

        if (cont.realizarJugadaHumano(fila, columna)) {
            System.out.println("Jugada realizada con éxito.");
        } else {
            System.out.println("Posición inválida, por favor intente nuevamente.");
        }
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador != null) {
            System.out.println("El ganador es: " + ganador);
            flag = true;  // Terminar el juego si hay un ganador
        } else if (cont.tableroLleno()) {
            System.out.println("Es un empate.");
            flag = true;  // Terminar el juego en caso de empate
        } else {
            System.out.println("No hay ganador todavía.");
        }
    }
}
