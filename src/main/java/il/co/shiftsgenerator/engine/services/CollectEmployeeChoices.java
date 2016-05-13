package il.co.shiftsgenerator.engine.services;

import il.co.shiftsgenerator.engine.model.Shift;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import com.google.common.base.Function;

/**
 * This Function will collect the choices for each shift and will populate the employee availability 
 * {@link Shift#setAvailableEmployees(java.util.List)}
 * @author moshets
 *
 */
public class CollectEmployeeChoices implements
		Function<ShiftEngineInput, ShiftEngineInput> {

	@Override
	public ShiftEngineInput apply(ShiftEngineInput shiftEngineInput) {
		// TODO Auto-generated method stub
		return null;
	}

}
