package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTests {

	@Test
	public void shouldCreateAPlayer() {
		Player player = new Player();

		assertNotNull(player);
	}
	
	@Test
	public void playerShouldKeepTrackOfGames() {
		Player player = new Player();

		assertNotNull(player.games);
	}

}
