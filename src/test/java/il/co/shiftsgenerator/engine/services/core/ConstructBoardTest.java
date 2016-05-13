package il.co.shiftsgenerator.engine.services.core;

import il.co.shiftsgenerator.engine.junit.utils.BaseTest;
import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ConstructBoardTest extends BaseTest{

	private final String SHIFT_ENGINE_INPUT = RESOURCE_FOLDER+"services/core/shiftEngineInputConstuctBoard.json";

	@Test
	public void testBoardCreatedSuccessfully() throws Exception {
		ConstructBoard constructBoard = context.getBean(ConstructBoard.class);
		ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT, new TypeReference<ShiftEngineInput>() {});
		Board board = constructBoard.apply(shiftEngineInput);
		assertThat(board.getShiftsOnBoardMap().size(), is(3));
		assertThat(board.getShiftEngineInput(), notNullValue());
		assertThat(board.getShiftsOnBoardMap().get("1").getAvailableEmployees(), notNullValue());
		assertThat(board.getShiftsOnBoardMap().get("1").getSelectedEmployees(), notNullValue());
		assertThat(board.getShiftsOnBoardMap().get("1").getRemainCapacity(), is(shiftEngineInput.getShiftConfigurations().get(0).getCapacity()));
		
	}

}
