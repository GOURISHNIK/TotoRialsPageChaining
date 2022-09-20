package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountLogin;
import pageobjects.MyAccount;
import pageobjects.YourStore;
import resources.Base;

public class MyAccountTest extends Base {
	public WebDriver driver;
	public YourStore yourStore;
	public AccountLogin accountLogin;
	public MyAccount myAccount;

	@Test(priority = 0)
	public void MyAccountTitleValidation() {
		String myAccountTitle1 = myAccount.getMyAccountTitle();
		System.out.println(myAccountTitle1);
		Assert.assertEquals(myAccountTitle1,prop.getProperty("myAccountTitleExpected"));
	}
	

	@BeforeMethod(groups={"smoke"})
	public void setUp() throws IOException, InterruptedException {
		driver = initializeDriver();
		yourStore = new YourStore(driver);
		Thread.sleep(1000);
		accountLogin = yourStore.navigateToLoginPage();
		Thread.sleep(1000);
		myAccount=accountLogin.loginFunctionality(prop.getProperty("email12"), prop.getProperty("password12"));
		Thread.sleep(2000);

	}

	@AfterMethod(groups={"smoke"})
	public void tearDown() {
		driver.quit();

	}

}
