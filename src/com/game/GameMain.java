package com.game;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		Game g = new Game();
		
		int x = 0;
		
		while (x == 0) {
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
			catch(Exception ex) {
				System.out.println("Must input a number. Game Over.");
				input.nextLine();
			}
			if (userGuessedNum == false) {
				g.SetCompScore();
			}
			System.out.println("The number was " + ranNum);
			System.out.println("Score: \nYOU: " + g.GetUserScore());
			System.out.println("COMPUTER: " + g.GetCompScore());
			System.out.print("Play Again? y/n ");
			String again = input.nextLine();
			
			if (again.equalsIgnoreCase("y")) {
				continue;
			}
			else if (again.equalsIgnoreCase("n")) {
				x = 1;
				input.close();
			} else {
				System.out.println("Invalid command. Exiting.");
				x = 1;
				input.close();
			}
		}
		
	}

}
// create a new gameplay class and move all the gameplay related code into methods in that class.
// create a git repository for this. Also learn git while im at it. I'll need it if i royally fuck something up.