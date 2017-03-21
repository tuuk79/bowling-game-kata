package main;

import java.util.ArrayList;

public class ScoringManager {

	public int score(Game game) {
		int gameScore = 0;
		ArrayList<Frame> frames = game.getFrames();

		for (int i = 0; i < frames.size(); i++) {
			int currentFrameScore = 0;

			Frame currentFrame = frames.get(i);
			ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();

			if (currentFrameAttempts.get(0).getPinsKnockedDown() == 10) {
				currentFrame.isStrike = true;
			} else if (currentFrameAttempts.get(0).getPinsKnockedDown()
					+ currentFrameAttempts.get(1).getPinsKnockedDown() == 10) {
				currentFrame.isSpare = true;
			} else {

				// process current frame
				for (Attempt attempt : currentFrameAttempts) {
					currentFrameScore += attempt.getPinsKnockedDown();
				}

				currentFrame.setScore(currentFrameScore);
			}

			currentFrame.isComplete = true;

			if (i != 0) {
				Frame previousFrame = frames.get(i - 1);

				if (previousFrame != null) {

					// score previous strike frame
					if (previousFrame.isStrike) {
						int previousFrameScore = 10 + currentFrameAttempts.get(0).getPinsKnockedDown()
								+ currentFrameAttempts.get(1).getPinsKnockedDown();
						previousFrame.setScore(previousFrameScore);
					}

					// score previous spare frame
					if (previousFrame.isSpare) {
						int previousFrameScore = 10 + currentFrameAttempts.get(0).getPinsKnockedDown();
						previousFrame.setScore(previousFrameScore);
					}
				}

			}
		}

		// total each frame score to get game score
		for (Frame frame : frames) {
			gameScore += frame.getScore();
		}

		return gameScore;
	}

}
