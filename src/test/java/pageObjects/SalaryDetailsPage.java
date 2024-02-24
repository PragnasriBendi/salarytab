package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryDetailsPage extends BasePage {
	
WebDriver driver;
	
	public SalaryDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='css-1h2sv0j']")
	WebElement jobRole;
	
	@FindBy(xpath="//div[@class='css-759u60']")
	WebElement navArrow;
	
	
	
	
	public String captureRole() {
		return jobRole.getText();
	}
	
	public void navigationCheck() {
		navArrow.click();
	}

}
