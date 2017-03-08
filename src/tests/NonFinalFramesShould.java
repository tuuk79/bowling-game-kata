package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Frame;
import main.Game;
import main.NonFinalFrame;

public class NonFinalFramesShould {
	private Frame frame;
	
	@Before
	public void setup() {
		 nonFinalFrame = new NonFinalFrame();
		 
	}

	@Test
	public void BeCreated() {	
		assertNotNull(frame);
	}
	
	@Test
	public void HaveTwoAttemptsInARegularFrame() {
		int expected = 2;
		assertEquals(expected, nonFinalFrame.getAttempts());
	}
	
	@Test
	public void HaveTwoAttemptsInAFinalFrame() {
		int expected = 3;
		assertEquals(expected, finalFrame.getAttempts());
	}
}