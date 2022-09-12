package RecentTestCasesBySanjaySir;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class RecentTestCasesBySanjaySir 
{
	@FindBy(xpath="//div[@class='vddl-list list-flat']/div/div/div/span") private List<WebElement> EquityNamesonThePage;
	@FindBy(xpath="//span[@class='icon icon-plus']")private WebElement AddEquity;
	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement BuyEquity;
	@FindBy(xpath="//button[@class='button-orange sell']")private WebElement SellEquity;
	@FindBy(xpath="//span[@class='icon icon-trending-up']")private WebElement ChartofEquity;
	@FindBy(xpath="//span[@class='icon icon-trash']")private WebElement DeleteEquity;
	@FindBy(xpath="//span[@class='icon icon-align-center']")private WebElement MarketDepthEquity;
	@FindBy(xpath="//button[@class='context-menu-button button-outline']")private WebElement MoreOtionsEquity;
	@FindBy(xpath="//input[@rules='[object Object],[object Object],[object Object]']")	private WebElement EquityQuantity;
	@FindBy(xpath="//input[@rules='[object Object]']") private WebElement EquityPrice;
	@FindBy(xpath="//label[text()='Market']") private WebElement EquityMarketrdb;
	@FindBy(xpath="//label[text()='Limit']") private WebElement EquityLimitrdb;
	@FindBy(xpath="//label[contains(text(),'NSE: ')]") private WebElement EquityTypeNSE;
	@FindBy(xpath="//label[contains(text(),'BSE: ')]") private WebElement EquityTypeBSE;
	@FindBy(xpath="//div[@class='message']") private WebElement ErrorMsg;
	@FindBy(xpath="//div[@class='dropdown-nav-header']") private WebElement UserName;
	@FindBy(xpath="//span[@class='user-id']") private WebElement UserId;
	@FindBy(xpath="//input[@icon='search']") private WebElement SearchEquity; 
	@FindBy(xpath="//ul[@class='omnisearch-results']/div/li/span/span")	private List<WebElement> SearchedStock;
	
	public RecentTestCasesBySanjaySir(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickBuyEquity(WebDriver driver,String EqName) 
	{
		
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				BuyEquity.click();
			}
		}	
		
	}
	
	public void ClickSellEquity(WebDriver driver,String EqName) 
	{
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				SellEquity.click();
			}
		}	
		
	}
	
	public void ClickDeleteEquity(WebDriver driver,String EqName) 
	{
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				DeleteEquity.click();
			}
		}
	}
	
	public void ClickMoreOptionEquity(WebDriver driver,String EqName) 
	{
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				MoreOtionsEquity.click();
			}
		}	
	}
	
	public void ClickChartEquity(WebDriver driver,String EqName) 
	{
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				ChartofEquity.click();
			}
		}	
	}
	
	public void ClickMarketDepthEquity(WebDriver driver,String EqName) 
	{
		
		for (WebElement webElement : EquityNamesonThePage) 
		{
			String val=webElement.getText();
			if(EqName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement);
				MarketDepthEquity.click();
			}
		}	
	}
	
	public void ClickMarketrdb() 
	{
		EquityMarketrdb.click();
	}
	public void ClickLimitrdb() 
	{
		EquityLimitrdb.click();
	}
	
	public String ErrorMessage() 
	{
		String error = ErrorMsg.getText();
		return error;
	}
	
	public boolean ElementStatus() 
	{
		boolean status = EquityPrice.isEnabled();
		return status;
	}
	
	
	public void ClickUserId() 
	{
		UserId.click();
	}
	public void ClickUserDetails() 
	{
		UserName.click();
	}
	
	public void inpEquityPrice(double EqtPrice) 
	{
		double round=Math.round((EqtPrice*20.0)/20.0);
		
		String val=String.valueOf(EqtPrice).toString();
		
		if(round==EqtPrice)
		{
			EquityPrice.sendKeys(val);
		}		
	}
	
	public void inpAddStock(WebDriver driver ,String StockName) 
	{
		SearchEquity.sendKeys(StockName);
		for (WebElement webElement : SearchedStock) 
		{
			String val=webElement.getText();
			if(StockName.equals(val))
			{
				UtilityClass.ActionClassMethod(driver, webElement,AddEquity);
				SearchEquity.sendKeys(Keys.ESCAPE);
				break;
			}
			
		}
	}
	
	public String CheckStockQty() 
	{
		String val =EquityQuantity.getText();
		return val;
	}
	
	public void inpFNOEquityQty(int EqtQty) 
	{
		String val=String.valueOf(EqtQty).toString();
		
		if(EqtQty/25==0)
		{
			EquityQuantity.sendKeys(val);
		}		
	}
	
	
}
