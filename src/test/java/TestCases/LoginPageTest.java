package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (enabled = false)
	public void verifyTitleTest()
	{
		 String title = login.verifytitle();
		 Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (enabled = false)
	public void verifyKiteLogoTest()
	{
		boolean kiteLogo = login.verifyKiteLogo();
		Assert.assertEquals(true, kiteLogo);
		
//		other way
//		Assert.assertTrue(kiteLogo);
			
	}
	@Test (enabled = false)
	public void verifyZerodhaLogoTest()
	{
		boolean zerodhaLogo = login.verifyZerodhaLogo();
		Assert.assertEquals(true, zerodhaLogo);
		
//		other way
//		Assert.assertTrue(zerodhaLogo);
	}
	@Test
	public void verifyLoginToAppTest() throws InterruptedException, IOException
	{
		String value = login.LoginToApp();
		Assert.assertEquals(value, "Punit");
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}

}
