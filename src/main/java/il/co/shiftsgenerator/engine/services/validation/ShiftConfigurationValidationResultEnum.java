package il.co.shiftsgenerator.engine.services.validation;

public enum ShiftConfigurationValidationResultEnum {

	PASS("Shift Validation pass successfully"),
	FAIL("Shift Validation fail"),
	PARSING_FAIL("Shift Parsing fail"),
	END_DATE_BEFORE_START_DATE("End date must be after start date");
	private String message;

	
	private ShiftConfigurationValidationResultEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
