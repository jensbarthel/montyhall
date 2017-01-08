package sim;

import java.util.concurrent.ThreadLocalRandom;

public class GameShow {
	private int prizePosition;
	private int leftDudPosition;
	private int rightDudPositions;
	private GameHost gameHost;
	private Contestant contestant;

	public GameShow() {
		prizePosition = ThreadLocalRandom.current().nextInt(0, 3);
		leftDudPosition = Math.floorMod(prizePosition - 1, 3);
		rightDudPositions = Math.floorMod(prizePosition + 1, 3);
		gameHost = new GameHost(leftDudPosition, prizePosition, rightDudPositions);
		contestant = new Contestant();
	}

	public ShowResult play() {
		int contestantDecision = contestant.announceDecision();
		int alternativePosition = gameHost.proposeAlternative(contestantDecision);
		contestant.decideOnSwitch(alternativePosition);
		contestantDecision = contestant.announceDecision();
		return resolve();
	}

	private ShowResult resolve() {
		int contestantFinalDecision = contestant.announceDecision();

		boolean hasWon = contestantFinalDecision == prizePosition ? true : false;
		boolean hasSwitched = contestant.hasSwiched();
		return new ShowResult(hasSwitched, hasWon);
	}
}
