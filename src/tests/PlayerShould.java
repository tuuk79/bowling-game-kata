package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.Game;
import main.Player;

public class PlayerShould {

	@Test
	public void CreateAPlayer() {
		Player player = new Player();

		assertNotNull(player);
	}
	
	@Test
	public void BeAbleToRoll() {
		int numberOfPinsKnockedDown = 1;
		
		Player player = new Player();
		player.roll(numberOfPinsKnockedDown);
	}
	
	@Test
	public void StartGame() {
		Player player = new Player();
		player.startGame(new Game());
		assertEquals(1, player.games.size());
	}
	
	@Test
	public void UpdateGameScore() {
		Player player = new Player();
		Game game = new Game();
		
		int numberOfPinsKnockedDown = 1;
		player.updateScore(game, numberOfPinsKnockedDown);
		
		assertEquals(1, player.games.get(0).getScore());

	}
	
	@Test
	public void KeepTrackOfGames() {
		Player player = new Player();

		assertNotNull(player.games);
		assertTrue(player.games instanceof ArrayList);
	}
	
	@Test
	public void playerPlaysOneGameAndKeepsTrackOfIt() {
		Player player = new Player();
		
		player.games.add(new Game());

		assertTrue(player.games.size() > 0);
	}

}
