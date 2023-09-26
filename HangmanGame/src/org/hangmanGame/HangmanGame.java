package org.hangmanGame;
import java.util.Scanner;
import java.util.Random;
public class HangmanGame {
	public static void main(String[] args) {
		String[] words = {"apple" , "banana", "cherry","grape","kiwi","orange"};
		Random r = new Random();
		String wordToGuess = words[r.nextInt(words.length)];
		int maxAttempts = 6;
		int attemptsLeft = maxAttempts;
		StringBuilder guessedWord = new StringBuilder(wordToGuess.length());
		
		
		for (int i = 0; i < wordToGuess.length(); i++) {
			guessedWord.append("_");
		}
		Scanner s = new Scanner (System.in);
		System.out.println("welcome to Hangman!");
		System.out.println("you have " + maxAttempts + "attempts to guess the word.");
		System.out.println("Here's the word: "+ guessedWord);
		
		while (attemptsLeft > 0) {
			System.out.println("Guess a letter: ");
			char guess = s.next().charAt(0);
			
			boolean correctGuess = false;
			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == guess) {
					guessedWord.setCharAt(i,guess);
					correctGuess = true;
				}
				
			}
			if (correctGuess) {
				System.out.println("Good guess! Here's the word: "+ guessedWord);
			} else {
				attemptsLeft--;
				System.out.println("Incorrect guess. Attempts left: " + attemptsLeft);
			}
			if (wordToGuess.equals(guessedWord.toString())) {
			System.out.println("Congratulation! You Guessed the word: " + wordToGuess);	
			break;
			}
		}
		if (attemptsLeft == 0) {
			System.out.println("Out of Attempts! The word was: "+ wordToGuess);
		}
		s.close();
	}

}
