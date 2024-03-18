package mavenTestProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		List<WebElement> searchedItems =  driver.findElements(By.xpath("//ul[@class='G43f7e']//div[@class='wM6W7d']//span"));
		for(WebElement item: searchedItems) {
			System.out.println(item.getText());
		}
	}

}
