package il.co.shiftsgenerator.engine.services.validation;

import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import com.google.common.base.Function;

public class ShiftConfigurationToShiftKeyTransformer implements
		Function<ShiftConfiguration, String> {

	@Override
	public String apply(ShiftConfiguration shiftConfiguration) {
		return shiftConfiguration.getShiftKey();
	}

}
