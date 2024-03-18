package mavenTestProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		WebElement bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement account = driver.findElement(By.id("bank"));
		Actions act = new Actions(driver);
		act.dragAndDrop(bank, account).perform();
		WebElement amount1 = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
		WebElement amount2 = driver.findElement(By.xpath("//a[text()=' 5000']"));
		WebElement sales = driver.findElement(By.xpath("//a[text()=' SALES ']"));
		WebElement debtAmount = driver.findElement(By.id("amt7"));
		WebElement crdtAmount = driver.findElement(By.id("amt8"));
		WebElement loan = driver.findElement(By.id("loan"));
		act.dragAndDrop(amount1, debtAmount).perform();
		act.dragAndDrop(amount2, crdtAmount).build().perform();
		act.dragAndDrop(sales, loan).build().perform();
		
		
		

	}

}
