package main;

import java.util.ArrayList;

public class Competition {

	public ArrayList<Player> players;
	public Competition () {
		players = new ArrayList<Player>();
	}
	public int getPlayers() {
	
		return players.size();
	}
}
