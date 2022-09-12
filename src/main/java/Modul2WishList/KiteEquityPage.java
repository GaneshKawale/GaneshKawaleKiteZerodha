package Modul2WishList;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class KiteEquityPage 
{
	@FindBy(xpath="//span[@class='nice-name']") private List<WebElement> ListofEquity;
	@FindBy(xpath="//button[@class='button-blue buy']") private WebElement Buybtn;
	@FindBy(xpath="//span[@class='icon icon-trash']") private WebElement DelEquity;
	@FindBy(xpath="//button[@class='button-orange sell']") private WebElement Sellbtn;
	@FindBy(xpath="//span[@class='icon icon-ellipsis']") private WebElement Morebtn;
	@FindBy(xpath="//span[@class='icon icon-align-center']") private WebElement	MarketDeptbtn;
	@FindBy(xpath="//span[@class='icon icon-trending-up']") private WebElement	ChartUpbtn;
	@FindBy(xpath="//ul[@class='marketwatch-selector list-flat']/li") private List<WebElement> Paging;
	@FindBy(xpath="//input[@icon='search']")	private WebElement SearchEquity;
	@FindBy(xpath="//ul[@class='omnisearch-results']/div/li")	private List<WebElement> SearchedEquityList;
	@FindBy(xpath="//span[@class='icon icon-plus']") private WebElement AddEquityinList;
	
	KiteEquityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AddEquitytoPage(WebDriver driver,String EquityName) 
	{
		
		SearchEquity.sendKeys(EquityName);
		if(ListofEquity.size()>50)
		{
			for (WebElement webElement : SearchedEquityList) 
			{
				if(webElement.getText()==EquityName)
				{
					UtilityClass.ActionClassMethod(driver, webElement, AddEquityinList);
					break;
				}
			}
		}
		else
		{
			for (int i = 0; i < Paging.size()-1; i++) 
			{
				if(Paging.get(i).getText()=="1")
				{
					//UtilityClass.ActionClassMethod(driver, Paging.get(i).click(), AddEquityinList);
					
				}
			}
		}
	}
	
	
	
	
	
	
}
