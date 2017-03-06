package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Game;
import main.Player;

public class GameShould {

	@Test
	public void CreateAGame() {
		Game game = new Game();
		assertNotNull(game);
	}
	
	@Test
	public void HaveTenFrames() {
		int expected = 10;
		
		Game game = new Game();
		assertEquals(expected, game.getFrames());
	}
	
	@Test
	public void KeepItsScore() {
		int numberOfPinsKnockedDown = 4;
		
		Game game = new Game();
		game.updateScore(numberOfPinsKnockedDown);
		
		assertEquals(4, game.getScore());
	}

}
