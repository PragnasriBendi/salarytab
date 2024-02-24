package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryPage extends BasePage {
	
	WebDriver driver;
	
	public SalaryPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//button[text()='Salary']")
	WebElement salaryTab;
	
	/*@FindBy(xpath="(//span[text()='Full Pay Details'])[1]")
	WebElement payDetails;*/
	
	@FindBy(xpath="(//span[text()='Full Pay Details'])[1]")
	WebElement payDetails;
	
	
	public void clickSalaryTab() {
		salaryTab.click();
	}
	
	public void clickPayDetails() {
		payDetails.click();
	}

}
