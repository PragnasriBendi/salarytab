package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")
	WebElement emailIdfield;
	
	@FindBy(name="password")
	WebElement passcodefield;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;
	
	
	public void fillEmailId(String emailId) {
		emailIdfield.sendKeys(emailId);
	}
	
	public void fillPassword(String pass) {
		passcodefield.sendKeys(pass);		
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	
	
	

}
