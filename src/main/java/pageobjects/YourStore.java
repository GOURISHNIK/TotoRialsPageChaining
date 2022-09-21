package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import resources.Base;
import util.WindowsHandling;

public class YourStore extends WindowsHandling{

	public WebDriver driver;

	public YourStore(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(linkText="Login")
	WebElement LoginOption;
	
	public String getYourStoreTitle() {
		String ysTitle = driver.getTitle();
		return ysTitle;
		
		
	}

	public void MyAccountClick() {
		MyAccount.click();
	}
	
	public AccountLogin LoginOptionClick() {
		LoginOption.click();
		return new AccountLogin(driver);
		
	}
	
	
	public AccountLogin navigateToLoginPage() {
		MyAccount.click();
		LoginOption.click();
		return new AccountLogin(driver);
	}
	
	
	
	@FindBy(linkText="Open a popup window")
	WebElement popUpLink;
	
	public void popUpLinkClick() {
		mouseOverElementClick(driver,popUpLink);
		
	}
	
	
}
