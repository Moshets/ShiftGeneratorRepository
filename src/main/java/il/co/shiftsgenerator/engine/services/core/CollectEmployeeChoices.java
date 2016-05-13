package il.co.shiftsgenerator.engine.services.core;

import java.util.List;

import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.Shift;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import com.google.common.base.Function;

/**
 * This Function will collect the choices for each shift and will populate the employee availability 
 * {@link Shift#setAvailableEmployees(java.util.List)}
 * @author moshets
 *
 */
public class CollectEmployeeChoices implements Function<Board, Board> {

	@Override
	public Board apply(Board board) {
		List<ShiftConfiguration> shiftConfigurations = board.getShiftEngineInput().getShiftConfigurations();
		board.getShiftsOnBoardMap();
		return null;
	}

}
