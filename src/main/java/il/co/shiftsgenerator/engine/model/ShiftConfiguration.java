package il.co.shiftsgenerator.engine.model;

import java.text.ParseException;

public class ShiftConfiguration {

	private String shiftKey;
	private int capacity;
	private String shiftType;
	private String startDate;
	private String endDate;
	private String shiftRole;
	
	
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
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}
	public String getShiftRole() {
		return shiftRole;
	}
	
	@Override
	public String toString() {
		return "ShiftConfiguration [shiftKey=" + shiftKey + ", capacity="
				+ capacity + ", shiftType=" + shiftType + ", startDate="
				+ startDate + ", endDate=" + endDate + ", shiftRole="
				+ shiftRole + "]";
	}
	public void setShiftRole(String shiftRole) {
		this.shiftRole = shiftRole;
	}
	
}
