package il.co.shiftsgenerator.engine.services.validation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;
import il.co.shiftsgenerator.engine.model.Shift;

import org.codehaus.jackson.type.TypeReference;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShiftValidateFunctionTest {

	private static ApplicationContext context;
	private JsonLoader jsonLoader = new JsonLoader();
	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/services/validation/";
	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"shiftValidatePass.json";
	private final String SHIFT_JSON_FILE_FAIL = RESOURCE_FOLDER+"shiftValidateFail1.json";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void testShiftConfigHasTheSameShiftKey() throws Exception {
		Shift shiftToValidate = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<Shift>() {});
		
		
		assertThat(shiftToValidate.getShiftKey(),equalTo(shiftToValidate.getShiftConfiguration().getShiftKey()));
		
	}
	
	@Test
	public void testShiftConfigHasTheDiffrentShiftKey() throws Exception {
		Shift shiftToValidate = jsonLoader.getObject(SHIFT_JSON_FILE_FAIL, new TypeReference<Shift>() {});
		
		
		assertThat(shiftToValidate.getShiftKey(),not(equalTo(shiftToValidate.getShiftConfiguration().getShiftKey())));
		
	}

}
