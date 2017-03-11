package main;

import java.util.ArrayList;

public class NonFinalFrame extends Frame {
	public int maxAttempts = 2;
	
	public NonFinalFrame() {
		attempts = new ArrayList<Attempt>();
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
	}

	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
}
