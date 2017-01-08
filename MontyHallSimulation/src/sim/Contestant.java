package sim;

import java.util.concurrent.ThreadLocalRandom;

public class Contestant {
	private int decision;
	private boolean hasSwiched;

	public Contestant() {
		this.decision = ThreadLocalRandom.current().nextInt(0, 3);
		this.hasSwiched = false;
	}

	public int announceDecision() {
		return decision;
	}

	public void decideOnSwitch(int alternativePosition) {
		hasSwiched = ThreadLocalRandom.current().nextBoolean();
		
		if(hasSwiched)
		{
			decision = alternativePosition;
		}
		
	}

	public boolean hasSwiched() {
		return hasSwiched;
	}
}
