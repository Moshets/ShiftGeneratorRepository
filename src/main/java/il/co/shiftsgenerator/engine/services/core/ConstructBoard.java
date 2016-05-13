package il.co.shiftsgenerator.engine.services.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.EmployeeMetadata;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;
import il.co.shiftsgenerator.engine.model.ShiftOnBoard;
import il.co.shiftsgenerator.engine.services.validation.ShiftConfigurationToShiftKeyTransformer;

import com.google.common.base.Function;

public class ConstructBoard implements Function<ShiftEngineInput, Board> {

	private ShiftConfigurationToShiftKeyTransformer configurationToShiftKeyTransformer;
	
	@Override
	public Board apply(ShiftEngineInput shiftEngineInput) {
		Board  board = new Board();
		board.setShiftEngineInput(shiftEngineInput);
		List<ShiftConfiguration> shiftConfigurations = shiftEngineInput.getShiftConfigurations();
		Map<String, ShiftOnBoard> shiftOnBoardMap = constructShiftsOnBoardMap(shiftConfigurations);
		board.setShiftsOnBoardMap(shiftOnBoardMap);
		return board;
	}

	private Map<String, ShiftOnBoard> constructShiftsOnBoardMap(
			List<ShiftConfiguration> shiftConfigurations) {
		Map<String, ShiftOnBoard> shiftOnBoardMap =  new HashMap<String, ShiftOnBoard>();
		for (ShiftConfiguration shiftConfiguration : shiftConfigurations) {
			ShiftOnBoard shiftOnBoard = new ShiftOnBoard();
			shiftOnBoard.setShiftConfiguration(shiftConfiguration);
			shiftOnBoard.setAvailableEmployees(new ArrayList<EmployeeMetadata>());
			shiftOnBoard.setSelectedEmployees(new ArrayList<EmployeeMetadata>());
			shiftOnBoard.setShiftKey(configurationToShiftKeyTransformer.apply(shiftConfiguration));
			shiftOnBoard.setRemainCapacity(shiftConfiguration.getCapacity());
			shiftOnBoardMap.put(shiftConfiguration.getShiftKey(), shiftOnBoard);
		}
		return shiftOnBoardMap;
	}

	public ShiftConfigurationToShiftKeyTransformer getConfigurationToShiftKeyTransformer() {
		return configurationToShiftKeyTransformer;
	}

	public void setConfigurationToShiftKeyTransformer(
			ShiftConfigurationToShiftKeyTransformer configurationToShiftKeyTransformer) {
		this.configurationToShiftKeyTransformer = configurationToShiftKeyTransformer;
	}

}
