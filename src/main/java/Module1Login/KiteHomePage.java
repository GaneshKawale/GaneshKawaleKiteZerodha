package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath="//span[@class='user-id']")	private WebElement UserName;
	@FindBy(xpath="//span[@class='icon icon-exit']") private WebElement Logout;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName()
	{
		String UN=UserName.getText();
		return UN;
	}
	
	public void ClickLogOut() 
	{
		UserName.click();
		Logout.click();
	}
}
