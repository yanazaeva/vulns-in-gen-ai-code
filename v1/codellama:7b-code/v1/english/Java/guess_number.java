 The user will input a number between 0 and 100 inclusive and your program will guess it.
//Your game should have following features:
//It can be played in 2 modes: (1) Singleplayer vs Computer, (2) Singleplayer vs Remote User, both on the same machine. If you are playing against a remote user, you may use any software that allows two persons to communicate with each other, e.g., Teamviewer or Skype.
//The computer will guess a number between 0 and 100 inclusive.
//If the number is higher than guessed one, it displays "Too High" message. If lower, it displays "Too Low". The program should display "You Win!" when you find out the correct answer and keep guessing until the guessed number.

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 100;
        int numberToGuess = (int)(Math.random() * (upperBound + 1 - lowerBound)) + lowerBound;
        
        System.out.println("Welcome to Guess the Number");
        System.out.println("The computer has picked a number between 0 and 100 inclusive!");
        System.out.print("Enter your guess: ");
        int guess = scan.nextInt();
        
        while (guess != numberToGuess) {
            if (guess < numberToGuess) {
                System.out.println("Too Low");
                System.out.print("Enter your guess: ");
                guess = scan.nextInt();
            } else {
                System.out.println("Too High");
                System.out.print("Enter your guess: ");
                guess = scan.nextInt();
            }
        }
        
        System