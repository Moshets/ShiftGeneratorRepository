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
public class ShiftConfigurationValidateFunction implements
		Function<ShiftConfiguration, ShiftConfigurationValidationResultEnum> {

	private SimpleDateFormat dateFormat;
	
	
	@Override
	public ShiftConfigurationValidationResultEnum apply(ShiftConfiguration shiftConfiguration) {
		try {
			Date startDate = dateFormat.parse(shiftConfiguration.getStartDate());
			Date endDate = dateFormat.parse(shiftConfiguration.getEndDate());
			Long duration = (endDate.getTime() -  startDate.getTime());
			if(duration < 0 ){
				return ShiftConfigurationValidationResultEnum.END_DATE_BEFORE_START_DATE;
			}
		} catch (ParseException e) {
			return ShiftConfigurationValidationResultEnum.PARSING_FAIL;
		}
		return ShiftConfigurationValidationResultEnum.PASS;
	}


	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

}
