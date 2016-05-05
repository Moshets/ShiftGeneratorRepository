package il.co.shiftsgenerator.engine.junit.utils;

import org.codehaus.jackson.annotate.JsonAutoDetect;

public class JsonLoaderNonAutoDetection extends JsonLoader {

	public JsonLoaderNonAutoDetection() {
		super();
		getMapper().setVisibilityChecker(getMapper().getDeserializationConfig().getDefaultVisibilityChecker()
		        .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
		        .withFieldVisibility(JsonAutoDetect.Visibility.NONE)
		        .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
		        .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
		        .withSetterVisibility(JsonAutoDetect.Visibility.NONE));
	}

}
