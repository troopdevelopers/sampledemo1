package selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class TimeDynamo_Login {
WebDriver driver;

@Test
public void testt() {

setup();

driver.manage().window().maximize();
driver.get("http://tvishasystems.com/webdemo/timedynamo_testing/public/login");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.id("bG9naW5Vc2VybmFtZUVsZW1lbnQ")).sendKeys("admin@tvisha.com");
driver.findElement(By.id("bG9naW5QYXNzd29yZEVsZW1lbnQ")).sendKeys("Admin@1201@");
driver.findElement(By.id("bG9naW5CdG4")).click();

}

public void setup() {
DesiredCapabilities caps = new DesiredCapabilities();
//	caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
//caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/ec2-user/phantomjs");
caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\AWS-Hosting\\Jenkins\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

driver = new PhantomJSDriver(caps);
}
}
