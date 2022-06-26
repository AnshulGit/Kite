package TestCases;

	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import Base.TestBase;
	import Pages.LoginPage;

	public class DependsOnLoginPageTest extends TestBase
	{
		LoginPage login;
		@BeforeMethod
		public void setup() throws IOException
		{
			initialization();
			login = new LoginPage();
		}
		
		@Test 
		public void verifyTitleTest()
		{
			 String title = login.verifytitle();
			 Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		    
		}
		
		@Test (dependsOnMethods = {"verifyTitleTest"})
		public void verifyKiteLogoTest()
		{
			boolean kiteLogo = login.verifyKiteLogo();
			Assert.assertEquals(true, kiteLogo);
			
				
		}
		@Test (dependsOnMethods = {"verifyTitleTest", "verifyKiteLogoTest"}) // can be defined without curley braces
		public void verifyZerodhaLogoTest()
		{
			boolean zerodhaLogo = login.verifyZerodhaLogo();
			Assert.assertEquals(true, zerodhaLogo);
			
//			other way
//			Assert.assertTrue(zerodhaLogo);
		}
		@Test (enabled = false)
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



