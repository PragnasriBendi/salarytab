package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewJobsPage extends BasePage {
	
WebDriver driver;
	
	public ViewJobsPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-v02wf3']")
	WebDriver viewJobs;
	
	@FindBy(id = "searchTextFild")
	WebElement searchInput;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//a[text()=' Mind Space'])[1]")
	WebElement orgName;
	
	@FindBy(xpath="//div[@class='MuiBox-root css-13yn9br']")
	WebElement icon;
	
	@FindBy(xpath="//li[text()='Logout']")
	WebElement logout;
	
	
	/*public String captureText() {
		try {
			return(viewJobs.getTitle());
		}catch(Exception e) {
			return(e.getMessage());
		}	
		
	}	*/
	
	
	public void focusSearchField() {
		searchInput.click();
		
	}
	
	public void searchButton() {
		searchButton.click();
	}
	
	public void chooseOrgName() {
		orgName.click();
		
	}
	
	public void clickIcon() {
		icon.click();
	}
	
	public void logout() {
		logout.click();
	}
	
	
	

}
