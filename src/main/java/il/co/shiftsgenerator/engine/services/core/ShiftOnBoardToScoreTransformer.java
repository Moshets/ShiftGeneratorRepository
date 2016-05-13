package il.co.shiftsgenerator.engine.services.core;

import il.co.shiftsgenerator.engine.model.ShiftOnBoard;

import com.google.common.base.Function;

public class ShiftOnBoardToScoreTransformer implements
		Function<ShiftOnBoard, Double> {

	@Override
	public Double apply(ShiftOnBoard shiftOnBoard) {
		int availableEmployeeCapacity = shiftOnBoard.getAvailableEmployees().size();
		int shiftConfigurationcapacity = shiftOnBoard.getShiftConfiguration().getCapacity();
		
		return ((shiftConfigurationcapacity*1.0)/availableEmployeeCapacity);
	}
}
