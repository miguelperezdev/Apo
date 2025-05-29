package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ControllerTriqui {

    @FXML
    private Canvas canvas;

    private final Controller logic = new Controller();

    @FXML
    public void initialize() {
        drawBoard();
        canvas.setOnMouseClicked(this::handleClick);
    }

    private void handleClick(MouseEvent e) {
        int cellSize = 200;
        int col = (int) (e.getX() / cellSize);
        int row = (int) (e.getY() / cellSize);

        if (logic.jugar(row, col)) {
            drawBoard();
            char winner = logic.obtenerGanador();
            if (winner != '-') {
                System.out.println("Ganó: " + winner);
                // Mostrar mensaje, reiniciar, etc.
            } else {
                logic.cambiarTurno();
            }
        }
    }

    private void drawBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int cellSize = 200;

        // Dibujar líneas del tablero
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        for (int i = 1; i < 3; i++) {
            gc.strokeLine(i * cellSize, 0, i * cellSize, canvas.getHeight());
            gc.strokeLine(0, i * cellSize, canvas.getWidth(), i * cellSize);
        }

        // Dibujar X y O
        char[][] board = logic.obtenerTablero();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double x = j * cellSize;
                double y = i * cellSize;
                if (board[i][j] == 'X') {
                    gc.setStroke(Color.RED);
                    gc.strokeLine(x + 20, y + 20, x + cellSize - 20, y + cellSize - 20);
                    gc.strokeLine(x + 20, y + cellSize - 20, x + cellSize - 20, y + 20);
                } else if (board[i][j] == 'O') {
                    gc.setStroke(Color.BLUE);
                    gc.strokeOval(x + 20, y + 20, cellSize - 40, cellSize - 40);
                }
            }
        }
    }
}
