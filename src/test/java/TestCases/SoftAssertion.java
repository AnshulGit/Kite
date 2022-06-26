package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion 
{
	@Test    
	public void soft()
	{
	    SoftAssert a = new SoftAssert();
	    a.assertTrue(true);
	    a.assertTrue(false);
	    System.out.println("Anshul");
	    
	    a.assertAll();
	    System.out.println("Anshul After");
	    
		
	}
	@Test (enabled = false)
	public void soft1()
	{
		SoftAssert a = new SoftAssert();
		a.assertTrue(false);
		a.assertAll();
	}

}
