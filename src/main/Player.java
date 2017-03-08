package main;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	public ArrayList<Game> games = null;
	private int pins;
	
	public Player() {
		games = new ArrayList<Game>();
	}
	
	public void roll(int numberOfPinsKnockedDown) {
		
	}

	public void startGame(Game game) {
		games.add(game);
		
	}

	public void updateScore(Game game, int numberOfPinsKnockedDown) {
		game.updateScore(numberOfPinsKnockedDown);
		games.add(game);
	}
	
	public int roll() {
	 return	pins = (int) (Math.random() * 11);
		
	}

}
