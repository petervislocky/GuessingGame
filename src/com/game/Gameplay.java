package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Gameplay {
	Game g = new Game();
	Scanner input = new Scanner(System.in);
	
	public void DisplayScore() {
		System.out.println("Score: \nYOU: " + g.GetUserScore());
		System.out.println("COMPUTER: " + g.GetCompScore());
	}
	
	public boolean playAgain() {
		System.out.print("Play Again? y/n ");
		String again = input.nextLine();
		
		if (again.equalsIgnoreCase("y")) {
			return true;
		}
		else if (again.equalsIgnoreCase("n")) {
			return false;
		} else {
			System.out.println("Invalid command. Exiting.");
			return false;
		}
	}
	
	public void playGame() {
		boolean play = true;
		
		while (play) {
			int ranNum = g.ranNumGen();
			boolean userGuessedNum = false;
			
			System.out.println("Number Guessing Game!(0-100)\nYou have 5 guesses ");
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ex) {
				System.out.println("Error:" + ex);
			}
		
			try {
				for (int i = 1; i < 6; i++) {
					System.out.print("Try #" + i + ": ");
					int userGuess = input.nextInt();
					input.nextLine();
					
					if (userGuess == ranNum) {
						System.out.println("Correct! You win in " + i + " tries!");
						g.SetUserScore();
						userGuessedNum = true;
						break;
					}
					else if (userGuess > ranNum && userGuess < 101) {
						System.out.println("Wrong! Too high!");
						if (Math.abs(userGuess - ranNum) <= 2) {
							System.out.println("Close! But too high.");
						}
					}
					else if (userGuess < ranNum && userGuess > 0) {
						System.out.println("Wrong! Too low!");
						if (Math.abs(userGuess - ranNum) <= 2) {
							System.out.println("Close! But, too low.");
						}
					} else {
						System.out.println("The number is between 0-100!");
					}
				}
		}
			catch(InputMismatchException ex) {
				System.out.println("Must input a number. Game Over.");
				input.nextLine();
			}
			if (userGuessedNum == false) {
				g.SetCompScore();
			}
			System.out.println("The number was " + ranNum);
			DisplayScore();
			play = playAgain();
	}
			input.close();
  }
}
