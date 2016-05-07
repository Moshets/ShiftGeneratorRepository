package il.co.shiftsgenerator.engine.services.validation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShiftValidateFunctionTest {

	private static ApplicationContext context;
	private JsonLoader jsonLoader = new JsonLoader();
	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/services/validation/";
	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"shiftCofigInputListToValidate.json";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void testValidationPass() throws Exception {
		
		ShiftValidateFunction shiftValidateFunctionBean = context.getBean(ShiftValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(0);
		ShiftValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftValidationResultEnum.PASS));
	}

	@Test
	public void testValidationParsingFaliOnStartDate() throws Exception {
		ShiftValidateFunction shiftValidateFunctionBean = context.getBean(ShiftValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(1);
		ShiftValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDate() throws Exception {
		ShiftValidateFunction shiftValidateFunctionBean = context.getBean(ShiftValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(2);
		ShiftValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDateAndStartDate() throws Exception {
		ShiftValidateFunction shiftValidateFunctionBean = context.getBean(ShiftValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(3);
		ShiftValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testEndDateStartDate() throws Exception {
		ShiftValidateFunction shiftValidateFunctionBean = context.getBean(ShiftValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(4);
		ShiftValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftValidationResultEnum.END_DATE_BEFORE_START_DATE));
	}
	
}
