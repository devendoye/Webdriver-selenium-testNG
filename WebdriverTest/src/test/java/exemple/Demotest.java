package exemple;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Demotest {
	
	@Test
	public void sum ()
	{
		System.out.println("sum");
		int a = 2;
		int b = 4;
		AssertJUnit.assertEquals(6, a+b);
		
	}
	
	@Test
	public void muli ()
	{
		System.out.println("Multi");
		int a = 2;
		int b = 4;
		AssertJUnit.assertEquals(7, a*b);
		
		
	}
	
	@Test
	public void divi ()
	{
		System.out.println("div");
		int a = 4;
		int b = 2;
		AssertJUnit.assertEquals(0, a%b);
		
	}

	@Test
	public void sous ()
	{
		System.out.println("Sous");
		int a = 4;
		int b = 2;
		AssertJUnit.assertEquals(2, a-b);
		
	}



}
