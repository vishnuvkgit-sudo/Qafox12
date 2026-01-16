package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[.='My Account']") WebElement msgHeading;
	@FindBy(xpath="//div[@class='list-group']//a[.='Logout']") WebElement btn_Logout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}

	public void clickLogout()
	{
		btn_Logout.click();
	}
}
