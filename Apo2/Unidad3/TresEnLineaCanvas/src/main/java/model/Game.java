package model;

public class Game {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public Game() {
        reset();
    }

    public boolean play(int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public char checkWinner() {
        // Revisa filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

        return '-';
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
        currentPlayer = 'X';
    }
}
