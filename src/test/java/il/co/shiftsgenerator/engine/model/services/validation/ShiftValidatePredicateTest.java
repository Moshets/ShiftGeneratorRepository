package il.co.shiftsgenerator.engine.model.services.validation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShiftValidatePredicateTest {

	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_JSON_FILE = RESOURCE_FOLDER+"shiftCofigInputListToValidate.json";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShiftValidatePredicate shiftValidatePredicate = context.getBean(ShiftValidatePredicate.class);
		List<ShiftConfiguration> shiftsConfig = jsonLoader.getObject(SHIFT_JSON_FILE, new TypeReference<List<ShiftConfiguration>>() {});
		
		ShiftConfiguration shiftConfiguration1 = shiftsConfig.get(0);
		ShiftConfiguration shiftConfiguration2 = shiftsConfig.get(1);
		ShiftConfiguration shiftConfiguration3 = shiftsConfig.get(2);
		ShiftConfiguration shiftConfiguration4 = shiftsConfig.get(3);
		boolean shiftConfiguration1Valid = shiftValidatePredicate.apply(shiftConfiguration1);
		boolean shiftConfiguration2Valid = shiftValidatePredicate.apply(shiftConfiguration2);
		boolean shiftConfiguration3Valid = shiftValidatePredicate.apply(shiftConfiguration3);
		boolean shiftConfiguration4Valid = shiftValidatePredicate.apply(shiftConfiguration4);
		
		assertThat(shiftConfiguration1Valid,is(true));
		assertThat(shiftConfiguration2Valid,is(false));
		assertThat(shiftConfiguration3Valid,is(false));
		assertThat(shiftConfiguration4Valid,is(false));
	}

}
