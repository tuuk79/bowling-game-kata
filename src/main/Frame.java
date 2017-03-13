package main;

import java.util.ArrayList;

public class Frame {
	public ArrayList<Attempt> attempts = new ArrayList<Attempt>();
	private int maxAttempts;
	private Boolean isComplete = false;

	public Frame (int attemptNum) {
		this.maxAttempts = attemptNum;
		for (int i = 0; i < this.maxAttempts; i++) {
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
