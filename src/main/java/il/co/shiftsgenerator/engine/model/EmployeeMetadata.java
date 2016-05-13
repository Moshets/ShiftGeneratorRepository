package il.co.shiftsgenerator.engine.model;

public class EmployeeMetadata {

	private String name;
	private Role role;
	private EmployeeCharacteristics employeeCharacteristics;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public EmployeeCharacteristics getEmployeeCharacteristics() {
		return employeeCharacteristics;
	}
	public void setEmployeeCharacteristics(EmployeeCharacteristics employeeCharacteristics) {
		this.employeeCharacteristics = employeeCharacteristics;
	}
	@Override
	public String toString() {
		return "EmployeeMetadata [name=" + name + ", role=" + role + "]";
	}

	
}