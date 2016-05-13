package il.co.shiftsgenerator.engine.model;

public enum Preference {

	BLOCKED(0),
	NOT_PREFERRED(1),
	PREFERRED(2);
	
	private int index;

	private Preference(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	
	
}
