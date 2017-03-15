package tests;

import static org.junit.Assert.*;

import org.junit.Before;

import main.AttemptAmounts;

public class AttemptAmountsShould {
	private AttemptAmounts countHolder;
	
	@Before
	public void setup() {
		countHolder = new AttemptAmounts();
	}

	public void has2Attempts() {
		int two = 2;
		assertEquals(two, countHolder.twoAttempts());
	}
	
	public void has3Attempts() {
		int three = 3;
		assertEquals(three, countHolder.threeAttempts());	
	}
}
