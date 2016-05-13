package il.co.shiftsgenerator.engine.services.core;

import il.co.shiftsgenerator.engine.junit.utils.BaseTest;
import il.co.shiftsgenerator.engine.model.Board;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class ConstructBoardTest extends BaseTest{

	private final String SHIFT_ENGINE_INPUT = RESOURCE_FOLDER+"services/core/shiftEngineInputConstuctBoard.json";
	//shiftEngineInputConstuctBoardSuccessfully.json

	@Test
	public void testBoardCreatedSuccessfully() throws Exception {
		ConstructBoard constructBoard = context.getBean(ConstructBoard.class);
		ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT, new TypeReference<ShiftEngineInput>() {});
		Board board = constructBoard.apply(shiftEngineInput);
	}

}
