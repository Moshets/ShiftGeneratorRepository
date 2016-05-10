package il.co.shiftsgenerator.engine.model;

import java.text.ParseException;

public class ShiftConfiguration {

	private String shiftKey;
	private int capacity;
	private String startDate;
	private String endDate;
	private String shiftRole;
	private ShiftCharacteristics shiftCharacteristics;
	
	
	public String getShiftKey() {
		return shiftKey;
	}
	public void setShiftKey(String shiftKey) {
		this.shiftKey = shiftKey;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws ParseException {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) throws ParseException {
		this.endDate = endDate;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getShiftRole() {
		return shiftRole;
	}
	public void setShiftRole(String shiftRole) {
		this.shiftRole = shiftRole;
	}
	public ShiftCharacteristics getShiftCharacteristics() {
		return shiftCharacteristics;
	}
	public void setShiftCharacteristics(ShiftCharacteristics shiftCharacteristics) {
		this.shiftCharacteristics = shiftCharacteristics;
	}
	@Override
	public String toString() {
		return "ShiftConfiguration [shiftKey=" + shiftKey + ", capacity="
				+ capacity + ", startDate=" + startDate + ", endDate="
				+ endDate + ", shiftRole=" + shiftRole + "]";
	}
	
}
