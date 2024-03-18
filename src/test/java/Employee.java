import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private double salary;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}


	
	public Employee(String firstName,String lastName,int age,double salary) {
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.salary=salary;
	}
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		
		WebElement table=driver.findElement(By.id("id"));
		
		List<WebElement> rows=table.findElements(By.xpath("//div[@role='row']"));
		
		List<Employee> employees=new ArrayList<>();
		
		for(WebElement row:rows) {
			List<WebElement> coloums=row.findElements(By.xpath("path"));
			String firstName=coloums.get(0).getText();
			String lastName=coloums.get(1).getText();
			
			int age=Integer.parseInt(coloums.get(2).getText());
			double salary=Double.parseDouble(coloums.get(3).getText().replace("$", "").replace(",", " "));
			Employee employee=new Employee(firstName,lastName,age,salary);
			employees.add(employee);
		
		}
		System.out.println("Employee with age <30:");
		for(Employee employee:employees){
			if(employee.getAge()<30) {
				System.out.println(employee.getFirstName()+" ");
			}
		}

	}

}










