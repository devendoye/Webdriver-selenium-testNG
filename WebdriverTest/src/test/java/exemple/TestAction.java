package exemple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestAction {

	public WebDriver driver;
	String baseUrl ="http://demo.guru99.com/test/delete_customer.php";
  @Test
  public void actionAlert() {
	  driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("500");
	  driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	  Alert  capture = driver.switchTo().alert();
	  String alertmessage = driver.switchTo().alert().getText();
      System.out.println("your message" +alertmessage);
      capture.dismiss();
  }
	  
  

  @AfterTest
  public void afterTest() {
	  
	driver.close();
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
		  
			System.setProperty("webdriver.chrome.driver", "//C:/test/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(baseUrl);
			Thread.sleep(5000);
  }


}
