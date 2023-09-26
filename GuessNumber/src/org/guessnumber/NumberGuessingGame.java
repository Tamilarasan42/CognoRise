package org.guessnumber;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int maxAttempts = 5;
        int attempts = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've chosen a number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            
            if (guess < lowerBound || guess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }
            
            attempts++;
            
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("The number is higher. You have " + (maxAttempts - attempts) + " attempts remaining.");
            } else {
                System.out.println("The number is lower. You have " + (maxAttempts - attempts) + " attempts remaining.");
            }
        }
        
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        }
        
        scanner.close();
    }
}

