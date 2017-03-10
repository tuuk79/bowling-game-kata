package main;

import java.util.List;

public abstract class Frame {
	List<Attempt> attempts;
	public static Frame getInstance() {
        
        return new Attempt();
    }
}
