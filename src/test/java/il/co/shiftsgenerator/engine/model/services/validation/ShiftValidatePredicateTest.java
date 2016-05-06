package il.co.shiftsgenerator.engine.model.services.validation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;
import il.co.shiftsgenerator.engine.services.validation.ShiftValidatePredicate;
import il.co.shiftsgenerator.engine.services.validation.ShiftValidationResultEnum;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.collect.Iterables;

public class ShiftValidatePredicateTest {

	private static ApplicationContext context;
	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/services/validation/";
	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"shiftCofigInputListToValidate.json";
	
	@BeforeClass
	public static void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void testValidationPass() throws Exception {
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration1 = shiftsConfig.get(0);
		boolean shiftConfiguration4Valid = shiftValidatePredicate.apply(shiftConfiguration1);		

		assertThat(shiftConfiguration4Valid,is(true));
		assertThat(shiftValidatePredicate.getShiftValidationResultHolder().getShiftValidationResultEnum(), is(ShiftValidationResultEnum.PASS));
	}

	@Test
	public void testValidationParsingFaliOnStartDate() throws Exception {
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration1 = shiftsConfig.get(1);
		boolean shiftConfiguration1Valid = shiftValidatePredicate.apply(shiftConfiguration1);		

		assertThat(shiftConfiguration1Valid,is(false));
		assertThat(shiftValidatePredicate.getShiftValidationResultHolder().getShiftValidationResultEnum(), is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDate() throws Exception {
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration1 = shiftsConfig.get(2);
		boolean shiftConfiguration2Valid = shiftValidatePredicate.apply(shiftConfiguration1);		

		assertThat(shiftConfiguration2Valid,is(false));
		assertThat(shiftValidatePredicate.getShiftValidationResultHolder().getShiftValidationResultEnum(), is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testValidationParsingFaliOnEndDateAndStartDate() throws Exception {
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration4 = shiftsConfig.get(3);
		boolean shiftConfiguration4Valid = shiftValidatePredicate.apply(shiftConfiguration4);		

		assertThat(shiftConfiguration4Valid,is(false));
		assertThat(shiftValidatePredicate.getShiftValidationResultHolder().getShiftValidationResultEnum(), is(ShiftValidationResultEnum.PARSING_FAIL));
	}
	@Test
	public void testEndDateStartDate() throws Exception {
		//Iterables.all(iterable, predicate)
		
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		

		ShiftConfiguration shiftConfiguration5 = shiftsConfig.get(4);
		boolean shiftConfiguration4Valid = shiftValidatePredicate.apply(shiftConfiguration5);		

		assertThat(shiftConfiguration4Valid,is(false));
		assertThat(shiftValidatePredicate.getShiftValidationResultHolder().getShiftValidationResultEnum(), is(ShiftValidationResultEnum.END_DATE_BEFORE_START_DATE));
	}
	

}
