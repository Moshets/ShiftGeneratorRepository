package il.co.shiftsgenerator.engine.services.validation;

public class ShiftValidationResultHolder {

	private ShiftValidationResultEnum shiftValidationResultEnum;

	public ShiftValidationResultHolder(
			ShiftValidationResultEnum shiftValidationResultEnum) {
		super();
		this.shiftValidationResultEnum = shiftValidationResultEnum;
	}

	public ShiftValidationResultEnum getShiftValidationResultEnum() {
		return shiftValidationResultEnum;
	}

	public void setShiftValidationResultEnum(
			ShiftValidationResultEnum shiftValidationResultEnum) {
		this.shiftValidationResultEnum = shiftValidationResultEnum;
	}
	
	
}
