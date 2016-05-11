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

	
	private String nullMassegeTamplate;
	private String shiftKeyDoseNotExsitTamplate;
	private Function<ShiftConfiguration, String> shiftConfigurationToShiftKeyTransformer;
	
	@Override
	public boolean apply(ShiftEngineInput shiftEngineInput) {
		List<ShiftConfiguration> shiftConfigurations = shiftEngineInput.getShiftConfigurations();
		ImmutableMap<String, ShiftConfiguration> shiftConfigurationMap = Maps.uniqueIndex(shiftConfigurations,shiftConfigurationToShiftKeyTransformer);
		List<Employee> employees = shiftEngineInput.getEmployees();
		
		for (Employee employee : employees) {
			List<Shift> shifts = employee.getShifts();
			for (Shift shift : shifts) {
				checkNotNull(shift.getShiftKey(), nullMassegeTamplate, employee,shift);
				checkArgument(shiftConfigurationMap.containsKey(shift.getShiftKey()), shiftKeyDoseNotExsitTamplate, shift.getShiftKey(),employee);
			}
			
		}
		return true;
	}

	public String getNullMassegeTamplate() {
		return nullMassegeTamplate;
	}

	public void setNullMassegeTamplate(String nullMassegetamplate) {
		this.nullMassegeTamplate = nullMassegetamplate;
	}

	public String getShiftKeyDoseNotExsitTamplate() {
		return shiftKeyDoseNotExsitTamplate;
	}

	public void setShiftKeyDoseNotExsitTamplate(String shiftKeyDoseNotExsitTamplate) {
		this.shiftKeyDoseNotExsitTamplate = shiftKeyDoseNotExsitTamplate;
	}

	public Function<ShiftConfiguration, String> getShiftConfigurationToShiftKeyTransformer() {
		return shiftConfigurationToShiftKeyTransformer;
	}

	public void setShiftConfigurationToShiftKeyTransformer(
			Function<ShiftConfiguration, String> shiftConfigurationToShiftKeyTransformer) {
		this.shiftConfigurationToShiftKeyTransformer = shiftConfigurationToShiftKeyTransformer;
	}

}
