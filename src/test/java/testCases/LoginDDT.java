package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ViewJobsPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String username, String password, String exp) {
		//logger.info("*** Starting Login testCase ***");
			
		LandingPage lan= new LandingPage(driver);
		//logger.info("clicked on login button...");
		lan.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		//logger.info("Entering valid email and password...");
		login.fillEmailId(username);
		login.fillPassword(password);
		login.clickLoginButton();
		
		ViewJobsPage jobs = new ViewJobsPage(driver);
		
		if(exp.equalsIgnoreCase("Valid")) {
				jobs.clickIcon();
				jobs.logout();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
		if(exp.equalsIgnoreCase("Invalid")) {
			jobs.clickIcon();
			jobs.logout();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			
		}
	  
	}
	
		
	}



