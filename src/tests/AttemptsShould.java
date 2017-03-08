package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Attempt;

public class AttemptsShould {
	private Attempt attempt;
	
	@Before
	public void setup() {
		 attempt = new Attempt();
	}

	@Test
	public void BeCreated() {	
		assertNotNull(attempt);
	}
}
