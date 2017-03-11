package main;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	public int maxAttempts = 3;
	
	public FinalFrame() {
		attempts = new ArrayList<Attempt>();
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
	}

	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
	
}
