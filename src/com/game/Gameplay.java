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
	
	public void questions(int num) {
		System.out.println("Choose 1 question as a hint(1-4)");
		System.out.println("1 Is the number even?\n2 Is the number a prime number?\n3 Is the number divisible by 5\n4 Is the number divisible by 3");
		int qChoice = input.nextInt();
		input.nextLine();
		switch(qChoice) {
		case 1:
			if (num % 2 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			break;
		case 2:
			if (g.isPrime(num) == true) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			break;
		case 3:
			if (num % 5 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			break;
		case 4:
			if (num % 3 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
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
				System.out.println("Error: " + ex);
			}
			try {
				ranNum = g.ranNumGen();
			}
			catch(Exception ex) {
				System.out.println("Invalid Selection. Restarting.");
				continue;
			}
			
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				System.out.println("Error: " + ex);
			}
			try {
				this.questions(ranNum);	
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Selection. Restarting");
				input.next();
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
