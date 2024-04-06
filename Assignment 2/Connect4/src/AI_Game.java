// Khoa Huynh
// Dominic Frydryk
import java.util.Scanner;

public class AI_Game {
    private static final int EMPTY = 0;
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = 2;
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int WINNING_LENGTH = 4;
    private static final int INF = Integer.MAX_VALUE;
    private static int[][] board;

    public AI_Game(){
        board = new int[ROWS][COLS];
    }

    public static void playGame_playerFirst(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int playerCol = scanner.nextInt();
            if (isValidMove(playerCol)) {
                dropPiece(playerCol, PLAYER2);
                printBoard();
                if (isWinner(PLAYER2)) {
                    System.out.println("You win!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                int aiCol = getBestMove();
                dropPiece(aiCol, PLAYER1);
                printBoard();
                System.out.println("AI dropped a piece in column " + aiCol);
                if (isWinner(PLAYER1)) {
                    System.out.println("AI wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }

    public static void playGame_aiFirst(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int aiCol = getBestMove();
            dropPiece(aiCol, PLAYER1);
            printBoard();
            System.out.println("AI dropped a piece in column " + aiCol);
            if (isWinner(PLAYER1)) {
                System.out.println("AI wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
            int playerCol = scanner.nextInt();
            if (isValidMove(playerCol)) {
                dropPiece(playerCol, PLAYER2);
                printBoard();
                if (isWinner(PLAYER2)) {
                    System.out.println("You win!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }

    public static void printBoard() {
        System.out.println("---------------");
        System.out.println(" 0 1 2 3 4 5 6 ");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == PLAYER1) {
                    System.out.print(" R");
                } else if (board[row][col] == PLAYER2) {
                    System.out.print(" Y");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
    }

    private static boolean isValidMove(int col) {
        return col >= 0 && col < COLS && board[0][col] == EMPTY;
    }

    private static void dropPiece(int col, int player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = player;
                break;
            }
        }
    }

    private static boolean isWinner(int player) {
        // Check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLS - WINNING_LENGTH; col++) {
                if (board[row][col] == player) {
                    boolean win = true;
                    for (int k = 1; k < WINNING_LENGTH; k++) {
                        if (board[row][col + k] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        // Check vertical
        for (int row = 0; row <= ROWS - WINNING_LENGTH; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == player) {
                    boolean win = true;
                    for (int k = 1; k < WINNING_LENGTH; k++) {
                        if (board[row + k][col] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row <= ROWS - WINNING_LENGTH; row++) {
            for (int col = 0; col <= COLS - WINNING_LENGTH; col++) {
                if (board[row][col] == player) {
                    boolean win1 = true;
                    boolean win2 = true;
                    for (int k = 1; k < WINNING_LENGTH; k++) {
                        if (board[row + k][col + k] != player) {
                            win1 = false;
                        }
                        if (board[row + k][col + WINNING_LENGTH - k - 1] != player) {
                            win2 = false;
                        }
                    }
                    if (win1 || win2) return true;
                }
            }
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int evaluateBoard() {
        if (isWinner(PLAYER1)) {
            return 1000;
        } else if (isWinner(PLAYER2)) {
            return -1000;
        } else {
            return 0;
        }
    }

    private static int minimax(int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (depth == 0 || isWinner(PLAYER1) || isWinner(PLAYER2) || isBoardFull()) {
            return evaluateBoard();
        }

        if (maximizingPlayer) {
            int maxEval = -INF;
            for (int col = 0; col < COLS; col++) {
                if (isValidMove(col)) {
                    int row = getLowestEmptyRow(col);
                    dropPiece(col, PLAYER1);
                    int eval = minimax(depth - 1, alpha, beta, false);
                    maxEval = Math.max(maxEval, eval);
                    alpha = Math.max(alpha, eval);
                    board[row][col] = EMPTY; // Undo the move
                    if (beta <= alpha) break;
                }
            }
            return maxEval;
        } else {
            int minEval = INF;
            for (int col = 0; col < COLS; col++) {
                if (isValidMove(col)) {
                    int row = getLowestEmptyRow(col);
                    dropPiece(col, PLAYER2);
                    int eval = minimax(depth - 1, alpha, beta, true);
                    minEval = Math.min(minEval, eval);
                    beta = Math.min(beta, eval);
                    board[row][col] = EMPTY; // Undo the move
                    if (beta <= alpha) break;
                }
            }
            return minEval;
        }
    }

    private static int getLowestEmptyRow(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                return row;
            }
        }
        return -1;
    }

    private static int getBestMove() {
        int bestMove = -1;
        int maxEval = Integer.MIN_VALUE;
        for (int col = 0; col < COLS; col++) {
            if (isValidMove(col)) {
                int row = getLowestEmptyRow(col);
                board[row][col] = PLAYER1; // Simulate dropping a piece
                int eval = minimax(8, Integer.MIN_VALUE, Integer.MAX_VALUE, false); // Evaluate the resulting board state
                board[row][col] = EMPTY; // Undo the move
                if (eval > maxEval) {
                    maxEval = eval;
                    bestMove = col;
                }
            }
        }
        return bestMove;
    }
}

