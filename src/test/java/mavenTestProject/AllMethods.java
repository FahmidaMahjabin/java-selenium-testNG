package mavenTestProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllMethods {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
//		make a explicit wait 
		WebDriverWait myWait =new WebDriverWait(driver,Duration.ofSeconds(10));
//		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='OrangeHRM, Inc']"))).click();
		String currentTab = driver.getWindowHandle();
		Set<String> allTabs = driver.getWindowHandles();
		for(String tab: allTabs) {
			System.out.println(tab);
			if(!currentTab.equals(tab)) {
				System.out.println(tab);
			}
		}
//		driver.close();

	}

}
