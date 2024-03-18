package mavenTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Brower {

	protected static WebDriver driver;
	
	protected static void launchBrowser(String browsername)
	{
		if(browsername.equals("chrome"))
			driver = new ChromeDriver();
		else
			driver= new EdgeDriver();
	}
	
	protected static void openURL()
	{
		driver.get("https://www.saucedemo.com/");
	}
	protected static void openURL(String url)
	{
		driver.get(url);
	}
	
	protected static void closeBrowser()
	{
		driver.close();
	}
	
	protected static String getCurrentPageURL()
	{
		return driver.getCurrentUrl();
	}
	
}
