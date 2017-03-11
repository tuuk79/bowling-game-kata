package main;

import java.util.ArrayList;

public abstract class Frame {
	public ArrayList<Attempt> attempts;
	private Boolean isComplete = false;
	
	public void markAsComplete() {
		isComplete = true;
	}

	public boolean getCompletionStatus() {
		return isComplete;
	}
}
