package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.FinalFrame;
import main.Frame;
import main.Game;
import main.NonFinalFrame;

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
}
