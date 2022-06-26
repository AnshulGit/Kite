package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Dashboard;
import Pages.LoginPage;
// hello team, i pushed the code
public class DashboardTest extends TestBase 
{

	Dashboard dash;
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		login.LoginToApp();
		dash = new Dashboard();
	}
	
	@Test (enabled = false)
	public void usernameTest() throws InterruptedException
	{
		String username = dash.verifyusername();
		Assert.assertEquals("Punit Randhir Madankar", username );
		
		
		
	//	Assert.assertTrue(false); this is how we can make test case failed
	}
	@Test (enabled = false)
	public void emailIDTest() throws InterruptedException
	{
		String email = dash.verifyEmail();
		Assert.assertEquals(email, "punitmadankar36@gmail.com");
		
	}
	@Test (enabled = false)
	public void creatGttTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dash.createGtt();
	}
	
	@Test
	public void deleteGttTest() throws InterruptedException
	{
		dash.deleteGtt();
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}

}
