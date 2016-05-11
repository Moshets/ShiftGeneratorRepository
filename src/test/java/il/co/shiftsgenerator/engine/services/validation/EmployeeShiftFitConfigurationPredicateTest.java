package il.co.shiftsgenerator.engine.services.validation;

import static org.junit.Assert.*;
import il.co.shiftsgenerator.engine.junit.utils.BaseTest;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import org.codehaus.jackson.type.TypeReference;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmployeeShiftFitConfigurationPredicateTest extends BaseTest{
	
	private final String SHIFT_ENGINE_INPUT_SHIFT_KEY_NOT_EXISTS = RESOURCE_FOLDER+"/model/shiftEngineInputShiftKeyNotExistsInConfiguration.json";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test(expected=IllegalArgumentException.class)
	public void test() throws Exception {

			ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT_SHIFT_KEY_NOT_EXISTS, new TypeReference<ShiftEngineInput>() {});
			
			EmployeeShiftFitConfigurationPredicate employeeShiftFitConfigurationPredicate = context.getBean(EmployeeShiftFitConfigurationPredicate.class);

			employeeShiftFitConfigurationPredicate.apply(shiftEngineInput);
		
	}

}
