package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase 
{
	public String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\91940\\OneDrive\\Desktop\\Eclipse Workspace\\Project1\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);			
	}
	
	public static WebDriver driver;	
	public void initialization() throws IOException
	{
		String browserName = readPropertyFile("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); // to disable browser exception
//		opt.addArguments("--incognito"); to run the test in incognito mode 
		driver = new ChromeDriver(opt);
		}
		else if(browserName.equalsIgnoreCase("gecko"))
		{
			FirefoxOptions opt1 = new FirefoxOptions();
		    opt1.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver(opt1);
		}
		else if(browserName.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\Users\\91940\\OneDrive\\Desktop\\Eclipse Workspace\\Project1\\operadriver.exe");
			OperaOptions opt2 = new OperaOptions();
		    opt2.addArguments("--disabled-notifications");
		    driver = new OperaDriver(opt2);
			
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
			EdgeOptions opt3 = new EdgeOptions();
			opt3.addArguments("--disabled-notifications");
			driver = new EdgeDriver(opt3);
					
		}	
		else 
		{
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies(); // to delete all brwoser cookies
	//	driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readPropertyFile("url"));
		
	}
	
	
	

}
