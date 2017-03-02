package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTests {

	@Test
	public void bowlingCompetitionShouldHaveAtLeastOnePlayer() {
		Competition competition = new Competition();
		Player player = new Player();
		
		competition.players.add(player);

		assertTrue(competition.getPlayers() > 0);
	}
	
	@Test
	public void eachPlayerCanPlayGames() {
		Player player = new Player();
		player.games = new ArrayList<Game>();
		
		Game game = new Game();
		player.games.add(game);
		
		assertTrue(player.games > 0);
	}
	

	
	@Test
	public void playerRollsAndGameReturnsNumberOfPinsKnockedDown() {
		Game game = new Game();
		game.currentPlayer = game.getPlayer();
		int pinsKnockedDown = game.currentPlayer.roll();
		game.currentPlayer.totalPinsKnockedDown = pinsKnockedDown;

		assertEquals(game.currentPlayer.totalPinsKnockedDown, pinsKnockedDown);
	}

}
