package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

    @FindBy(name="email") WebElement txt_Email;
    @FindBy(name="password") WebElement txt_pass;
    @FindBy(xpath="//input[@value='Login']") WebElement btn_Login;
    
    public void setEmail(String mail)
    {
    	txt_Email.sendKeys(mail);
    }
    
    public void setPass(String pwd)
    {
    	txt_pass.sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	btn_Login.click();
    }
}
