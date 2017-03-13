package tests;


import static org.junit.Assert.*;

import java.awt.Frame;

import org.junit.Before;
import org.junit.Test;

public class FrameShould {
	private Frame frame;

	@Before
	public void setup() {
		frame = new Frame(3);
	}

	@Test
	public void BeCreated() {
		assertNotNull(frame);
	}
	
	@Test
	public void HaveThreeAttemptsInFinalFrame() {
		int expected = 3;
		assertEquals(expected, frame.getAttempts().size());
	}
}