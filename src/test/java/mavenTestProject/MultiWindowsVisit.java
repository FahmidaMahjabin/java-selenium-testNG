package mavenTestProject;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsVisit {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		List<WebElement> searchResults =  driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
		for(WebElement searchResult: searchResults) {
			System.out.println(searchResult.getText());
			searchResult.click();
			Thread.sleep(3000);
			
		}
		
		Set<String> allWindows =  driver.getWindowHandles();
		for(String window: allWindows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
	}

}
