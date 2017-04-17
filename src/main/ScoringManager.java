package main;

import java.util.ArrayList;

public class ScoringManager {

	public int score(Game game) {
		int gameScore = 0;
		ArrayList<Frame> frames = game.getFrames();

		for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
			
			if (frameIndex == 8) {
				Frame currentFrame = frames.get(frameIndex);
				
				Frame nextFrame = frames.get(frameIndex + 1);
				ArrayList<Attempt> nextFrameAttempts = nextFrame.getAttempts();
				Attempt nextFrameFirstAttempt = nextFrameAttempts.get(0);
				Attempt nextFrameSecondAttempt = nextFrameAttempts.get(1);
				int nextFrameFirstAttemptPinsKnockedDown = nextFrameFirstAttempt.getPinsKnockedDown();
				int nextFrameSecondAttemptPinsKnockedDown = nextFrameSecondAttempt.getPinsKnockedDown();
				
				int frameScore = 10 + nextFrameFirstAttemptPinsKnockedDown + nextFrameSecondAttemptPinsKnockedDown;
				currentFrame.setScore(frameScore);
			}
			
			else if (frameIndex == 9) {
				Frame currentFrame = frames.get(frameIndex);
				ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();
				
				int frameScore = 0;
				
				for (Attempt attempt : currentFrameAttempts) {
					frameScore += attempt.getPinsKnockedDown();
				}

				currentFrame.setScore(frameScore);
			}
			else {
				Frame currentFrame = frames.get(frameIndex);
				ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();
				Attempt currentFrameFirstAttempt = currentFrameAttempts.get(0);
				Attempt currentFrameSecondAttempt = currentFrameAttempts.get(1);
				int currentFrameFirstAttemptPinsKnockedDown = currentFrameFirstAttempt.getPinsKnockedDown();
				int currentFrameSecondAttemptPinsKnockedDown = currentFrameSecondAttempt.getPinsKnockedDown();
				
				if (currentFrameFirstAttemptPinsKnockedDown == 10) {
					processStrike(game, frameIndex);
				}
				else if (currentFrameFirstAttemptPinsKnockedDown + currentFrameSecondAttemptPinsKnockedDown == 10) {
					processSpare(game, frameIndex);
				}
				else {
					processRegular(game, frameIndex);
				}
			}
		}

		gameScore = getTotalScore(game);

		return gameScore;
	}
	
	private int getTotalScore(Game game) {
		int gameScore = 0;
		ArrayList<Frame> frames = game.getFrames();

		for (Frame frame : frames) {
			if (frame.isComplete) {
				gameScore += frame.getScore();	
			}
		}
		
		return gameScore;
	}
	
	private void processRegular(Game game, int frameIndex) {
		ArrayList<Frame> frames = game.getFrames();
		Frame currentFrame = frames.get(frameIndex);
		ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();

		int frameScore = 0;
		
		for (Attempt attempt : currentFrameAttempts) {
			frameScore += attempt.getPinsKnockedDown();
		}

		currentFrame.setScore(frameScore);
	}

	private void processSpare(Game game, int frameIndex) {
		ArrayList<Frame> frames = game.getFrames();
		Frame currentFrame = frames.get(frameIndex);
		
		Frame nextFrame = frames.get(frameIndex + 1);
		ArrayList<Attempt> nextFrameAttempts = nextFrame.getAttempts();
		Attempt nextFrameFirstAttempt = nextFrameAttempts.get(0);
		int nextFrameFirstAttemptPinsKnockedDown = nextFrameFirstAttempt.getPinsKnockedDown();

		currentFrame.isSpare = true;
		
		int frameScore = 10 + nextFrameFirstAttemptPinsKnockedDown;
		currentFrame.setScore(frameScore);
	}
	
	private void processStrike(Game game, int frameIndex) {
		ArrayList<Frame> frames = game.getFrames();
		
		Frame currentFrame = frames.get(frameIndex);
		
		Frame nextFrame = frames.get(frameIndex + 1);
		ArrayList<Attempt> nextFrameAttempts = nextFrame.getAttempts();
		Attempt nextFrameFirstAttempt = nextFrameAttempts.get(0);
		Attempt nextFrameSecondAttempt = nextFrameAttempts.get(1);
		int nextFrameFirstAttemptPinsKnockedDown = nextFrameFirstAttempt.getPinsKnockedDown();
		int nextFrameSecondAttemptPinsKnockedDown = nextFrameSecondAttempt.getPinsKnockedDown();
		
		Frame frameAfterNextFrame = frames.get(frameIndex + 2);
		ArrayList<Attempt> frameAfterNextFrameAttempts = frameAfterNextFrame.getAttempts();
		Attempt frameAfterNextFrameFirstAttempt = frameAfterNextFrameAttempts.get(0);
		int frameAfterNextFrameFirstAttemptPinsKnockedDown = frameAfterNextFrameFirstAttempt.getPinsKnockedDown();

		currentFrame.isStrike = true;
		
		if (nextFrameFirstAttemptPinsKnockedDown == 10) {
			int frameScore = 10 + nextFrameFirstAttemptPinsKnockedDown	+ frameAfterNextFrameFirstAttemptPinsKnockedDown;
			frames.get(frameIndex).setScore(frameScore);
		}
		else {
			int frameScore = 10 + nextFrameFirstAttemptPinsKnockedDown	+ nextFrameSecondAttemptPinsKnockedDown;
			frames.get(frameIndex).setScore(frameScore);
		}
	}

}
