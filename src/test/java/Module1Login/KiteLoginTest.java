package Module1Login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;

public class KiteLoginTest extends BaseClass 
{
	KiteHomePage home;
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	int TCID;
	
	@BeforeClass
	public void OpenBrowser() throws FileNotFoundException, IOException
	{
		OpenBrosermethod();
		home=new KiteHomePage(driver);
		login1=new KiteLogin1Page(driver);
		login2=new KiteLogin2Page(driver);
	}
	
	@BeforeMethod
	public void Login() throws FileNotFoundException, IOException
	{
		TCID=101;
		login1.inpKiteLoginUserName(UtilityClass.getPropertyFileData("UN"));
		login1.inpKiteLoginPassword(UtilityClass.getPropertyFileData("PWD"));
		login1.ClickKiteLoginBtn();
		login2.inpKiteLoginPin(UtilityClass.getPropertyFileData("PIN"));
		login2.ClickKiteLoginContinueBtn();
	}
	
	@Test(priority = 0)
	public void VerifyUserId() throws FileNotFoundException, IOException
	{
		String actResult=home.getUserName();
		String expResult=UtilityClass.getTestData(0, 2);
		Assert.assertEquals(actResult, expResult,"Failed:The Results are different");
	}
	
	@Test(priority = 1)
	public void VerifyEquityAddOnaPage()
	{
		
	}
	
	@AfterMethod
	public void Logout(ITestResult test) throws IOException
	{
		if(test.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.TakeScreenshotFailed(driver, TCID);
		}
		home.ClickLogOut();
	}
	
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
			driver.close();
	}

}
