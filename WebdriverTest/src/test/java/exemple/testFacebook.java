package exemple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class testFacebook {
	 public WebDriver driver;
  @Test
  public void connexion () throws InterruptedException {
	  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("devendoye@hotmail.com");
	  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Passera85+");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[contains(@value,'Connexion')]")).click();
	  Thread.sleep(5000);
  }
  
  @Test
  public void deconneexion () throws InterruptedException {
	  driver.findElement(By.xpath("//div[contains(@class,'_6qfu _5lxt f_click')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("")).click();
  }
  
  @BeforeTest
  public void invokeBrowser() throws InterruptedException {
	 
	  System.setProperty("webdriver.chrome.driver", "//C:/test/chromedriver.exe");
	  String baseUrl ="https://www.facebook.com/";
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  Thread.sleep(5000);
	  
  }

  
  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }

}
