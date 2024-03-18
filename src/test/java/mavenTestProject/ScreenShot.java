package mavenTestProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class ScreenShot {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
//		TakesScreenshot screenShot = driver;
//		File src =  screenShot.getScreenshotAs(OutputType.FILE);
		File src = driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']")).getScreenshotAs(OutputType.FILE);
		File target  = new File("C:\\Users\\mehja\\eclipse-workspace\\mavenTestProject\\screenShots\\products.png");
		FileUtils.copyFile(src, target);

	}

}
