package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Frame;
import main.NonFinalFrame;

public class NonFinalFramesShould {
	private Frame frame;
	private NonFinalFrame nonFinalFrame;
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
}
