package il.co.shiftsgenerator.engine.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"employee.json";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Employee employee = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<Employee>(){});

		assertThat(employee.getEmployeeMetadata().getName(), is("joe"));
		assertThat(employee.getEmployeeMetadata().getRole().getRoleName(), is("employee"));
		assertThat(employee.getShifts(), hasSize(21));
		assertThat(employee.getShifts().get(2).getShiftKey(),is("01/06/2014 23:00"));
		assertThat(employee.getShifts().get(2).getPreference(),is(Preference.BLOCKED));
		assertThat(employee.getShifts().get(2).getPreference().getIndex(),is(0));
	}

}
