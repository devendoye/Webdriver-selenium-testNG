package exemple;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.bytebuddy.jar.asm.Handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class testAmazon<E> {

	public WebDriver driver;
	String baseUrl = "https://www.amazon.fr";
	
  @Test (priority =1)
  public void linkCD() throws InterruptedException {
	  WebElement category = driver.findElement(By.cssSelector("#nav-link-shopall > span:nth-child(2)"));
	  Actions builder = new Actions(driver);
	  builder.moveToElement(category).build().perform();
	  Thread.sleep(5000);
	  WebElement testfilm = driver.findElement(By.xpath("//span[@class='nav-text'][contains(.,'Musique, Films et Jeux vidéo')]"));
	  builder.moveToElement(testfilm).build().perform();
	  Thread.sleep(5000);
	  WebElement choisevideo = driver.findElement(By.xpath("(//span[contains(@class,'nav-text')])[100]"));
	  choisevideo.click();
	  Thread.sleep(5000);
	  
  }
  
 @Test (priority =2)
  public void SearchProduit() throws InterruptedException {
	  driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("jonny holliday");
	  Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[contains(@value,'Go')]")).click();
	   Thread.sleep(3000);
	  
	  
  }
  
  @Test (priority = 3)
  public void SelectProduit() {
	  
	  driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[1]")).click();
	  
	 String handles  = driver.getWindowHandle();
	 Set<String>  s1 = driver.getWindowHandles();
	 Iterator<String> i1 = s1.iterator();
	 while (i1.hasNext())
	 {
		 String chilhandles = i1.next();
		 if (!handles.equalsIgnoreCase(chilhandles))
		 {
			 driver.switchTo().window(chilhandles);
			 System.out.println(chilhandles);
		 }
		 
	 }
	 driver.switchTo().defaultContent();
  }
  
  @Test (priority =4)
  public void AddCard() {
	  driver.findElement(By.xpath("//input[contains(@name,'submit.add-to-cart')]")).click();
  }
  
  @BeforeTest
  public void invokeBrowser() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "//C:/test/geckodriver.exe");
	  driver =   new FirefoxDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
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
