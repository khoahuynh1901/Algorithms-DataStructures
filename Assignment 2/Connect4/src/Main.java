import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("Hello! Welcome to Connect 4 Game");
            System.out.print("Do you want to play against a human or computer? (Enter 2 for human, 1 for computer): ");
            int input = myObj.nextInt();

            if (input == 1) {
                System.out.print("Please choose ('R' or 'Y') (R for red, Y for yellow): ");
                String choice = myObj.next();

                System.out.print("Do you want to go first? (Enter 'y' for yes, 'n' for no): ");
                String turn = myObj.next();

                if (turn.equals("y") || turn.equals(turn.toUpperCase())) {
                    System.out.println("You go first!");
                } else {
                    System.out.println("Computer goes first!");
                }

                break;
            } else if (input == 2) {
                System.out.println("Human mode");
                System.out.print("Enter Player 1 name: ");
                String player1 = myObj.next();
                System.out.print("Enter Player 2 name: ");
                String player2 = myObj.next();

                System.out.print("Please choose ('R' or 'Y') (R for red, Y for yellow): ");
                String choice = myObj.next();

                Connect4 c4 = new Connect4();
                c4.playGame();

                break;
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
    }
}
