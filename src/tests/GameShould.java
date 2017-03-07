package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Game;
import main.Player;

public class GameShould {
	private Game game;
	@Before
	public void setup() {
		 game = new Game();
	}

	@Test
	public void CreateAGame() {	
		assertNotNull(game);
	}
	
	@Test
	public void HaveTenFrames() {
		int expected = 10;
		assertEquals(expected, game.getFrames());
	}
	
	@Test
	public void KeepItsScore() {
		int numberOfPinsKnockedDown = 4;	
		game.updateScore(numberOfPinsKnockedDown);		
		assertEquals(4, game.getScore());
	}

}
