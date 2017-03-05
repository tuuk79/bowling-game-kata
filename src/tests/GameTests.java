package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Game;

public class GameTests {
	private Game game;
	
	@Before
	public void setup() {
	  game = new Game();
	}
	

	@Test
	public void shouldCreateAGame() {
		assertNotNull(game);
	}
	@Test
	public void gutterBall() {
		
		for (int i = 0; i < 20; i++){
			game.roll(0);
		}
		
		assertTrue(game.score == 0);
		
	}
	
	@Test
	public void scoreUnderATenInASingleFrame() {
		
		for (int i = 0; i< 2; i++){
			game.roll(9);
		}
		
		assertEquals(9, game.score());
		
		game.roll(1);
		game.roll(2);
		assertEquals(12, game.score());
		
		game.roll(3);
		game.roll(3);
		assertEquals(18,game.score());
	}
	

}
