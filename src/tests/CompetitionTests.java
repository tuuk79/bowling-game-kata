package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Competition;

public class CompetitionTests {

	@Test
	public void shouldCreateACompetition() {
		Competition competition = new Competition();

		assertNotNull(competition);
	}

}
