package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.Player;

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
		assertTrue(player.games instanceof ArrayList);
	}
	
	@Test
	public void playerPlaysOneGameAndKeepsTrackOfIt() {
		Player player = new Player();
		
		player.games.add(new Game());

		assertTrue(player.games.count() > 0);
	}

}
