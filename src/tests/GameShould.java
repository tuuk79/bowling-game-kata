package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Frame;
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
		assertEquals(expected, game.getFrames().size());
	}
	
	@Test
	public void HaveFrames() {
		assertTrue(game.getFrames() instanceof List);
		assertTrue(game.getFrames().get(0) instanceof Frame);
	}
	
	@Test
	public void CompleteANonFinalFrame() {
		int expected = 1;
		assertEquals(expected, game.getCompleteFrames());
	}
	
	@Test
	public void ReturnScore() {
		int numberOfPinsKnockedDown = 4;	
		game.updateScore(numberOfPinsKnockedDown);		
		assertEquals(4, game.getScore());
	}
	
	

}
