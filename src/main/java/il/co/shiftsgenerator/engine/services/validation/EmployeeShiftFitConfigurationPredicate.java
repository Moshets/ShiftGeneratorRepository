package il.co.shiftsgenerator.engine.services.validation;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import il.co.shiftsgenerator.engine.model.Employee;
import il.co.shiftsgenerator.engine.model.Shift;
import il.co.shiftsgenerator.engine.model.ShiftConfiguration;
import il.co.shiftsgenerator.engine.model.ShiftEngineInput;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class EmployeeShiftFitConfigurationPredicate implements Predicate<ShiftEngineInput> {

	
	private String shiftKeyIsNullMessageTemplate;
	private String shiftKeyDoseNotExistMessageTemplate;
	private String employeeRegisteredToUnauthorizedShiftMessageTemplate;
	private Function<ShiftConfiguration, String> shiftConfigurationToShiftKeyTransformer;
	
	@Override
	public boolean apply(ShiftEngineInput shiftEngineInput) {
		List<ShiftConfiguration> shiftConfigurations = shiftEngineInput.getShiftConfigurations();
		ImmutableMap<String, ShiftConfiguration> shiftConfigurationMap = Maps.uniqueIndex(shiftConfigurations,shiftConfigurationToShiftKeyTransformer);
		List<Employee> employees = shiftEngineInput.getEmployees();
		
		for (Employee employee : employees) {
			List<Shift> shifts = employee.getShifts();
			for (Shift shift : shifts) {
				checkNotNull(shift.getShiftKey(), shiftKeyIsNullMessageTemplate, employee,shift);
				checkArgument(shiftConfigurationMap.containsKey(shift.getShiftKey()), shiftKeyDoseNotExistMessageTemplate, shift.getShiftKey(),employee);
				checkArgument(isShiftRegistrationAuthorized(shiftConfigurationMap, employee, shift),employeeRegisteredToUnauthorizedShiftMessageTemplate,shift.getShiftKey(),employee);
			}
			
		}
		return true;
	}



	private boolean isShiftRegistrationAuthorized(
			ImmutableMap<String, ShiftConfiguration> shiftConfigurationMap,
			Employee employee, Shift shift) {
		String employeeRoleName = employee.getEmployeeMetadata().getRole().getRoleName();
		String shiftRole = shiftConfigurationMap.get(shift.getShiftKey()).getShiftRole();
		boolean shiftRoleEqualsEmployeeRole = shiftRole.equals(employeeRoleName);
		return shiftRoleEqualsEmployeeRole;
	}

	public String getShiftKeyIsNullMessageTemplate() {
		return shiftKeyIsNullMessageTemplate;
	}



	public void setShiftKeyIsNullMessageTemplate(
			String shiftKeyIsNullMessageTemplate) {
		this.shiftKeyIsNullMessageTemplate = shiftKeyIsNullMessageTemplate;
	}



	public String getShiftKeyDoseNotExistMessageTemplate() {
		return shiftKeyDoseNotExistMessageTemplate;
	}



	public void setShiftKeyDoseNotExistMessageTemplate(
			String shiftKeyDoseNotExistMessageTemplate) {
		this.shiftKeyDoseNotExistMessageTemplate = shiftKeyDoseNotExistMessageTemplate;
	}



	public Function<ShiftConfiguration, String> getShiftConfigurationToShiftKeyTransformer() {
		return shiftConfigurationToShiftKeyTransformer;
	}

	public void setShiftConfigurationToShiftKeyTransformer(
			Function<ShiftConfiguration, String> shiftConfigurationToShiftKeyTransformer) {
		this.shiftConfigurationToShiftKeyTransformer = shiftConfigurationToShiftKeyTransformer;
	}



	public String getEmployeeRegisteredToUnauthorizedShiftMessageTemplate() {
		return employeeRegisteredToUnauthorizedShiftMessageTemplate;
	}



	public void setEmployeeRegisteredToUnauthorizedShiftMessageTemplate(
			String employeeRegisteredToUnauthorizedShiftMessageTemplate) {
		this.employeeRegisteredToUnauthorizedShiftMessageTemplate = employeeRegisteredToUnauthorizedShiftMessageTemplate;
	}




}
