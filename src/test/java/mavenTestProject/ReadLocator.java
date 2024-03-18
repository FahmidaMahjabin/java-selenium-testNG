package mavenTestProject;

import java.io.FileInputStream;
import java.util.Properties;
public class ReadLocator {

	private Properties pro;
	public ReadLocator(String filename)
	{
		String filepath=".//resources//locators//"+filename+".properties";
		try {
		FileInputStream instream = new FileInputStream(filepath);
		 pro=new Properties();
		pro.load(instream);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public String getLocator(String locatorname)
	{
		return pro.getProperty(locatorname);
	}
	
	
}
