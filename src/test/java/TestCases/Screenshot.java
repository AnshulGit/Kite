package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Dashboard;
import Pages.LoginPage;
import Utility.Util1;

public class Screenshot extends TestBase
{
	public LoginPage login;
	Dashboard dash;
	
	@BeforeMethod 
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		
		dash = new Dashboard();
	}
	
	@Test 
	public void verifyTitleTest() 
	{
		String value = login.verifytitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", value);
	}
	@Test
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, false);
	}
	@Test
	public void usernameTest() throws InterruptedException, IOException
	{
		login.LoginToApp();
		String username = dash.verifyusername();
		Assert.assertEquals("Punit Randhi Madankar", username );
	}
	
	@AfterMethod
	public void exit(ITestResult it) throws IOException 
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			Util1.screenShot(it.getName());
		}
		driver.quit();
		
		
		
	}

	


}
