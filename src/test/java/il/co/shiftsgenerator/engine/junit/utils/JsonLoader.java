package il.co.shiftsgenerator.engine.junit.utils;

import java.io.InputStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * Class to load and convert object from  JSON string
 * @author MOSHETS
 *
 */
public class JsonLoader {

	private JunitFileLoaderHelper fileLoaderHelper;
	private ObjectMapper mapper;
	
	public JsonLoader() {
		super();
		fileLoaderHelper = new JunitFileLoaderHelper();
		mapper =  new ObjectMapper();
	}
	

	/**
	 * Load object form JSON string.
	 * The file will be load to cache
	 * Use this method if your JSON contains list or map of object 
	 * @param jsonFile
	 * @param type
	 * @return T 
	 * @throws Exception
	 */
	public <T> T getObject(String jsonFile,TypeReference<T> type) throws Exception{
		InputStream stream =  fileLoaderHelper.getFileAsStream(jsonFile);
		return mapper.readValue(stream, type);
	}
	
	/**
	 * Load object form JSON string.
	 * The file will be load to cache.
	 * Use this method if your JSON contains only 1 object
	 * @param jsonFile
	 * @param cls
	 * @return T 
	 * @throws Exception
	 */
	protected <T> T getObject(String jsonFile,Class<T> cls) throws Exception{
		InputStream stream =  fileLoaderHelper.getFileAsStream(jsonFile);
		return mapper.readValue(stream, cls);
	}


	public JunitFileLoaderHelper getFileLoaderHelper() {
		return fileLoaderHelper;
	}



	public void setFileLoaderHelper(JunitFileLoaderHelper fileLoaderHelper) {
		this.fileLoaderHelper = fileLoaderHelper;
	}


	public ObjectMapper getMapper() {
		return mapper;
	}


	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
}
