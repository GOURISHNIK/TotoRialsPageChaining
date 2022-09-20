package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountLogin;
import pageobjects.YourStore;
import resources.Base;

public class YourStoreTest extends Base {
	public WebDriver driver;
	public YourStore yourStore;
	AccountLogin accountLogin;

	@Test(priority = 0)
	public void yourStoreTitleValidation() {
		String yourStoreTitle1 = yourStore.getYourStoreTitle();
		Assert.assertEquals(yourStoreTitle1, prop.getProperty("yourStoreTitleDp"));
	}

	@Test(priority = 1)
	public void navigateToLoginPageValidation() {
		accountLogin=yourStore.navigateToLoginPage();
		String accountLoginTitle1 = accountLogin.getAccountLoginTitle();
		Assert.assertEquals(accountLoginTitle1, prop.getProperty("accountLoginTitleDp"));
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeDriver();
		yourStore = new YourStore(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
