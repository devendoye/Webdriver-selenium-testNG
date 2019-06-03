package co.test;


import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ApplicationTest {
 
	@BeforeSuite
	 public void beforeSuite()
	{
		System.out.println("----Before Test Suite-------");
	}
	
	@AfterSuite
	 public void afterSuite()
	{
		System.out.println("-----After Test Suite------");
	}
	
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before executiion test case ");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After  executiion test case ");
	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method");
	}
	
	
	
	@Test(priority =1) //testcase
	public void dologinTest ()
	{
	//	throw new SkipException("any code is not good");
		//webdriver code 
		System.out.println("login Test Execution");
	}
	
	@Test(priority =2 , dependsOnMethods={"dologinTest"} )
	public void doPasswordChangeTest()
	{
		System.out.println("changingPassword");
	}
	@Test(priority =3  , dependsOnMethods= {"dologinTest"}) 
	public void doLoginTest()
	{
		System.out.println("login out");
	}

}
