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
				int frameScore = 0;
				for (Attempt attempt : frames.get(frameIndex).getAttempts()) {
					frameScore += attempt.getPinsKnockedDown();
				}

				frames.get(frameIndex).setScore(frameScore);
			}
			else {
				Frame currentFrame = frames.get(frameIndex);
				ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();
				Attempt currentFrameFirstAttempt = currentFrameAttempts.get(0);
				Attempt currentFrameSecondAttempt = currentFrameAttempts.get(1);
				int currentFrameFirstAttemptPinsKnockedDown = currentFrameFirstAttempt.getPinsKnockedDown();
				int currentFrameSecondAttemptPinsKnockedDown = currentFrameSecondAttempt.getPinsKnockedDown();
				
				Frame nextFrame = frames.get(frameIndex + 1);
				ArrayList<Attempt> nextFrameAttempts = nextFrame.getAttempts();
				Attempt nextFrameFirstAttempt = nextFrameAttempts.get(0);
				Attempt nextFrameSecondAttempt = nextFrameAttempts.get(1);
				int nextFrameFirstAttemptPinsKnockedDown = nextFrameFirstAttempt.getPinsKnockedDown();
				int nextFrameSecondAttemptPinsKnockedDown = nextFrameSecondAttempt.getPinsKnockedDown();
				
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
	
	public int getTotalScore(Game game) {
		int gameScore = 0;
		ArrayList<Frame> frames = game.getFrames();
		// total each frame score to get game score
		for (Frame frame : frames) {
			if (frame.isComplete) {
				gameScore += frame.getScore();	
			}
		}
		
		return gameScore;
	}
	
	public void processRegular(Game game, int frameIndex) {
		ArrayList<Frame> frames = game.getFrames();
		Frame currentFrame = frames.get(frameIndex);
		ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();
		Attempt currentFrameFirstAttempt = currentFrameAttempts.get(0);
		Attempt currentFrameSecondAttempt = currentFrameAttempts.get(1);
		int currentFrameFirstAttemptPinsKnockedDown = currentFrameFirstAttempt.getPinsKnockedDown();
		int currentFrameSecondAttemptPinsKnockedDown = currentFrameSecondAttempt.getPinsKnockedDown();
		
		int frameScore = 0;
		for (Attempt attempt : currentFrameAttempts) {
			frameScore += attempt.getPinsKnockedDown();
		}

		currentFrame.setScore(frameScore);
	}

	public void processSpare(Game game, int frameIndex) {
		ArrayList<Frame> frames = game.getFrames();
		Frame currentFrame = frames.get(frameIndex);
		ArrayList<Attempt> currentFrameAttempts = currentFrame.getAttempts();
		Attempt currentFrameFirstAttempt = currentFrameAttempts.get(0);
		Attempt currentFrameSecondAttempt = currentFrameAttempts.get(1);
		int currentFrameFirstAttemptPinsKnockedDown = currentFrameFirstAttempt.getPinsKnockedDown();
		int currentFrameSecondAttemptPinsKnockedDown = currentFrameSecondAttempt.getPinsKnockedDown();
		
		Frame nextFrame = frames.get(frameIndex + 1);
		ArrayList<Attempt> nextFrameAttempts = nextFrame.getAttempts();
		Attempt nextFrameFirstAttempt = nextFrameAttempts.get(0);
		Attempt nextFrameSecondAttempt = nextFrameAttempts.get(1);
		int nextFrameFirstAttemptPinsKnockedDown = nextFrameFirstAttempt.getPinsKnockedDown();
		int nextFrameSecondAttemptPinsKnockedDown = nextFrameSecondAttempt.getPinsKnockedDown();
		
		// mark frame as spare
		currentFrame.isSpare = true;
		
		int frameScore = 10 + nextFrameFirstAttemptPinsKnockedDown;
		currentFrame.setScore(frameScore);
	}
	
	public void processStrike(Game game, int frameIndex) {
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
		Attempt frameAfterNextFrameSecondAttempt = frameAfterNextFrameAttempts.get(1);
		int frameAfterNextFrameFirstAttemptPinsKnockedDown = frameAfterNextFrameFirstAttempt.getPinsKnockedDown();
		int frameAfterNextFrameSecondAttemptPinsKnockedDown = frameAfterNextFrameSecondAttempt.getPinsKnockedDown();
		
		// mark frame as strike
		currentFrame.isStrike = true;
		
		// score frame based on next two rolls
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
