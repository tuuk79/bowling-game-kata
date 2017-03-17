package main;

import java.util.ArrayList;

public abstract class Frame {
	protected ArrayList<Attempt> attempts;
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
	
	protected ArrayList<Attempt> initializeAttempts(int maxAttempts) {
		ArrayList<Attempt> attempts = new ArrayList<Attempt>();
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
		
		return attempts;
	}

}
