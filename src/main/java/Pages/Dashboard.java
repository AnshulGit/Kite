package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.Util1;

public class Dashboard extends TestBase
{
	@FindBy(xpath="//div[@class='avatar']") private WebElement avatarLabel;
	@FindBy(xpath="//h4[@class='username']") private WebElement usernameLable;
	@FindBy(xpath="//div[@class='email']") private WebElement emailID;
	
	@FindBy(xpath="//button[text()='Start investing ']") private WebElement startInvestBtn;
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement searchTextBox;
	@FindBy(xpath="//ul[@class='omnisearch-results'] //li[@class='search-result-item selected']") private WebElement share;
	@FindBy(xpath="//button[text()='Create GTT ']") private WebElement createGtt;
	@FindBy(xpath="//input[@label='Trigger price']") private WebElement triggerPiceTextBox;
	@FindBy(xpath="//input[@label='Qty.']") private WebElement qty;
	@FindBy(xpath="//input[@label='Price']") private WebElement price;
	@FindBy(xpath="//button[@type='submit']//div") private WebElement placeBtn;
	
	@FindBy(xpath="//span[text()='Orders']") private WebElement orders;
	@FindBy(xpath="//span[text()='GTT']") private WebElement gtt;
	@FindBy(xpath="//div[@class='context-menu table']") private WebElement menuBtn;
	@FindBy(xpath="(//td[@class='instrument'])[1]") private WebElement hover;
	
	
	public Dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyusername() throws InterruptedException
	{
		avatarLabel.click();
		Thread.sleep(2000);
		return usernameLable.getText();
	}
	public String verifyEmail() throws InterruptedException
	{
		avatarLabel.click();
		Thread.sleep(2000);
		return emailID.getText();
	}
	public void createGtt() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Util1 ut = new Util1();
		
		startInvestBtn.click();
		Thread.sleep(2000);
		searchTextBox.sendKeys(ut.readExcelFile(0, 0));
		Thread.sleep(2000);
		share.click();
		Thread.sleep(2000);
		createGtt.click();
		Thread.sleep(2000);
		triggerPiceTextBox.clear();
		triggerPiceTextBox.sendKeys(ut.readExcelFile(0, 1));  //readExcelFile(0, 1)
		Thread.sleep(2000);
		qty.clear();
		qty.sendKeys(ut.readExcelFile(0, 2));
		Thread.sleep(2000);
		price.clear();
		price.sendKeys(ut.readExcelFile(0, 3));
		Thread.sleep(2000);
		placeBtn.click();
		Thread.sleep(2000);
	}
	public void deleteGtt() throws InterruptedException
	{
		orders.click();
		Thread.sleep(2000);
		gtt.click();
		Actions act = new Actions(driver);
		act.moveToElement(hover).build().perform();
		Thread.sleep(2000);
		menuBtn.click();
		Thread.sleep(5000);
		
		
	}


}
