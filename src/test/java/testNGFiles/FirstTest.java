package testNGFiles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;

public class FirstTest {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
//	@Test(priority=1, groups = {"sanity"})
  void openApp(String browserName) {
		if (browserName.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge")){
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	  System.out.println("Open application");
  }
	@Test(priority = 2,groups = {"regression"},  dataProvider = "login")
  void login(String username,String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	  System.out.println("Login");
  }
	@AfterClass
//	@Test(priority = 3, groups = {"sanity"}, dependsOnMethods = {"openApp"})
  void close() {
	String expectedText = 	driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	String ActualText = "Dashboard";
	if(ActualText.equals(expectedText)) {
		System.out.println("Got passed");
	}
	  System.out.println("close application");
	  driver.quit();
  }
	
	@DataProvider(name = "login")
	String[][] loginData(){
		 String [][] data = {
				 {"Admin", "admin123"}, 
				 {"Admin", "abcd"}, 
				 {"asad", "admin123"}
				 
		 };
		return data;
		
	}
	
}
