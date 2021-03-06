package il.co.shiftsgenerator.engine.model;

import java.util.List;

public class Shift {

	private ShiftConfiguration shiftConfiguration;
	private String shiftKey;
	private Preference preference;
	private boolean assign;
	private int remainCapacity;
	private List<EmployeeMetadata> selectedEmployees;
	private List<EmployeeMetadata> availableEmployees;
	

	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	public boolean isAssign() {
		return assign;
	}
	public void setAssign(boolean assign) {
		this.assign = assign;
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
	public List<EmployeeMetadata> getAvailableEmployees() {
		return availableEmployees;
	}
	public void setAvailableEmployees(List<EmployeeMetadata> availableEmployees) {
		this.availableEmployees = availableEmployees;
	}
	@Override
	public String toString() {
		return "Shift [shiftConfiguration=" + shiftConfiguration
				+ ", shiftKey=" + shiftKey + ", preference=" + preference
				+ ", assign=" + assign + ", remainCapacity=" + remainCapacity
				+ ", selectedEmployees=" + selectedEmployees + "]";
	}
}
