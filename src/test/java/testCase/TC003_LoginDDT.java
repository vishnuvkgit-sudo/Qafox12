package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is Valid - Login success - test pass - logout
Data is Valid - Login failed - test fail

Data is Invalid - Login success - test fail - logout
Data is Invalid - Login failed - test pass
*/


public class TC003_LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class,groups="DataDriven") //getting data provider from different class
    public void verify_LoginDDT(String email,String pwd,String exp)
    {
		logger.info("***** Starting TC003_LoginDDT ******");
		
		try
		{
    	HomePage hp= new HomePage(driver);
    	hp.clickMyAccount();
    	hp.clickLogin();
        
    	logger.info("****** Passing Login Credentials ******");
    	
    	LoginPage lp= new LoginPage(driver);
    	lp.setEmail(email);
    	lp.setPass(pwd);
    	lp.clickLogin();
    	
    	logger.info("****** Validating MyAccountPage ******");
    	
    	MyAccountPage mp = new MyAccountPage(driver);
    	boolean targetPage = mp.isMyAccountPageExists();
    	
    	if(exp.equalsIgnoreCase("Valid"))
    	{
    		if(targetPage==true)
    		{
    			mp.clickLogout();
    			Assert.assertTrue(true);
    		}
    		else
    		{
    			Assert.assertTrue(false);
    		}
    	}
    	
    	if(exp.equalsIgnoreCase("Invalid"))
    	{
    		if(targetPage==true)
    		{
    			mp.clickLogout();
    			Assert.assertTrue(false);
    		}
    		else
    		{
    			Assert.assertTrue(true);
    		}
    		
    	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
    	logger.info("***** Finished TC003_LoginTest ******");
    }
}
