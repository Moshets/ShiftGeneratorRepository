package il.co.shiftsgenerator.engine.services.validation;

import il.co.shiftsgenerator.engine.model.ShiftConfiguration;

import java.util.Map;

import com.google.common.base.Predicate;

public class ShiftKeyExistsInShiftConfiguration implements Predicate<String>{

	private Map<String, ShiftConfiguration> shiftConfigurationMap;
	
	
	public ShiftKeyExistsInShiftConfiguration(Map<String, ShiftConfiguration> shiftConfigurationMap) {

		this.shiftConfigurationMap = shiftConfigurationMap;
	}


	@Override
	public boolean apply(String shiftKey) {
		
		return shiftConfigurationMap.containsKey(shiftKey);
	}

}
