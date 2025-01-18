import java.util.Scanner;
import static java.lang.System.out;

public class GuessTheNumber {
    private static final int NUMBER_TO_GUESS = 42;
    private static int numberToGuess;
    private static Scanner scanner;

    public static void main(String[] args) {
        numberToGuess = NUMBER_TO_GUEST;
        scanner = new Scanner(System.in);

        out.println("Welcome to the Guess the Number game!");
        out.println();
        playGame();
    }

    private static void playGame() {
        int guess;

        do {
            out.print("Enter a number between 1 and 100: ");
            guess = scanner.nextInt();

            if (guess < numberToGuess) {
                out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                out.println("Too high! Try again.");
            } else {
                out.println("Congratulations! You've guessed the number in " + (NUMBER_TO_GUESS == numberToGuess ? 1 : Game.getTurnsCount()) + " turns.");
            }
        } while (guess != numberToGuess);
    }

    private static int getTurnsCount() {
        return NUMBER_TO_GUEST == numberToGuess ? 1 : NUMBER_TO_GUESS + 1;
    }
}
