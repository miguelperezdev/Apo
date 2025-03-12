package model;

import java.util.Random;

public class Controladora {

    private String[][] ticTacToeBoard;

    public Controladora() {
        ticTacToeBoard = new String[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToeBoard[i][j] = " ";
            }
        }
    }

    public String getBoardAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(ticTacToeBoard[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    public void randomMove() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!ticTacToeBoard[i][j].equals(" "));
        ticTacToeBoard[i][j] = "X";
    }

    public boolean humanMove(int row, int column) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3 && ticTacToeBoard[row][column].equals(" ")) {
            ticTacToeBoard[row][column] = "O";
            return true;
        }
        return false;
    }

    public String checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (ticTacToeBoard[i][0].equals(ticTacToeBoard[i][1]) && ticTacToeBoard[i][1].equals(ticTacToeBoard[i][2]) && !ticTacToeBoard[i][0].equals(" ")) {
                return ticTacToeBoard[i][0];
            }
            if (ticTacToeBoard[0][i].equals(ticTacToeBoard[1][i]) && ticTacToeBoard[1][i].equals(ticTacToeBoard[2][i]) && !ticTacToeBoard[0][i].equals(" ")) {
                return ticTacToeBoard[0][i];
            }
        }
        if (ticTacToeBoard[0][0].equals(ticTacToeBoard[1][1]) && ticTacToeBoard[1][1].equals(ticTacToeBoard[2][2]) && !ticTacToeBoard[0][0].equals(" ")) {
            return ticTacToeBoard[0][0];
        }
        if (ticTacToeBoard[0][2].equals(ticTacToeBoard[1][1]) && ticTacToeBoard[1][1].equals(ticTacToeBoard[2][0]) && !ticTacToeBoard[0][2].equals(" ")) {
            return ticTacToeBoard[0][2];
        }
        return null;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToeBoard[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
