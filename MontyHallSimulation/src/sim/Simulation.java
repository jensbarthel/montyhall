package sim;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Simulation {
	private long cycles;
	private AtomicLong timesSwitched;
	private AtomicLong timesSwitchedAndWon;
	private AtomicLong timesNotSwitchedAndWon;

	public Simulation(long cycles) {
		this.cycles = cycles;
		timesSwitched = new AtomicLong();
		timesSwitchedAndWon = new AtomicLong();
		timesNotSwitchedAndWon = new AtomicLong();
	}

	public SimulationResult run() {
		LongStream.range(0, cycles).parallel().forEach((i) -> runEvent());
		return createResult();
	}

	private SimulationResult createResult() {
		return new SimulationResult(cycles, timesSwitched, timesSwitchedAndWon, timesNotSwitchedAndWon);
	}

	private void runEvent() {
		ShowResult gameShowResult = new GameShow().play();

		boolean hasWon = gameShowResult.hasWon();

		if (gameShowResult.hasSwitched()) {
			timesSwitched.incrementAndGet();

			if (hasWon) {
				timesSwitchedAndWon.incrementAndGet();
			}
		} else {
			if (hasWon) {
				timesNotSwitchedAndWon.incrementAndGet();
			}
		}
	}
}
