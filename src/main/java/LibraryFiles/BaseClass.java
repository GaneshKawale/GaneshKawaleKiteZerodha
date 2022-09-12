package LibraryFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass 
{
	public WebDriver driver;
	
	public void OpenBrosermethod() throws FileNotFoundException, IOException 
	{
		String ChromePath = UtilityClass.getPropertyFileData("CHROME");
		System.setProperty("webdriver.chrome.driver", ChromePath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));		
	}

}
