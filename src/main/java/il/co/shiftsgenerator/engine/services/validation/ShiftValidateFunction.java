/**
 * 
 */
package il.co.shiftsgenerator.engine.services.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import com.google.common.base.Function;

/**
 * @author moshets
 *
 */
public class ShiftValidateFunction implements
		Function<ShiftConfiguration, ShiftValidationResultEnum> {

	private SimpleDateFormat dateFormat;
	
	
	@Override
	public ShiftValidationResultEnum apply(ShiftConfiguration shiftConfiguration) {
		try {
			Date startDate = dateFormat.parse(shiftConfiguration.getStartDate());
			Date endDate = dateFormat.parse(shiftConfiguration.getEndDate());
			Long duration = (endDate.getTime() -  startDate.getTime());
			if(duration < 0 ){
				return ShiftValidationResultEnum.END_DATE_BEFORE_START_DATE;
			}
		} catch (ParseException e) {
			return ShiftValidationResultEnum.PARSING_FAIL;
		}
		return ShiftValidationResultEnum.PASS;
	}


	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

}
