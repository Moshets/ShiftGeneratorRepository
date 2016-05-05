package il.co.shiftsgenerator.engine.model;

import static org.junit.Assert.*;
import il.co.shiftsgenerator.engine.junit.utils.JsonLoader;
import il.co.shiftsgenerator.engine.junit.utils.JunitFileLoaderHelper;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShiftConfigurationTest {
	

	private JsonLoader jsonLoader = new JsonLoader();

	private static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/model/";

	private final String SHIFT_CONFIG_LIST_JSON_FILE = RESOURCE_FOLDER+"shiftCofigInputList.json";
	

	@Test
	public void test2() throws Exception {
		
		List<ShiftConfiguration> shiftConfigurations = new ArrayList<ShiftConfiguration>();
		
		shiftConfigurations.addAll(jsonLoader.getObject(SHIFT_CONFIG_LIST_JSON_FILE, new TypeReference<List<ShiftConfiguration>>(){}));

		assertThat(shiftConfigurations, is(notNullValue()));
		
	}

}
