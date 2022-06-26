package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class GroupTest extends TestBase
{
	LoginPage login;
	@BeforeMethod (groups = {"Sanity", "Regression"})
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (groups = "Sanity")
	public void verifyTitleTest()
	{
		 String title = login.verifytitle();
		 Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (groups = "Regression")
	public void verifyKiteLogoTest()
	{
		boolean kiteLogo = login.verifyKiteLogo();
		Assert.assertEquals(true, kiteLogo);
		
//		other way
//		Assert.assertTrue(kiteLogo);
			
	}
	@Test (groups = "Sanity")
	public void verifyZerodhaLogoTest()
	{
		boolean zerodhaLogo = login.verifyZerodhaLogo();
		Assert.assertEquals(true, zerodhaLogo);
		
//		other way
//		Assert.assertTrue(zerodhaLogo);
	}
	@Test (groups = "Regression")
	public void verifyLoginToAppTest() throws InterruptedException, IOException
	{
		String value = login.LoginToApp();
		Assert.assertEquals(value, "Punit");
	}
	
	@AfterMethod (groups = {"Sanity", "Regression"})
	public void exit()
	{
		driver.close();
	}

}
