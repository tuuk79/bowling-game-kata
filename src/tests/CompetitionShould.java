package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Competition;

public class CompetitionShould {

	private Competition competition;
	
	@Before
	public void setup() {
	  competition = new Competition();
	}
	
	@Test
	public void BeAbleToHavePlayers() {
		assertNotNull(competition.players);
	}

}
