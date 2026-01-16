package testCase;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
		@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
			
		logger.info("***** Starting TC001_AccountRegistrationTest *****");	
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked On MyAccount Link");
		
		hp.clickRegister();
	    logger.info("Clicked On Register Link");
		
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details....");
		ap.firstName(randomString().toUpperCase());
		ap.lastName(randomString().toUpperCase());
		ap.mobile(randomNumber());
		ap.email(randomString()+"@gmail.com");
		
		String pass = randomAlphaNumeric();
		ap.password(pass);
		ap.confirmPassword(pass);
		ap.check();
		ap.submit();
		
		logger.info("Validating Expected Message...");
		String message = ap.confirmMessge();
		
		  if(message.equals("Your Account Has Been Created!"))
		  {
			  Assert.assertTrue(true);
		  }
		  else
		  {
           logger.error("Test Failed...");
           logger.debug("Debug logs....");
           Assert.assertTrue(false);
		  }
		}
		  catch(Exception e)
		  {
			  Assert.fail();
		  }
		  
			logger.info("***** Finished TC001_AccountRegistrationTest *****");	

	}
	
	
}
