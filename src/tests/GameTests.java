package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Game;

public class GameTests {

	@Test
	public void shouldCreateAGame() {
		Game game = new Game();

		assertNotNull(game);
	}

}
