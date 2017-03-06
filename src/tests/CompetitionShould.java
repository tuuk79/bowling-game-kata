package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Competition;

public class CompetitionShould {

	@Test
	public void BeAbleToHavePlayers() {
		Competition competition = new Competition();

		assertNotNull(competition.players);
	}

}
