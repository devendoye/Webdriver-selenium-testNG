package exemple;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestHandle {
	public WebDriver driver;
	String baseUrl ="http://demo.guru99.com/popup.php";
	
  @Test
  public void  testHandle() {
	 driver.findElement(By.xpath("//a[contains(@target,'_blank')]")).click();
	 String windowHandle = driver.getWindowHandle();
	 Set<String> s1 = driver.getWindowHandles();
	  Iterator<String> i1 = s1.iterator();
	  
	  while(i1.hasNext())
	  {
		  String childwindow = i1.next();
		  if (!windowHandle.equalsIgnoreCase(childwindow)){
			  driver.switchTo().window(childwindow);
			  driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("daouda.ndoye25@gmail.com");
			  driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
			  driver.close();
		  
		  }
	
	  }
	 driver.switchTo().window(windowHandle);
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

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
