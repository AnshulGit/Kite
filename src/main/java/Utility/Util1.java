package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Util1 extends TestBase
{
	public static void screenShot(String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\91940\\OneDrive\\Desktop\\Eclipse Workspace\\Project1\\ScreenShot\\"+name+".jpeg");
	    FileHandler.copy(source, dest);      
	}

	public String readExcelFile(int rowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\91940\\OneDrive\\Desktop\\Eclipse Workspace\\Project1\\TestData\\Project1Data.xlsx");
	    Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
	    String value = excelSheet.getRow(rowNum).getCell(CellNum).getStringCellValue();
	    return value;
	}
}
