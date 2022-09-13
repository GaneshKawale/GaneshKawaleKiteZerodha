package RecentTestCasesBySanjaySir;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1Login.KiteHomePage;
import Module1Login.KiteLogin1Page;
import Module1Login.KiteLogin2Page;

public class RecentTestCasesBySanjaySirTestClass extends BaseClass
{
	KiteHomePage home;
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	RecentTestCasesBySanjaySir NewTCS;
	int TCID;
	
	@BeforeClass
	public void OpenBrowser() throws FileNotFoundException, IOException
	{
		OpenBrosermethod();
		home=new KiteHomePage(driver);
		login1=new KiteLogin1Page(driver);
		login2=new KiteLogin2Page(driver);
		NewTCS=new RecentTestCasesBySanjaySir(driver);
	}
	
	@BeforeMethod
	public void Login() throws FileNotFoundException, IOException
	{
		
		login1.inpKiteLoginUserName(UtilityClass.getPropertyFileData("UN"));
		login1.inpKiteLoginPassword(UtilityClass.getPropertyFileData("PWD"));
		login1.ClickKiteLoginBtn();
		login2.inpKiteLoginPin(UtilityClass.getPropertyFileData("PIN"));
		login2.ClickKiteLoginContinueBtn();
	}
	
	
	@Test
	public void VerifyQtyFieldDefaultval1() throws FileNotFoundException, IOException
	{
		TCID=102;
		NewTCS.inpAddStock(driver, UtilityClass.getTestData(1, 0));
		NewTCS.ClickBuyEquity(driver, UtilityClass.getTestData(1, 0));
		String ActQtyResult = NewTCS.CheckStockQty();
		String ExpQtyResult=UtilityClass.getTestData(2, 0);
		SoftAssert Soft=new SoftAssert();
		Soft.assertEquals(ActQtyResult, ExpQtyResult,"Failed:Values Does Not Match");
		
		String ActResult = NewTCS.GetAvailableCash();
		String ExpResult="0.00";
		Soft.assertEquals(ActResult, ExpResult,"Failed:Value Does Not Match");
	}	
	
	
	@AfterMethod
	public void Logout(ITestResult test) throws IOException
	{
		if(test.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.TakeScreenshotFailed(driver, TCID);
		}
//		home.ClickLogOut();
	}
	
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException
	{
//		Thread.sleep(5000);
//			driver.close();
	}


}
