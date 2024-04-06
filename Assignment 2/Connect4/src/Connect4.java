import java.util.Scanner;

public class Connect4 {
    private char[][] board;
    public static char currentPlayer;
    private boolean gameOver;
    private int turn;

    public Connect4() {
        board = new char[6][7];
        initializeBoard();
        currentPlayer = 'R';
        gameOver = false;
        turn = 1;
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void playGame() {
        Scanner in = new Scanner(System.in);
        while (!gameOver && turn <= 42) {
            displayBoard();
            int column;
            do {
                System.out.print("Player " + currentPlayer + ", choose a column (0-6): ");
                column = in.nextInt();
            } while (!isValidMove(column));

            dropChecker(column);
            if (checkForWinner()) {
                gameOver = true;

            }
            switchPlayer();
            turn++;
        }
        displayBoard();
        if (gameOver) {
            switchPlayer();
            System.out.println(currentPlayer + " won!");
        } else {
            System.out.println("It's a tie!");
        }
        in.close();
    }

    private boolean isValidMove(int column) {
        return column >= 0 && column < board[0].length && board[0][column] == '-';
    }

    private void dropChecker(int column) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] == '-') {
                board[row][column] = currentPlayer;
                break;
            }
        }
    }

    private boolean checkForWinner() {
        // Check for horizontal wins
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <= board[row].length - 4; col++) {
                if (board[row][col] != '-' &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }

        // Check for vertical wins
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row <= board.length - 4; row++) {
                if (board[row][col] != '-' &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col] &&
                        board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (positive slope)
        for (int row = 0; row <= board.length - 4; row++) {
            for (int col = 0; col <= board[row].length - 4; col++) {
                if (board[row][col] != '-' &&
                        board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] &&
                        board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        // Check for diagonal wins (negative slope)
        for (int row = 3; row < board.length; row++) {
            for (int col = 0; col <= board[row].length - 4; col++) {
                if (board[row][col] != '-' &&
                        board[row][col] == board[row - 1][col + 1] &&
                        board[row][col] == board[row - 2][col + 2] &&
                        board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void switchPlayer() {
//     Short-hand   currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
            // Check if current player is 'R'
            if (currentPlayer == 'r' || currentPlayer == 'R') {
                // If current player is 'R', switch to 'Y'
                currentPlayer = 'Y';
            } else {
                // If current player is not 'R' (i.e., it's 'Y'), switch to 'R'
                currentPlayer = 'R';
            }
    }

    private void displayBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print(" ");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---------------");
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }
}
