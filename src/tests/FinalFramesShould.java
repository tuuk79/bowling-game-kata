package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.FinalFrame;

public class FinalFramesShould {
	private FinalFrame finalFrame;

	@Before
	public void setup() {
		 finalFrame = new FinalFrame();
	}

	@Test
	public void BeCreated() {
		assertNotNull(finalFrame);
	}
	
	@Test
	public void HaveTwoAttemptsInAFinalFrame() {
		int expected = 3;
		assertEquals(expected, finalFrame.getAttempts());
	}
}
