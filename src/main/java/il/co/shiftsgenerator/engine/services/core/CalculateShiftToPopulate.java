package il.co.shiftsgenerator.engine.services.core;

import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.ShiftOnBoard;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 * This class will calculate from which shift to start pick employee 
 * @author moshets
 *
 */
public class CalculateShiftToPopulate implements Function<Board, ShiftOnBoard>{

	private Function<ShiftOnBoard, Double> scoreFunction;
	@Override
	public ShiftOnBoard apply(Board board) {
		
		Map<String, ShiftOnBoard> shiftsOnBoardMap = board.getShiftsOnBoardMap();
		
		Ordering<ShiftOnBoard> byScoreFunction = new ShiftScoreOrdering();	
		
		return byScoreFunction.min(shiftsOnBoardMap.values());
	}
	public Function<ShiftOnBoard, Double> getScoreFunction() {
		return scoreFunction;
	}
	public void setScoreFunction(Function<ShiftOnBoard, Double> scoreFunction) {
		this.scoreFunction = scoreFunction;
	}
	private final class ShiftScoreOrdering extends Ordering<ShiftOnBoard> {
		@Override
		public int compare(ShiftOnBoard shift0, ShiftOnBoard shift1) {
			Double shift0Score = scoreFunction.apply(shift0);
			Double shift1Score = scoreFunction.apply(shift1);
			return Double.compare(shift0Score, shift1Score);
		}
	}

}
