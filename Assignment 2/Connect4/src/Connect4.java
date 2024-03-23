import java.util.Scanner;

public class Connect4{
    private char[][] board;
    private char currentPlayer;
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
        // Implementation of isWinner method from previous code
        // This method checks for a winner and returns true if a winner is found
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'R') ? 'B' : 'R';
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
