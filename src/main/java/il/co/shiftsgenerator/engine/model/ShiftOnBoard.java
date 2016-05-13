package il.co.shiftsgenerator.engine.model;

import java.util.List;

public class ShiftOnBoard {

	private ShiftConfiguration shiftConfiguration;
	private String shiftKey;
	private int remainCapacity;
	private List<EmployeeMetadata> selectedEmployees;
	private List<EmployeeMetadata> availableEmployees;
	
	public ShiftConfiguration getShiftConfiguration() {
		return shiftConfiguration;
	}
	public void setShiftConfiguration(ShiftConfiguration shiftConfiguration) {
		this.shiftConfiguration = shiftConfiguration;
	}
	public String getShiftKey() {
		return shiftKey;
	}
	public void setShiftKey(String shiftKey) {
		this.shiftKey = shiftKey;
	}
	public int getRemainCapacity() {
		return remainCapacity;
	}
	public void setRemainCapacity(int remainCapacity) {
		this.remainCapacity = remainCapacity;
	}
	public List<EmployeeMetadata> getSelectedEmployees() {
		return selectedEmployees;
	}
	public void setSelectedEmployees(List<EmployeeMetadata> selectedEmployees) {
		this.selectedEmployees = selectedEmployees;
	}
	public List<EmployeeMetadata> getAvailableEmployees() {
		return availableEmployees;
	}
	public void setAvailableEmployees(List<EmployeeMetadata> availableEmployees) {
		this.availableEmployees = availableEmployees;
	}
}
