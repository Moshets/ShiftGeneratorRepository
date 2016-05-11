package il.co.shiftsgenerator.engine.junit.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

	protected JsonLoader jsonLoader = new JsonLoader();
	protected static ApplicationContext context;
	protected static final String RESOURCE_FOLDER = "il/co/shiftsgenerator/engine/";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	@Before
	public void setUp() throws Exception {
	}
}
