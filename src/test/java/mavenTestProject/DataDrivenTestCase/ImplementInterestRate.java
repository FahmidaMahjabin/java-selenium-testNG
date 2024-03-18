package mavenTestProject.DataDrivenTestCase;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ImplementInterestRate {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		String filePath = System.getProperty("user.dir")+"//testData//caldata2.xlsx";
		int row = ExcelUtils.countRows(filePath); 
		int col = ExcelUtils.countCells(filePath);
//		all elements 
		WebElement depositeElement = driver.findElement(By.id("mat-input-0"));
		WebElement monthElement = driver.findElement(By.id("mat-input-1"));
		WebElement rateElement = driver.findElement(By.id("mat-input-2"));
		WebElement compoundingElement = driver.findElement(By.id("mat-select-0"));
		Select compoundSelect = new Select(compoundingElement);
	
		WebElement button = driver.findElement(By.id("CIT-chart-submit"));
		WebElement resultElement = driver.findElement(By.id("displayTotalValue"));
		
		for(int r = 1; r<=row; r++) {
			
			String initialDept = ExcelUtils.getCellData(filePath, r, 0) ;
			String interestRate = ExcelUtils.getCellData(filePath, r, 1) ;
			String months =ExcelUtils.getCellData(filePath, r, 2) ;
			String compounding = ExcelUtils.getCellData(filePath, r, 3) ;
			String total = ExcelUtils.getCellData(filePath, r, 4) ;
			String expected = ExcelUtils.getCellData(filePath, r, 5) ;
			
			depositeElement.clear();
			depositeElement.sendKeys(initialDept);
			monthElement.clear();
			monthElement.sendKeys(months);
			rateElement.clear();
			rateElement.sendKeys(interestRate);
			compoundSelect.selectByVisibleText(compounding);
			button.click();
			String result =  resultElement.getText();
			ExcelUtils.setCellData(filePath, r, 6, result);
			
			
			
			
		}

	}

}
