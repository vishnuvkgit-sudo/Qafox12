package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	
    public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[.='My Account']") WebElement btn_My_Account;
	@FindBy(xpath ="//a[normalize-space()='Register']") WebElement btn_Register;
	@FindBy(xpath="//a[.='Login']") WebElement btn_Login;
	
	public void clickMyAccount()
	{
		btn_My_Account.click();
	}
	
	public void clickRegister()
	{
		btn_Register.click();
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}

}
