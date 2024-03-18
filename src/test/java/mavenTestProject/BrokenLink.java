package mavenTestProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		int brokenLink = 0;
		for(WebElement link:links) {
//			System.out.println( );
			String hrefAtrbt = link.getAttribute("href");
			if(hrefAtrbt == null || hrefAtrbt.isEmpty()) {
				System.out.println("no href");
				continue;
				
			}
			
//			href is string format change it to url
			@SuppressWarnings("deprecation")
			URL linkUrl = new URL(hrefAtrbt);
//			System.out.println(linkUrl);
			HttpURLConnection connection =  (HttpURLConnection) linkUrl.openConnection(); //send request, open 
			connection.connect();
			if(connection.getResponseCode() >= 400) {
				brokenLink++;
				System.out.println(hrefAtrbt);
			}
		}
		System.out.println(brokenLink);

	}

}
