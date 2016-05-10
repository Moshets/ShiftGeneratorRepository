package il.co.shiftsgenerator.engine.model;

import java.util.List;

public class ShiftEngineInput {

	private List<ShiftConfiguration> shiftConfigurations;
	private List<Employee> employees;
	
	public List<ShiftConfiguration> getShiftConfigurations() {
		return shiftConfigurations;
	}
	public void setShiftConfigurations(List<ShiftConfiguration> shiftConfigurations) {
		this.shiftConfigurations = shiftConfigurations;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
