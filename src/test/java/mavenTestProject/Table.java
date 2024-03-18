package mavenTestProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> rows =  driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int colsNumber = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		for(int r = 2; r<= rows.size(); r++) {
//			System.out.println(row.getText());
//			for(int c= 1; c<= colsNumber; c++) {
//				System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText() + "  ");
//			}
//			System.out.println("");
			
			
//			get the book name whose name is Amit 
			String Author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(Author.equals("Amit")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName);
				
			}
			
			
		}

	}

}
