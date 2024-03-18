package mavenTestProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		WebElement dropdownLocator = driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
		dropdownLocator.click();
		
		List<WebElement> allSelector = driver.findElements(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//label"));
		
		for(WebElement selector: allSelector) {
			System.out.println(selector.getText());
			if(selector.getText().equals("Java")) {
				selector.click();
			}
			
		}

	}

}
