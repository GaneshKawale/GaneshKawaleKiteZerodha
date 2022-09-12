package LibraryFiles;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String getTestData(int rowIndex,int cellIndex) throws FileNotFoundException,IOException
	{
		String xslpath = getPropertyFileData("XSLPATH");
		FileInputStream file=new FileInputStream(xslpath);
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String val=sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return val;
	}
	
	
	public static String getPropertyFileData(String key) throws FileNotFoundException,IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Kite\\PropertyFile\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		String val=p.getProperty(key);
		return val;
	}
	
	public static void TakeScreenshotFailed(WebDriver driver,int TCID) throws IOException 
	{
		String scrPath = getPropertyFileData("SCRPATH");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(scrPath+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	public static void ActionClassMethod(WebDriver driver,WebElement eleList,WebElement Clickbtn) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(eleList).perform();
		act.click(Clickbtn).perform();
	}
	
	public static void ActionClassMethod(WebDriver driver,WebElement eleList) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(eleList).perform();		
	}
	
	
}
