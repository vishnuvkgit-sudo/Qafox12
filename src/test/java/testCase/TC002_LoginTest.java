package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest ******");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	    
		logger.info("****** Passing Login Credentials ******");
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("pass"));
		lp.clickLogin();
		
		logger.info("****** Validating MyAccountPage ******");
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage = mp.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login Failed");
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_LoginTest ******");
	}

}
