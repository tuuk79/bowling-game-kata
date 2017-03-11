package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.NonFinalFrame;

public class NonFinalFrameShould {
	private NonFinalFrame nonFinalFrame;
	@Before
	public void setup() {
		 nonFinalFrame = new NonFinalFrame();
	}

	@Test
	public void BeCreated() {
		assertNotNull(nonFinalFrame);
	}
	
	@Test
	public void HaveTwoAttemptsInARegularFrame() {
		int expected = 2;
		assertEquals(expected, nonFinalFrame.getAttempts().size());
	}
}
