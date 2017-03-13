package main;

import java.util.ArrayList;

public class Frame {
	private ArrayList<Attempt> attempts = new ArrayList<Attempt>();
	private int maxAttempts = 3;
	private Boolean isComplete = false;
	
    public Frame(int maxAttempts) {
		
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
	}
	
	public void markAsComplete() {
		isComplete = true;
	}

	public boolean getCompletionStatus() {
		return isComplete;
	}
	
	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
	
	
	
}
