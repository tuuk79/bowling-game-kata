package tests;


import static org.junit.Assert.*;


import main.Frame;

import org.junit.Before;
import org.junit.Test;


public class FrameShould {
	private Frame frame;
	int num = 3;
	

	@Before
	public void setup() {
		frame = new Frame(num);
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
