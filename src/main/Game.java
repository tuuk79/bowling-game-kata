package main;

public class Game {

	private int score;
	private int frames = 10;
	
	public void updateScore(int numberOfPinsKnockedDown) {
		score += numberOfPinsKnockedDown;
	}

	public int getScore() {
		return score;
	};
	
	public int getFrames() {
		return frames;
	}

}
