package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.FinalFrame;

public class FinalFrameShould {
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
	public void HaveThreeAttemptsInAFinalFrame() {
		int expected = 3;
		assertEquals(expected, finalFrame.getAttempts().size());
	}
}
