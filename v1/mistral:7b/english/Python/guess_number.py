# Here is a simple Python script for a number guessing game between a human and a machine. This script will generate a random number within a specified range, ask the player to guess the number, and provide feedback based on whether the guess is too high, too low, or correct.

# ```python
import random

def play_game():
    # Define the range for the random number
    min_value = 1
    max_value = 100

    # Generate a random number within the defined range
    number_to_guess = random.randint(min_value, max_value)

    guess = None
    attempts = 0

    print("Welcome to Guess the Number!")
    while guess != number_to_guess:
        guess = int(input("Guess a number between {} and {}. Enter 'q' to quit: ".format(min_value, max_value)))

        if guess == number_to_guess:
            print("Congratulations! You guessed the number correctly.")
        elif guess < number_to_guess:
            print("Too low. Try again.")
            attempts += 1
        elif guess > number_to_guess:
            print("Too high. Try again.")
            attempts += 1
        elif guess == 'q':
            print("Thanks for playing! Come back anytime.")
            break

    if guess is None:
        print("You didn't enter a valid guess, so the game ended automatically.")

play_game()
# ```

# To run the code, simply save it as a `.py` file (e.g., number_guessing_game.py) and execute it using Python:

# ```sh
# python number_guessing_game.py
# ```