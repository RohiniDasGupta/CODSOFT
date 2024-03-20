import java.util.InputMismatchException;
import java.util.Random;
import java.util.*;

public class GuessingGame 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int guess;
        int maxAttempts = 5;
        int score = 5;
        boolean playAgain = true;

        while (playAgain) 
        {
            score = 5;
            int number = random.nextInt(100) + 1; // Generates random number between 1 and 100 (inclusive)
            int attempts = 0;

            while (attempts < maxAttempts) 
            {
                System.out.println("Guess a number between 1 and 100: ");
                try 
                {
                    guess = sc.nextInt();
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.nextLine(); // Clear scanner buffer
                    continue;
                }

                attempts++;

                if (guess == number) 
                {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                } 
                else if (guess > number) 
                {
                    System.out.println("Your guess is too high.");
                    score--;
                } 
                else 
                {
                    System.out.println("Your guess is too low.");
                    score--;
                }
                
                if (attempts == maxAttempts) 
                {
                    System.out.println("You ran out of guesses. The number was: " + number);
                }
            }

            System.out.println("Your score: " + score);

            System.out.println("Play again? (y/n): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("y");
            System.out.print('\u000C');
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
