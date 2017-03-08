package main;

import java.util.List;

public class Game {

	private int score;
	private List<Frame> frames;
	
	public void updateScore(int numberOfPinsKnockedDown) {
		score += numberOfPinsKnockedDown;
	}

	public int getScore() {
		return score;
	};
	
	public List<Frame> getFrames() {
		return frames;
	}

	public int getCompleteFrames() {
		// TODO Auto-generated method stub
		return 0;
	}

}
