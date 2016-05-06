package il.co.shiftsgenerator.engine.services.validation;

import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Predicate;

public class ShiftValidatePredicate implements Predicate<ShiftConfiguration> {

	private SimpleDateFormat dateFormat;
	private ShiftValidationResultHolder shiftValidationResultHolder;


	public boolean apply(ShiftConfiguration shiftConfiguration) {
		try {
			Date startDate = dateFormat.parse(shiftConfiguration.getStartDate());
			Date endDate = dateFormat.parse(shiftConfiguration.getEndDate());
			Long duration = (endDate.getTime() -  startDate.getTime());
			if(duration < 0 ){
				shiftValidationResultHolder.setShiftValidationResultEnum(ShiftValidationResultEnum.END_DATE_BEFORE_START_DATE);
				return false;
			}
		} catch (ParseException e) {
			shiftValidationResultHolder.setShiftValidationResultEnum(ShiftValidationResultEnum.PARSING_FAIL);
			return false;
		}
		return true;
	}


	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}


	public ShiftValidationResultHolder getShiftValidationResultHolder() {
		return shiftValidationResultHolder;
	}


	public void setShiftValidationResultHolder(
			ShiftValidationResultHolder shiftValidationResultHolder) {
		this.shiftValidationResultHolder = shiftValidationResultHolder;
	}

	
}
