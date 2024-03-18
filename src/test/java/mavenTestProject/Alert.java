package mavenTestProject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		org.openqa.selenium.Alert myAlert = driver.switchTo().alert();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		org.openqa.selenium.Alert myAlert =  myWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(myAlert.getText());
		myAlert.sendKeys("Hey eva");
		myAlert.accept();

	}

}
