package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin2Page 
{
	@FindBy(id="pin")	private WebElement PIN;
	@FindBy(xpath="//button[text()='Continue ']")	private WebElement Continuebtn;
	
	public KiteLogin2Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLoginPin(String pin) 
	{
		PIN.sendKeys(pin);
	}
	
	public void ClickKiteLoginContinueBtn() 
	{
		Continuebtn.click();
	}
}
