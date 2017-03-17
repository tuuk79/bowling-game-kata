package main;

import java.util.ArrayList;

public class ScoringManager {

	public int score(Game game) {
		int gameScore = 0;
		
		for(Frame frame: game.getFrames()) {
			ArrayList<Attempt> attempts = frame.getAttempts();
			
			if (frame.getCompletionStatus()) {
				for(Attempt attempt: attempts) {
					gameScore += attempt.getPinsKnockedDown();
				}
			}
		}
		
		return gameScore;
	}

}
