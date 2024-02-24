package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest1 extends BaseClass {
	
	@Test
	public void verify_Login() {
		logger.info("*** Starting Login test1 ***");
		logger.debug("capturing application logs...");
		try {
			LandingPage lan= new LandingPage(driver);
			logger.info("clicked on login button...");
			lan.clickLogin();
			
			LoginPage login = new LoginPage(driver);
			logger.info("Entering valid email and password...");
			login.fillEmailId(p.getProperty("userName"));
			login.fillPassword(p.getProperty("password"));
			login.clickLoginButton();
			
		}catch(Exception e) {
			Assert.fail();
		}		
		logger.info("*** Finished login test ***");
	}
	
	

	
}
