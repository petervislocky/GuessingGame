package com.game;
import java.util.Random;

public class Game {
	private int UserScore = 0;
	private int CompScore = 0;
	
	public int ranNumGen() {
		Random r = new Random();
		int ranNum = r.nextInt(101);
		return ranNum;
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
