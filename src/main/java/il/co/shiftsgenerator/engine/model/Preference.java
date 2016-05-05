package il.co.shiftsgenerator.engine.model;

public enum Preference {

	BLOCKED(0),
	NOT_PREFERED(1),
	PREFERED(2);
	
	private int index;

	private Preference(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	
	
}
