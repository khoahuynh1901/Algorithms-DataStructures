import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Initializing 2 games object */
        Connect4 c4 = new Connect4();
        AI_Game ai = new AI_Game();
        Scanner myObj = new Scanner(System.in);

        /* While loop to start menu game */
        while (true) {
            System.out.println("Hello! Welcome to Connect 4 Game");
            System.out.print("Do you want to play against a human or computer? (Enter 2 for human, 1 for computer): ");
            System.out.println();
            System.out.print("Exit the game (3): ");
            int input = myObj.nextInt();

            /* Playing with AI Part */
            if (input == 1) {

                /* Prompting R or Y */
                System.out.print("Please choose ('R' or 'Y') (R for red, Y for yellow): ");
                char choice = myObj.next().toUpperCase().charAt(0);

                /* Validate if not correct and re-prompt */
                while (choice != 'R' && choice != 'Y') {
                    System.out.print("Invalid choice. Please choose either 'R' or 'Y': ");
                    choice = myObj.next().toUpperCase().charAt(0);
                }
                /* ---- End Prompting R or Y ---- */

                /* Prompting who want to go first AI or Player */
                System.out.print("Do you want to go first? (Enter 'y' for yes, 'n' for no): ");
                String turn = myObj.next();
                if (turn.equalsIgnoreCase("y")) {
                    System.out.println("You go first!");
                    AI_Game.printBoard();
                    AI_Game.playGame_playerFirst();
                } else {
                    System.out.println("Computer goes first!");
                    AI_Game.printBoard();
                    AI_Game.playGame_aiFirst();                }
                break;
                /* ---- End Prompting who want first ---- */

                /* Play with Human Part */
            } else if (input == 2) {
                System.out.println("Human mode");
                System.out.print("Enter Player 1 name: ");
                String player1 = myObj.next();
                System.out.print("Enter Player 2 name: ");
                String player2 = myObj.next();

                /* Prompting R or Y */
                System.out.print("Please choose ('R' or 'Y') (R for red, Y for yellow): ");
                char choice = myObj.next().toUpperCase().charAt(0);
                /* Validate if not correct and re-prompt */
                while (choice != 'R' && choice != 'Y') {
                    System.out.print("Invalid choice. Please choose either 'R' or 'Y': ");
                    choice = myObj.next().toUpperCase().charAt(0);
                }
                Connect4.currentPlayer = choice;
                c4.playGame();
                break;
                /* ---- End Prompting R or Y ---- */

            /* Exit */
            } else if (input == 3 ) {
                System.out.println("Good bye :) ");
                break;

                /* If option is wrong re-enter */
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
        myObj.close();
    }
}
