import java.util.Scanner;

public class Game {
    private int[] board; // Tablero del juego
    private int currentPlayer; // 0 representa a "X" y 1 representa a "O".

    public Game() {
        this.board = new int[7]; // Tablero del tamaño requerido (6 columnas y 7 filas)
        for (int i = 0; i < board.length; ++i) {
            board[i] = -1; // Inicializamos el tablero con valores no válidos (-1 significa que la casilla está vacía).
        }
        this.currentPlayer = 0; // "X" empieza como jugador actual por convención.
    }

    public void play(int column) {
        // Comprueba si se puede colocar una ficha en la casilla indicada y, si es así, lo hace.
        if (canPlacePiece(column)) {
            placePiece(column);
            switchPlayer();
        }
    }

    private boolean canPlacePiece(int column) {
        // Comprueba si es posible colocar una ficha en la casilla indicada.
        if (column < 0 || column >= board.length) {
            return false;
        }
        if (board[getColumnIndex(column)] == -1) {
            return true;
        }
        return false;
    }

    private void placePiece(int column) {
        // Coloca una ficha en la casilla indicada.
        int index = getColumnIndex(column);
        for (int i = board.length - 1; i >= index && board[i] != -1; --i) {
            board[i + 1] = board[i];
        }
        board[index] = currentPlayer; // Colocamos la ficha en la casilla actual.
    }

    private int getColumnIndex(int column) {
        return column + (board.length - 6); // Calculamos el índice real de una columna.
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer + 1) % 2;
    }
}