package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo; 
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath="//input[@type='text']") private WebElement usernameTextBox;
	@FindBy(xpath="//input[@type='password']") private WebElement passwordTextBox;
	@FindBy(xpath="//button[@type='submit']") private WebElement submitBtn;
	@FindBy(xpath="//input[@label='PIN']") private WebElement pinTextBox;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath="//span[@class='nickname']") private WebElement nickName;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyKiteLogo()
	{
		return kiteLogo.isDisplayed();
	}
	public boolean verifyZerodhaLogo()
	{
		return zerodhaLogo.isDisplayed();
	}
	public String LoginToApp() throws InterruptedException, IOException
	{
		usernameTextBox.sendKeys(readPropertyFile("username"));
		passwordTextBox.sendKeys(readPropertyFile("password"));
		submitBtn.click();
		pinTextBox.sendKeys(readPropertyFile("pin"));
		continueBtn.click();
		Thread.sleep(2000);
		return nickName.getText();
		
	}

}
