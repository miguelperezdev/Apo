package model;

public class Controller {

    private String[][] tablero = new String[3][3];
    private boolean turnoX = true;
    private boolean juegoTerminado = false;

    public String jugar(int fila, int columna) {
        if (juegoTerminado) return null;
        if (tablero[fila][columna] != null) return null;

        String marca = turnoX ? "X" : "O";
        tablero[fila][columna] = marca;

        if (verificarGanador()) {
            juegoTerminado = true;
            return "GANADOR_" + marca;
        }

        if (empate()) {
            juegoTerminado = true;
            return "EMPATE";
        }

        turnoX = !turnoX;
        return marca;
    }

    public boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (iguales(tablero[i][0], tablero[i][1], tablero[i][2])) return true;
            if (iguales(tablero[0][i], tablero[1][i], tablero[2][i])) return true;
        }

        return iguales(tablero[0][0], tablero[1][1], tablero[2][2]) ||
                iguales(tablero[0][2], tablero[1][1], tablero[2][0]);
    }

    private boolean iguales(String a, String b, String c) {
        return a != null && a.equals(b) && b.equals(c);
    }

    private boolean empate() {
        for (String[] fila : tablero)
            for (String celda : fila)
                if (celda == null) return false;
        return true;
    }

    public void reiniciar() {
        tablero = new String[3][3];
        turnoX = true;
        juegoTerminado = false;
    }
}




