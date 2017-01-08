package main;

import sim.Simulation;

public class SimulationRunner {
	public static void main(String[] args) {
		long cycles = 1_000_000_000L;
		Simulation simulation = new Simulation(cycles);		
		System.out.println(simulation.run());
	}
}
