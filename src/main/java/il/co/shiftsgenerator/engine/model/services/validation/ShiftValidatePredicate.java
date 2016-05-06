package il.co.shiftsgenerator.engine.model.services.validation;

import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.common.base.Predicate;

public class ShiftValidatePredicate implements Predicate<ShiftConfiguration> {

	private SimpleDateFormat dateFormat;

	
	public boolean apply(ShiftConfiguration shiftConfiguration) {
		try {
			dateFormat.parse(shiftConfiguration.getStartDate());
			dateFormat.parse(shiftConfiguration.getEndDate());
		} catch (ParseException e) {
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

}
