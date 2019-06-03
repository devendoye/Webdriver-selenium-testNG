package co.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTest {
	
	@Test
	public void doRegisterTest()
	{
		String expectedTitle ="xxx";
		String actualTitle ="";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
