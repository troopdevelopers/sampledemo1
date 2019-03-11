package selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeDynamo_Login {

	
	@Test
	public  void testt() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();			
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://tvishasystems.com/webdemo/timedynamo_testing/public/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("bG9naW5Vc2VybmFtZUVsZW1lbnQ")).sendKeys("admin@tvisha.com");
		driver.findElement(By.id("bG9naW5QYXNzd29yZEVsZW1lbnQ")).sendKeys("Admin@1201@");
		driver.findElement(By.id("bG9naW5CdG4")).click();
		
	}
}
