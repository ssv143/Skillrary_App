package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods of java
 * @author VIKAS ABHILASH
 *
 */
public class JavaUtility {
	
	/**
	 * This method generates random number within the specified limit 
	 * @param limt
	 * @return
	 */
	public int generateRandomNum(int limt)
	{
		Random random = new Random();
		return random.nextInt(limt);
	}
	
	/**
	 * This method generates current time
	 * @return
	 */
	
	
	public String getCurrentTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yy_mm_ss");
		return sdf.format(date);
		
	}

}
