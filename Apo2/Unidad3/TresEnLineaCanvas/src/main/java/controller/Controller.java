package controller;

import model.Game;

public class Controller {
    private Game game = new Game();

    public boolean jugar(int fila, int columna) {
        return game.play(fila, columna);
    }

    public void cambiarTurno() {
        game.switchPlayer();
    }

    public char obtenerGanador() {
        return game.checkWinner();
    }

    public char obtenerJugadorActual() {
        return game.getCurrentPlayer();
    }

    public char[][] obtenerTablero() {
        return game.getBoard();
    }

    public void reiniciar() {
        game.reset();
    }
}
