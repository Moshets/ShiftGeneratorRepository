package il.co.shiftsgenerator.engine.model;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JunitFileLoaderHelper {

	private Map<String , byte[]> filesContantCacheMap;
	
	public JunitFileLoaderHelper() {
		this.filesContantCacheMap =  new HashMap<String, byte[]>();
	}

	/**
	 * Loads the file into input stream file - lazy method
	 * The file will be save to cache
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public InputStream getFileAsStream(String fileName) throws IOException{
		if(!filesContantCacheMap.containsKey(fileName)){
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream  = classloader.getResourceAsStream(fileName);
			filesContantCacheMap.put(fileName, saveInputStreamToByteArray(inputStream));
		}
		
		return getInputStreamFromCache(fileName); 
	}
	
	private  byte[] saveInputStreamToByteArray(InputStream inputStream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while ((n = inputStream.read(buf)) >= 0){
			 baos.write(buf, 0, n);
		}	   
		return baos.toByteArray();
	}
	
	public InputStream getInputStreamFromCache(String fileName){
		InputStream inputStream = new ByteArrayInputStream(filesContantCacheMap.get(fileName));
		return inputStream;
	}
}
