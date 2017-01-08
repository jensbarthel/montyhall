package sim;

import java.util.concurrent.ThreadLocalRandom;

public class GameHost {

	private int leftDudPosition;
	private int rightDudPosition;
	private int prizePosition;

	public GameHost(int leftDudPosition, int prizePosition, int rightDudPosition) {
		this.leftDudPosition = leftDudPosition;
		this.prizePosition = prizePosition;
		this.rightDudPosition = rightDudPosition;
	}

	public int proposeAlternative(int contestantDecision) {
		int eliminatedPosition = eliminatePosition(contestantDecision);
		
		int leftProposition = Math.floorMod(eliminatedPosition - 1, 3);
		int rightProposition = Math.floorMod(eliminatedPosition + 1, 3);

		return leftProposition != contestantDecision ? leftProposition : rightProposition;
	}

	private int eliminatePosition(int contestantDecision) {
		if (contestantDecision == prizePosition) {
			boolean eliminateLeftDud = ThreadLocalRandom.current().nextBoolean();
			
			return eliminateLeftDud ? leftDudPosition : rightDudPosition;
		}

		return leftDudPosition == contestantDecision ? rightDudPosition : leftDudPosition;
	}

}
