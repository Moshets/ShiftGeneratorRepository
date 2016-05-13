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
	private final String SHIFT_ENGINE_INPUT_SHIFT_UNATHORIZED = RESOURCE_FOLDER+"/model/shiftEngineInputEmployeeResiteredToUnauthorizedShift.json";
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shiftKeyNotExistInConfigurationTest() throws Exception {

			ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT_SHIFT_KEY_NOT_EXISTS, new TypeReference<ShiftEngineInput>() {});
			
			EmployeeShiftFitConfigurationPredicate employeeShiftFitConfigurationPredicate = context.getBean(EmployeeShiftFitConfigurationPredicate.class);
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Shift Key: 3 dose not exists in configuration For employee");
			employeeShiftFitConfigurationPredicate.apply(shiftEngineInput);
		
	}
	

	@Test
	public void unauthorizedEmployeeTest() throws Exception {

			ShiftEngineInput shiftEngineInput = jsonLoader.getObject(SHIFT_ENGINE_INPUT_SHIFT_UNATHORIZED, new TypeReference<ShiftEngineInput>() {});
			
			EmployeeShiftFitConfigurationPredicate employeeShiftFitConfigurationPredicate = context.getBean(EmployeeShiftFitConfigurationPredicate.class);
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("unauthorizedEmployee");
			expectedException.expectMessage("dose not fit in shift configuration");
			employeeShiftFitConfigurationPredicate.apply(shiftEngineInput);
		
	}

}
