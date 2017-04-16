package main;

public class NonFinalFrame extends Frame {
	private final int maxAttempts = 2;

	public NonFinalFrame() {
		attempts = initializeAttempts(maxAttempts);
	}
	
	public Attempt getAttempt(int frameIndex) throws Exception {
		if (frameIndex > 1) {
			throw new Exception("There is no third attempt in a non-final frame");
		}
		else {
			return attempts.get(frameIndex);
		}
	}

}
