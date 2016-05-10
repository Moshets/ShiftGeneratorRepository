package il.co.shiftsgenerator.engine.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

public class ShiftConfigurationTest {
	

	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_CONFIG_LIST_JSON_FILE = RESOURCE_FOLDER+"shiftCofigInputList.json";
	

	@Test
	public void testShiftConfigurationModel() throws Exception {
		
		List<ShiftConfiguration> shiftConfigurations = new ArrayList<ShiftConfiguration>();
		
		shiftConfigurations.addAll(jsonLoader.getObject(SHIFT_CONFIG_LIST_JSON_FILE, new TypeReference<List<ShiftConfiguration>>(){}));

		assertThat(shiftConfigurations, is(notNullValue()));
		assertThat(shiftConfigurations, hasSize(21));
	}

}
