package selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeDynamo_Login {

	
	@Test
	public  void testt() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		//WebDriverManager.chromedriver().setup();			
		ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
options.addArguments("start-maximized"); // open Browser in maximized mode
options.addArguments("disable-infobars"); // disabling infobars
options.addArguments("--disable-extensions"); // disabling extensions
options.addArguments("--disable-gpu"); // applicable to windows os only
options.addArguments("--no-sandbox"); // Bypass OS security model
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://tvishasystems.com/webdemo/timedynamo_testing/public/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("bG9naW5Vc2VybmFtZUVsZW1lbnQ")).sendKeys("admin@tvisha.com");
		driver.findElement(By.id("bG9naW5QYXNzd29yZEVsZW1lbnQ")).sendKeys("Admin@1201@");
		driver.findElement(By.id("bG9naW5CdG4")).click();
		
	}
}
