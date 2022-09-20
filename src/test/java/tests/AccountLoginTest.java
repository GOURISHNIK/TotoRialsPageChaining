package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountLogin;
import pageobjects.MyAccount;
import pageobjects.YourStore;
import resources.Base;

public class AccountLoginTest extends Base {
	public WebDriver driver;
	public YourStore yourStore;
	public AccountLogin accountLogin;
	public MyAccount myAccount;

	@Test(priority = 0)
	public void accountLoginTitle() {
		String accountTitle1 = accountLogin.getAccountLoginTitle();
		Assert.assertEquals(accountTitle1, prop.getProperty("accountLoginTitleDp"));

	}

	@Test(priority = 1)
	public void accountLoginFunctionalityValidation() throws InterruptedException {
		myAccount = accountLogin.loginFunctionality(prop.getProperty("email12"), prop.getProperty("password12"));
		Assert.assertEquals(myAccount.getMyAccountTitle(), prop.getProperty("myAccountTitleExpected"));
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		driver = initializeDriver();
		yourStore = new YourStore(driver);
		Thread.sleep(1000);
		accountLogin = yourStore.navigateToLoginPage();
		Thread.sleep(1000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
