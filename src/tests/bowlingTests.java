package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Competition;
import main.Game;
import main.Player;

public class BowlingTests {
	
	private Game game;
	private Player player;
	private Competition competition;
	
	@Before
	public void setup() {
	  game = new Game();
	  player = new Player();
	  competition = new Competition();
	}

	@Test
	public void bowlingCompetitionShouldHaveAtLeastOnePlayer() {
		competition.players.add(player);
		assertTrue(competition.getPlayers() > 0);
	}
	
	@Test
	public void eachPlayerCanPlayGames() {
		player.games = new ArrayList<Game>();
		player.games.add(game);
		
		assertTrue(player.games.size() > 0);
	}
   
}
