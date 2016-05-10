package il.co.shiftsgenerator.engine.model;

import static org.junit.Assert.*;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;

import org.codehaus.jackson.type.TypeReference;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class ShiftEngineInputTest {
	
	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_ENGINE_INPUT = RESOURCE_FOLDER+"shiftEngineInput.json";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testLoadInputFromJson() throws Exception {
		ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT,new TypeReference<ShiftEngineInput>() {});
		
		assertThat(shiftEngineInput.getShiftConfigurations(), hasSize(21));
		assertThat(shiftEngineInput.getEmployees(), hasSize(10));
	}

}
