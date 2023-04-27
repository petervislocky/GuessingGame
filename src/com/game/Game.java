package com.game;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private int UserScore = 0;
	private int CompScore = 0;
	
	public int selectDifficulty() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose a Difficulty\n1 Easy(0-50)\n2 Medium (0-100)\n3 Hard(0-200)\n4 Extreme(0-300)");
		int choice = input.nextInt();
		input.nextLine();
		if (choice == 1) {
			System.out.println("You chose: Easy(0-50)");
			return 51;
		}
		else if(choice == 2) {
			System.out.println("You chose: Medium(0-100)");
			return 101;
		}
		else if(choice == 3) {
			System.out.println("You chose: Hard(0-200)");
			return 201;
		}
		else if(choice == 4) {
			System.out.println("You chose: Extreme(0-300)");
			return 301;
		} else {
			System.out.println("Invalid Selection. Defaulting to easy.");
			return 51;
		}
	}
	
	public int ranNumGen() {
		Random r = new Random();
		int ranNum = r.nextInt(selectDifficulty());
		return ranNum;
	}
	
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		int sqrtN = (int) Math.sqrt(n);
		for (int i = 2; i < sqrtN; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void SetUserScore() {
		this.UserScore++;	
	}
	
	public int GetUserScore() {
		return UserScore;
	}
	
	public void SetCompScore() {
		this.CompScore++;
	}
	
	public int GetCompScore() {
		return CompScore;
	}
}