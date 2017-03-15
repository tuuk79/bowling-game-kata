package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Attempt;

public class AttemptShould {
	private Attempt attempt;
	
	@Before
	public void setup() {
		 attempt = new Attempt();
	}

	@Test
	public void BeCreated() {
		assertNotNull(attempt);
	}
	
	@Test
	public void StorePinsKnockedDown() {
		int expected = 1;
		int pinsKnockedDown = 1;
		attempt.setPinsKnockedDown(pinsKnockedDown);
		
		assertEquals(expected, attempt.getPinsKnockedDown());
		
	}
}
