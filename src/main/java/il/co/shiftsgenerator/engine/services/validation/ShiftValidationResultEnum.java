package il.co.shiftsgenerator.engine.services.validation;

public enum ShiftValidationResultEnum {

	PASS("Shift Validation pass successfully");
	
	private String message;

	
	private ShiftValidationResultEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
