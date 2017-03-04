package main;

public class Game {

	public int score;
	
	public void roll(int i) {
		score += i;
	}

	public int score() {
		return score;
	};

}
