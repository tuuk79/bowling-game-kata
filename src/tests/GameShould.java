package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Game;

public class GameShould {
	private Game game;
	@Before
	public void setup() {
		 game = new Game();
	}

	@Test
	public void BeCreated() {	
		assertNotNull(game);
	}
	
	@Test
	public void HaveTenFrames() {
		int expected = 10;
		assertEquals(expected, game.getFrames());
	}
	
	@Test
	public void ReturnScore() {
		int numberOfPinsKnockedDown = 4;	
		game.updateScore(numberOfPinsKnockedDown);		
		assertEquals(4, game.getScore());
	}

}
