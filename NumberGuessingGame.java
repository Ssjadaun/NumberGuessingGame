import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int secretNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100

    int guessCount = 0;
    int maxGuesses = 10; // Maximum allowed guesses

    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

    while (guessCount < maxGuesses) {
      System.out.print("Enter your guess: ");
      int guess;
      try {
        guess = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Clear the scanner buffer
        continue;
      }

      guessCount++;

      if (guess == secretNumber) {
        System.out.println("Congratulations! You guessed the number in " + guessCount + " tries.");
        break;
      } else if (guess < secretNumber) {
        System.out.println("Your guess is too low. Try again.");
      } else {
        System.out.println("Your guess is too high. Try again.");
      }
    }

    if (guessCount == maxGuesses) {
      System.out.println("Sorry, you ran out of guesses. The number was " + secretNumber + ".");
    }

    scanner.close();
  }
}
