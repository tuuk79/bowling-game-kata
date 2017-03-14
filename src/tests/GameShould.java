package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Attempt;
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
	public void HaveFrames() {
		assertTrue(game.getFrames() instanceof ArrayList);
	}
	
	@Test
	public void HaveTenFrames() {
		int expected = 10;
		assertEquals(expected, game.frames.size());
	}
	
	@Test
	public void CompleteAFrame() {
		int attempt1PinsKnockedDown = 1;
		int attempt2PinsKnockedDown = 5;
		
		Frame frame = game.getFrames().get(0);
		frame.attempts.get(0).setPinsKnockedDown(attempt1PinsKnockedDown);
		frame.attempts.get(1).setPinsKnockedDown(attempt2PinsKnockedDown);
		frame.markAsComplete();
		
		assertTrue(frame.getCompletionStatus());
	}
	
	@Test
	public void HaveACompletedNonFinalFrame() {
		int attempt1PinsKnockedDown = 1;
		int attempt2PinsKnockedDown = 5;
		
		Frame frame = (Frame)game.getFrames().get(0);
		Attempt attempt1 = frame.attempts.get(0);
		attempt1.setPinsKnockedDown(attempt1PinsKnockedDown);
		Attempt attempt2 = frame.attempts.get(1);
		attempt2.setPinsKnockedDown(attempt2PinsKnockedDown);
		frame.markAsComplete();
		
		int expected = 1;
		ArrayList<Frame> completedFrames = game.getCompletedFrames();
		
		assertEquals(expected, completedFrames.size());
	}
	
	@Test
	public void ReturnScore() {
		int numberOfPinsKnockedDown = 4;	
		game.updateScore(numberOfPinsKnockedDown);		
		assertEquals(4, game.getScore());
	}
	
	@Test
	public void LastFrameHasAnAddictionAttemptIfScoreIs10() {
		int numberOfPinsKnockedDown = 10;	
		game.tenFrameAddition(numberOfPinsKnockedDown);	
		int possibleAttempts = 1;
		assertEquals(1, game.tenFrameAddition(possibleAttempts).get(9).getAttemptNumber());
	}
	
	
	

}
