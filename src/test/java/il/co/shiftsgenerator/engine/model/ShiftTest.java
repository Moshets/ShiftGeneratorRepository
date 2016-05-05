package il.co.shiftsgenerator.engine.model;

import static org.junit.Assert.*;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShiftTest {


	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"shift.json";

	@Test
	public void testShiftModel() throws Exception {
		Shift shift = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<Shift>() {});

		assertThat(shift.getShiftKey(), equalTo("01/06/2014 08:00 Sun"));
		assertThat(shift.getPreference(), equalTo(Preference.BLOCKED));
		assertThat(shift.isAssign(), is(true));
	}

}
