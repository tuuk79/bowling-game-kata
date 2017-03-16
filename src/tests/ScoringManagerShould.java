package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Attempt;
import main.Frame;
import main.Game;
import main.ScoringManager;

public class ScoringManagerShould {
	private ScoringManager manager;
	
	@Before
	public void setup() {
		Game mockGame = new Game();
		
		Frame mockFirstFrame = mockGame.getFrames().get(0);
		mockFirstFrame.attempts.get(0).setPinsKnockedDown(1);
		mockFirstFrame.attempts.get(1).setPinsKnockedDown(3);
		
		manager = new ScoringManager();
	}

	@Test
	public void BeCreated() {
		assertNotNull(manager);
	}
	
	@Test
	public void ScoreAGame() {
		int gameScore = manager.score(game);
		assertEquals(4, gameScore);
	}
}
