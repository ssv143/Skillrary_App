package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable  methods to read data from properties file 
 * @author VIKAS ABHILASH
 *
 */
public class PropertiesUtility {
	private Properties property;
/**
 * this method is used to initialize properties file
 * @param filepath
 */
	public void propertiesIntilization(String filepath) {

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filepath);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		property = new Properties();

		try {
			property.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	/**
	 * This method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	
	
	public String readFromProperties(String key)
	{
		return property.getProperty(key) ;
	}

}

// here we created 2 saperated methos for propertie to avoid multiple object creation . with the help of above code we call the method in befor class an
//
