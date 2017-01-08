package sim;

import java.util.concurrent.atomic.AtomicLong;

public class SimulationResult {
	private long cycles;
	private long timesSwitched;
	private long timesSwitchedAndWon;
	private long timesNotSwitchedAndWon;

	public SimulationResult(long cycles, AtomicLong timesSwitched, AtomicLong timesSwitchedAndWon,
			AtomicLong timesNotSwitchedAndWon) {
		this.cycles = cycles;
		this.timesSwitched = timesSwitched.longValue();
		this.timesSwitchedAndWon = timesSwitchedAndWon.longValue();
		this.timesNotSwitchedAndWon = timesNotSwitchedAndWon.longValue();
	}

	@Override
	public String toString() {
		double percentageSwitchedAndWon = calculatePercentage(timesSwitchedAndWon, timesSwitched);
		double percentageNotSwitchedAndWon = calculatePercentage(timesNotSwitchedAndWon, cycles - timesSwitched);
		
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("Games won with switch:\t\t");
		messageBuilder.append(percentageSwitchedAndWon);
		messageBuilder.append("%");
		messageBuilder.append(System.lineSeparator());
		messageBuilder.append("Games won without switch:\t");
		messageBuilder.append(percentageNotSwitchedAndWon);
		messageBuilder.append("%");
		
		return messageBuilder.toString();
	}

	private double calculatePercentage(long divisor, long dividend) {
		return ((double) divisor / (double) dividend) * 100;
	}
}
