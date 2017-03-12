package main;

import java.util.ArrayList;

public abstract class Frame {
	public ArrayList<Attempt> attempts = new ArrayList<Attempt>();
	private Boolean isComplete = false;
	
	public void markAsComplete() {
		isComplete = true;
	}

	public boolean getCompletionStatus() {
		return isComplete;
	}
	
	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
	
	public void setMaxAttempt(int maxAttempts) {
		
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
	}
}
