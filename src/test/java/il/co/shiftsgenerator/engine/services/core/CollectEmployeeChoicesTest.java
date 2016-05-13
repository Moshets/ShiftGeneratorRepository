package il.co.shiftsgenerator.engine.services.core;

import static org.junit.Assert.*;
import il.co.shiftsgenerator.engine.junit.utils.BaseTest;
import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectEmployeeChoicesTest extends BaseTest{
	
	private final String SHIFT_ENGINE_INPUT = RESOURCE_FOLDER+"services/core/collectEmployeeChoicesTest.json";

	@Test
	public void testApply() throws Exception {
		ConstructBoard constructBoard = context.getBean(ConstructBoard.class);
		ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT, new TypeReference<ShiftEngineInput>() {});
		Board board = constructBoard.apply(shiftEngineInput);
		CollectEmployeeChoices collectEmployeeChoices = context.getBean(CollectEmployeeChoices.class);
		collectEmployeeChoices.apply(board);
		assertThat(board.getShiftsOnBoardMap().get("1").getAvailableEmployees(), hasSize(2));
		assertThat(board.getShiftsOnBoardMap().get("2").getAvailableEmployees(), hasSize(1));
	}

}
