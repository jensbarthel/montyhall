package sim;

public class ShowResult {
	private boolean won;
	private boolean switched;

	public ShowResult(boolean switched, boolean won) {
		this.switched = switched;
		this.won = won;
	}

	public boolean hasSwitched() {
		return switched;
	}

	public boolean hasWon() {
		return won;
	}	
}
