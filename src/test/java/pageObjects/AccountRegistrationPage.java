package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="firstname") WebElement txt_First_Name;
	@FindBy(name="lastname") WebElement txt_Last_Name;
	@FindBy(name="email") WebElement txt_Mail;
	@FindBy(name="telephone") WebElement txt_Mob;
	@FindBy(name="password") WebElement txt_Pass;
	@FindBy(name="confirm")  WebElement txt_confirm;
	@FindBy(xpath="//input[@type='checkbox']") WebElement chk_Box;
	@FindBy(xpath="//input[@type='submit']") WebElement btn_submit;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirm;
	
	public void firstName(String fname)
	{
		txt_First_Name.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txt_Last_Name.sendKeys(lname);
	}
	
	public void email(String mail)
	{
		txt_Mail.sendKeys(mail);
	}
	
	public void mobile(String mNum)
	{
		txt_Mob.sendKeys(mNum);
	}
	
	public void password(String pass)
	{
		txt_Pass.sendKeys(pass);
	}
	
	public void confirmPassword(String conf)
	{
		txt_confirm.sendKeys(conf);
	}
	
	public void check()
	{
		chk_Box.click();
	}
	
	public void submit()
	{
		btn_submit.click();
	}
	
	public String confirmMessge()
	{
		try {
			return  (msgConfirm.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	}
}
