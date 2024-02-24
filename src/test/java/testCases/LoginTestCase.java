package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SalaryDetailsPage;
import pageObjects.SalaryPage;
import pageObjects.ViewJobsPage;
import testBase.BaseClass;

public class LoginTestCase extends BaseClass {
	
	@Test(priority=1)
	public void verifyLogin() throws InterruptedException {
		logger.info("***Starting LoginTestCase***");
		logger.debug("application logs...");
		
		LandingPage lp = new LandingPage(driver);
		lp.clickLogin();
		logger.info("***clicked on login button in landingpage***");
		LoginPage lg = new LoginPage(driver);
		logger.info("***Entering login credentials***");
		lg.fillEmailId(p.getProperty("userName"));
		lg.fillPassword(p.getProperty("password"));
		lg.clickLoginButton();
		logger.info("***clicked on login button***");
		
		/*ViewJobsPage viewjobs = new ViewJobsPage(driver);
		String cnfmsg = viewjobs.captureViewJobsTitle();
		Assert.assertEquals(cnfmsg, "Login successfull !!!");*/
			
	}
	
	@Test(priority=2)
	public void verifyOrgProfile() throws InterruptedException {
		ViewJobsPage viewjobs = new ViewJobsPage(driver);
		viewjobs.focusSearchField();
		
		WebElement search = driver.findElement(By.id("searchTextFild"));
		Thread.sleep(2000);
		search.sendKeys("min");
		Thread.sleep(3000);
		search.sendKeys(Keys.ARROW_DOWN);
		search.sendKeys(Keys.ENTER);
		viewjobs.searchButton();
		Thread.sleep(5000);
		viewjobs.chooseOrgName();
		
	}
	
	@Test(priority=3)
	public void verifySalaryTab() throws InterruptedException {
		Thread.sleep(5000);
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		
		driver.switchTo().window(childwindow);
		
		SalaryPage salary = new SalaryPage(driver);
		salary.clickSalaryTab();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)","");
		
	}
	
	@Test(priority=4)
	public void verifyFullPayDetails() throws InterruptedException {
		SalaryPage salary = new SalaryPage(driver);
		Thread.sleep(5000);
		salary.clickPayDetails();
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void verifyJobtitleandNavigation() {
		SalaryDetailsPage details = new SalaryDetailsPage(driver);
		String text = details.captureRole();
		logger.info("***validating expected message***");
		Assert.assertEquals(text, ".Net Developer Salaries");
		
		details.navigationCheck();
		
	}
	
	
	
	
	
	
	

}
