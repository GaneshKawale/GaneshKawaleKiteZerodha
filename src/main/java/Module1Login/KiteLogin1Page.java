package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page 
{
	@FindBy(id="userid")	private WebElement Uid;
	@FindBy(id="password")  private WebElement Pwd;
	@FindBy(xpath="//button[text()='Login ']")		private WebElement LoginBtn;
	
	public KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLoginUserName(String Uname) 
	{
		Uid.sendKeys(Uname);
	}
	
	public void inpKiteLoginPassword(String Pass) 
	{
		Pwd.sendKeys(Pass);
	}
	
	public void ClickKiteLoginBtn() 
	{
		LoginBtn.click();
	}
	
	
	
}
