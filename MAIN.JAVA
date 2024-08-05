import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = '1';
        boolean gameWon = false;

        while (!gameWon && !isBoardFull()) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("This move is not valid. Try again.");
            } else {
                board[row][col] = currentPlayer;
                gameWon = checkWin(currentPlayer);

                if (gameWon) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("The game is a tie!");
                } else {
                    currentPlayer = (currentPlayer == '1') ? '0' : '1';
                }
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }
}
