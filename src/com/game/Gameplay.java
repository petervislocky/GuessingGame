package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameplay {
	private int ranNum;
	private Game g = new Game();
	private Scanner input = new Scanner(System.in);
	
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
			boolean userGuessedNum = false;
			
			System.out.println("Number Guessing Game!\nYou have 5 guesses ");
			
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				System.out.println("Error:" + ex);
			}
			try {
				ranNum = g.ranNumGen();
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Selection. Restarting.");
				continue;
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
					else if (userGuess > ranNum) {
						System.out.println("Wrong! Too high!");
						if (Math.abs(userGuess - ranNum) <= 2) {
							System.out.println("Close! But too high.");
						}
					}
					else if (userGuess < ranNum) {
						System.out.println("Wrong! Too low!");
						if (Math.abs(userGuess - ranNum) <= 2) {
							System.out.println("Close! But, too low.");
						}
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
			if (ranNum == 69) {
				System.out.println("The number was " + ranNum + "...Nice");
			} else {
				System.out.println("The number was " + ranNum);				
			}
			DisplayScore();
			play = playAgain();
	}
			input.close();
  }
}
