package il.co.shiftsgenerator.engine.model;

import java.util.List;


public class Employee {

	private EmployeeMetadata employeeMetadata;
	private List<Shift> shifts;
	
	public EmployeeMetadata getEmployeeMetadata() {
		return employeeMetadata;
	}
	public void setEmployeeMetadata(EmployeeMetadata employeeMetadata) {
		this.employeeMetadata = employeeMetadata;
	}
	public List<Shift> getShifts() {
		return shifts;
	}
	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}
	@Override
	public String toString() {
		return "Employee [employeeMetadata=" + employeeMetadata + "]";
	}
	
	
}
