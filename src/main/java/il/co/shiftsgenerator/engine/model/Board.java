package il.co.shiftsgenerator.engine.model;

import java.util.List;
import java.util.Map;

public class Board{

	private ShiftEngineInput shiftEngineInput;
	private Map<String, ShiftOnBoard> shiftsOnBoardMap;
	
	public ShiftEngineInput getShiftEngineInput() {
		return shiftEngineInput;
	}

	public void setShiftEngineInput(ShiftEngineInput shiftEngineInput) {
		this.shiftEngineInput = shiftEngineInput;
	}

	public Map<String, ShiftOnBoard> getShiftsOnBoardMap() {
		return shiftsOnBoardMap;
	}

	public void setShiftsOnBoardMap(Map<String, ShiftOnBoard> shiftsOnBoardMap) {
		this.shiftsOnBoardMap = shiftsOnBoardMap;
	}

	
	
	
	
}
