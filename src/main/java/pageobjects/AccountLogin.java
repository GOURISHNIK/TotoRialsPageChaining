package pageobjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class AccountLogin{

	public WebDriver driver;
	public Properties prop;

	public AccountLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailFieldInput;

	@FindBy(id = "input-password")
	WebElement passwordFieldInput;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButtonClick;

	public String getAccountLoginTitle() {
		String gaTitle = driver.getTitle();
		return gaTitle;
	}

	public MyAccount loginFunctionality(String email,String password) {
		emailFieldInput.sendKeys(email);
		passwordFieldInput.sendKeys(password);
		loginButtonClick.click();
		return new MyAccount(driver);
	}

}
