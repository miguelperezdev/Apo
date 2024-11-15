package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    public boolean jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        if (tableroLleno()) {
            return false;
        }
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
        return true;
    }

    public boolean realizarJugadaHumano(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tableroTresEnRaya[fila][columna].equals(" ")) {
            tableroTresEnRaya[fila][columna] = "O";
            return true;
        }
        return false;
    }

    public String verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tableroTresEnRaya[i][0].equals(tableroTresEnRaya[i][1]) && tableroTresEnRaya[i][1].equals(tableroTresEnRaya[i][2]) && !tableroTresEnRaya[i][0].equals(" ")) {
                return tableroTresEnRaya[i][0];
            }
            if (tableroTresEnRaya[0][i].equals(tableroTresEnRaya[1][i]) && tableroTresEnRaya[1][i].equals(tableroTresEnRaya[2][i]) && !tableroTresEnRaya[0][i].equals(" ")) {
                return tableroTresEnRaya[0][i];
            }
        }
        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) && tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) && !tableroTresEnRaya[0][0].equals(" ")) {
            return tableroTresEnRaya[0][0];
        }
        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) && tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) && !tableroTresEnRaya[0][2].equals(" ")) {
            return tableroTresEnRaya[0][2];
        }
        return null;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroTresEnRaya[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
