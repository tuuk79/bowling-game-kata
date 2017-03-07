package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Game;
import main.Player;

public class PlayerShould {
	
	private Player player;
	private Game game;
	
	@Before
	public void setup() {
		player = new Player();
		game = new Game();
	}

	@Test
	public void CreateAPlayer() {
		assertNotNull(player);
	}
	
	@Test
	public void BeAbleToRoll() {
		int numberOfPinsKnockedDown = 1;
		
		player.roll(numberOfPinsKnockedDown);
	}
	
	@Test
	public void StartGame() {
		player.startGame(new Game());
		assertEquals(1, player.games.size());
	}
	
	@Test
	public void UpdateGameScore() {
		
		int numberOfPinsKnockedDown = 1;
		player.updateScore(game, numberOfPinsKnockedDown);
		
		assertEquals(1, player.games.get(0).getScore());

	}
	
	@Test
	public void KeepTrackOfGames() {
		assertNotNull(player.games);
		assertTrue(player.games instanceof ArrayList);
	}
	
	@Test
	public void playerPlaysOneGameAndKeepsTrackOfIt() {
		
		player.games.add(new Game());

		assertTrue(player.games.size() > 0);
	}

}
