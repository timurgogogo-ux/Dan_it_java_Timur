package java_core_home_worke_1_new;

import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let the game begin!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int secretNumber = random.nextInt(101);
        int[] guesses = new int[1];
        int attemptCount = 0;

        while (true) {
            System.out.print("Enter your guess (0–100): ");
            int guess = scanner.nextInt();

            if (attemptCount == guesses.length) {
                int[] newGuesses = new int[guesses.length + 1];
                for (int i = 0; i < guesses.length; i++) {
                    newGuesses[i] = guesses[i];
                }
                guesses = newGuesses;
            }

            guesses[attemptCount] = guess;
            attemptCount++;

            if (guess < secretNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (guess > secretNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + name + "!");
                System.out.print("Your guesses: ");

                for (int i = 0; i < attemptCount; i++) {
                    System.out.print(guesses[i] + " ");
                }

                System.out.println("\nYou guessed it in " + attemptCount + " attempts!");
                break;
            }
        }
        scanner.close();
    }
}
