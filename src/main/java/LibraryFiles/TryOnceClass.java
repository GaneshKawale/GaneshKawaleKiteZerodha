package LibraryFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Module1Login.KiteHomePage;
import Module1Login.KiteLogin1Page;
import Module1Login.KiteLogin2Page;
import RecentTestCasesBySanjaySir.RecentTestCasesBySanjaySir;

public class TryOnceClass 
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		BaseClass bs=new BaseClass();
		bs.OpenBrosermethod();
		RecentTestCasesBySanjaySir NewTCS=new RecentTestCasesBySanjaySir(bs.driver);
		//KiteHomePage home=new KiteHomePage(bs.driver);
		KiteLogin1Page login1=new KiteLogin1Page(bs.driver);
		KiteLogin2Page login2=new KiteLogin2Page(bs.driver);
		login1.inpKiteLoginUserName(UtilityClass.getPropertyFileData("UN"));
		login1.inpKiteLoginPassword(UtilityClass.getPropertyFileData("PWD"));
		login1.ClickKiteLoginBtn();
		login2.inpKiteLoginPin(UtilityClass.getPropertyFileData("PIN"));
		login2.ClickKiteLoginContinueBtn();
		NewTCS.inpAddStock(bs.driver, UtilityClass.getTestData(1, 0));
		NewTCS.ClickBuyEquity(bs.driver, UtilityClass.getTestData(1, 0));
		bs.driver.findElement(By.xpath("//input[@rules='[object Object],[object Object],[object Object]']")).click();;		
		String Qty = bs.driver.findElement(By.xpath("/html/body/div[1]/form/section/div/div[2]/div[2]/div[1]/div[1]/div/input")).getText();
		System.out.println(Qty);
//		String Expqty="1";
//		if(Qty.equals(Expqty))
//		{
//			System.out.println("Yes");
//		}
//		else
//		{
//			System.out.println("No");
//		}
		
		
		
		
	}
}
