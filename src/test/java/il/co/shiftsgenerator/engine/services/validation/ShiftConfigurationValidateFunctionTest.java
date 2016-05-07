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

public class ShiftConfigurationValidateFunctionTest {

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
		
		ShiftConfigurationValidateFunction shiftValidateFunctionBean = context.getBean(ShiftConfigurationValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(0);
		ShiftConfigurationValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftConfigurationValidationResultEnum.PASS));
	}

	@Test
	public void testValidationParsingFaliOnStartDate() throws Exception {
		ShiftConfigurationValidateFunction shiftValidateFunctionBean = context.getBean(ShiftConfigurationValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(1);
		ShiftConfigurationValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftConfigurationValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDate() throws Exception {
		ShiftConfigurationValidateFunction shiftValidateFunctionBean = context.getBean(ShiftConfigurationValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(2);
		ShiftConfigurationValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftConfigurationValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDateAndStartDate() throws Exception {
		ShiftConfigurationValidateFunction shiftValidateFunctionBean = context.getBean(ShiftConfigurationValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(3);
		ShiftConfigurationValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftConfigurationValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testEndDateStartDate() throws Exception {
		ShiftConfigurationValidateFunction shiftValidateFunctionBean = context.getBean(ShiftConfigurationValidateFunction.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration = shiftsConfig.get(4);
		ShiftConfigurationValidationResultEnum validationResult = shiftValidateFunctionBean.apply(shiftConfiguration);

		assertThat(validationResult, is(ShiftConfigurationValidationResultEnum.END_DATE_BEFORE_START_DATE));
	}
	
}
