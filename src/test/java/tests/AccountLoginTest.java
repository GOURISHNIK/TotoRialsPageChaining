package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountLogin;
import pageobjects.MyAccount;
import pageobjects.YourStore;
import resources.Base;
import util.Excel;

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

	@Test(priority = 1 , dataProvider = "gettingExcelData",groups={"smoke"})
	public void accountLoginFunctionalityValidation(String uname,String passwd, String status) throws InterruptedException {
		//System.out.println(uname+"  "+passwd);
		//myAccount = accountLogin.loginFunctionality(prop.getProperty("email12"), prop.getProperty("password12"));
		myAccount=accountLogin.loginFunctionality(uname, passwd);
		Thread.sleep(3000);
		//Assert.assertEquals(myAccount.getMyAccountTitle(), prop.getProperty("myAccountTitleExpected"),"Invalid Login");
		Assert.assertEquals(myAccount.getMyAccountTitle(),status);
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] gettingExcelData() throws IOException {
		Object[][] data = Excel.getTestData("Sheet1");
		return data;
		
	}

	@BeforeMethod(groups={"smoke"})
	public void setUp() throws IOException, InterruptedException {
		driver = initializeDriver();
		yourStore = new YourStore(driver);
		Thread.sleep(1000);
		accountLogin = yourStore.navigateToLoginPage();
		Thread.sleep(1000);

	}

	@AfterMethod(groups={"smoke"})
	public void tearDown() {
		driver.quit();

	}
}
