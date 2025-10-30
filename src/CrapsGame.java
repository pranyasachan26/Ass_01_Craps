import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps Game!");

        while (playAgain) {
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nYou rolled: " + die1 + " + " + die2 + " = " + sum);

            // Case i - Crap out (2, 3, or 12)
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You crapped out! You lose!");
            }

            // Case ii - Natural win (7 or 11)
            else if (sum == 7 || sum == 11) {
                System.out.println("You got a natural! You win!");
            }

            // Case iii - Establish point
            else {
                int point = sum;
                System.out.println("Your point is now " + point + ".");
                boolean roundOver = false;

                while (!roundOver) {
                    System.out.println("\nTrying for point...");
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win!");
                        roundOver = true;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7 and lost!");
                        roundOver = true;
                    } else {
                        System.out.println("Still trying for point...");
                    }
                }
            }

            // Prompt to play again with input validation
            String response;
            while (true) {
                System.out.print("\nWould you like to play again? (y/n): ");
                response = input.next().toLowerCase();

                if (response.equals("y")) {
                    playAgain = true;
                    break;
                } else if (response.equals("n")) {
                    playAgain = false;
                    System.out.println("Thanks for playing Craps!");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }
        }

        input.close();
    }
}
