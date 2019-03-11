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
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		//WebDriverManager.chromedriver().setup();
		
		
		chrome_options = Options()
chrome_options.add_argument('--headless')
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
driver = webdriver.Chrome('/usr/bin/chromedriver',chrome_options=chrome_options)
			
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tvishasystems.com/webdemo/timedynamo_testing/public/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("bG9naW5Vc2VybmFtZUVsZW1lbnQ")).sendKeys("admin@tvisha.com");
		driver.findElement(By.id("bG9naW5QYXNzd29yZEVsZW1lbnQ")).sendKeys("Admin@1201@");
		driver.findElement(By.id("bG9naW5CdG4")).click();
		
	}
}
