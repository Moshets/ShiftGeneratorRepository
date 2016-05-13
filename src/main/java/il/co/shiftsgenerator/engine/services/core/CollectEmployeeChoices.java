package il.co.shiftsgenerator.engine.services.core;

import java.util.List;
import java.util.Map;

import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.Employee;
import il.co.shiftsgenerator.engine.model.Preference;
import il.co.shiftsgenerator.engine.model.Shift;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;
import il.co.shiftsgenerator.engine.model.ShiftOnBoard;

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
		Map<String, ShiftOnBoard> shiftsOnBoardMap = board.getShiftsOnBoardMap();
		List<Employee> employees = board.getShiftEngineInput().getEmployees();
		for (Employee employee : employees) {
			List<Shift> shifts = employee.getShifts();
			for (Shift shift : shifts) {
				ShiftOnBoard shiftOnBoard = shiftsOnBoardMap.get(shift.getShiftKey());
				if(Preference.BLOCKED != shift.getPreference()){
					shiftOnBoard.getAvailableEmployees().add(employee.getEmployeeMetadata());
				}
			}
		}
		return board;
	}

}
