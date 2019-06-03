package exemple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestSouris {
	
	
public WebDriver driver ;
String baseurl ="http://demo.guru99.com/test/newtours";

  @Test
  public void testSouris () {
	 WebElement  linkelement = driver.findElement(By.linkText("Home"));
	 WebElement  tdhome = driver.findElement(By.xpath("(//td[contains(@width,'20')])[1]"));
	  Actions  build = new Actions(driver);
	  Action  element = build.moveToElement(linkelement).build();
	  System.out.println("le code couler avant :" + tdhome.getCssValue("background-color"));
	  element.perform();
	  System.out.println("le code couler avant :" + tdhome.getCssValue("background-color"));
	  
  }
  @BeforeTest
  public void invokeBrowser() throws InterruptedException {
	  
		System.setProperty("webdriver.chrome.driver", "//C:/test/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(baseurl);
		Thread.sleep(5000);
  }

  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }

}
