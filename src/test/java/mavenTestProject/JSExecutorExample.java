package mavenTestProject;

import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class JSExecutorExample {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = driver;
		WebElement textArea = driver.findElement(By.id("inputText1"));
		js.executeScript("arguments[0].setAttribute('value', 'Welcome home')", textArea);
//		js.executeScript("return window.scrollBy(0, 500)", "");
		js.executeScript("window.scrollBy(0, document.body.scrollHeight) ");
		System.out.println(js.executeScript("return window.pageYOffset;"));

	}

}