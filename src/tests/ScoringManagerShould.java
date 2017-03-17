package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import main.NonFinalFrame;
import main.Attempt;
import main.Frame;
import main.Game;
import main.ScoringManager;

public class ScoringManagerShould {
	private ScoringManager manager;
	private Game game;
	
	@Before
	public void setup() {
		game = new Game();
		manager = new ScoringManager();
	}

	@Test
	public void BeCreated() {
		assertNotNull(manager);
	}
	
	@Test
	public void ScoreAGame() {
		playNonFinalFrame(game, 1, 1, 2);
		playNonFinalFrame(game, 2, 3, 4);
		
		int expectedScore = 10;
	    int score = manager.score(game);
		
		assertEquals(expectedScore, score);
	}
	
	private Frame playNonFinalFrame(Game game, int frameIndex, int firstAttempt, int secondAttempt) {
		NonFinalFrame frame = (NonFinalFrame) game.getFrames().get(frameIndex - 1);
		
		ArrayList<Attempt> attempts = frame.getAttempts();
		
		Attempt attempt1 = attempts.get(0);
		Attempt attempt2 = attempts.get(1);
		
		attempt1.setPinsKnockedDown(firstAttempt);
		attempt2.setPinsKnockedDown(secondAttempt);

		frame.markAsComplete();
		
		return frame;
	}

}
	
	

