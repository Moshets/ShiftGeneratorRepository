package il.co.shiftsgenerator.engine.model;

import java.text.ParseException;

public class ShiftConfiguration {

	private int capacity;
	private String shiftType;
	private String startDate;
	private String endDate;
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
		//dateFormat.parse(endDate);
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
	@Override
	public String toString() {
		return "ShiftConfiguration [capacity=" + capacity + ", shiftType="
				+ shiftType + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
}
