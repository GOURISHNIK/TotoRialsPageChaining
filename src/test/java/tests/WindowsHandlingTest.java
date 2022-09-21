package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.YourStore;
import resources.Base;
import util.WindowsHandling;

public class WindowsHandlingTest extends WindowsHandling {

	public WebDriver driver;

	@Test
	public void switchToWindowHandle() throws InterruptedException, IOException {
		System.out.println("switched");
		boolean statusOfFlag = switchToWindowWithTitleAs("Selenium14");
		Assert.assertTrue(statusOfFlag, "assert is for switching to Selenium143");

	}

	@Test
	public void swithToAlredyOpenedWindows() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.findElement(By.linkText("SeleniumTutorial")).click();
		
		switchToRequiredWindowAfterMultipleWindowsAreAlredyOpenWithTitlAs("Selenium143", "omayo (QAFox.com)", driver);
		
		

	}
	
	@Test
	public void mouseAcctionMovingAndClickingElement() throws IOException {
		driver=initializeDriver();
		YourStore yourStore = new YourStore(driver);
		yourStore.popUpLinkClick();
		
		
	}

	/*
	 * @Test public void windowsHandling1() throws InterruptedException, IOException
	 * {
	 * 
	 * driver=initializeDriver(); // It will return the parent window name as a
	 * String String parentWinID = driver.getWindowHandle();
	 * System.out.println("Parent Win ID is: " + parentWinID); // It returns no. of
	 * windows opened by WebDriver and will return Set of Strings Actions a =new
	 * Actions(driver);
	 * 
	 * driver.findElement(By.linkText("SeleniumTutorial")).click();
	 * driver.findElement(By.linkText("Open a popup window")).click();
	 * 
	 * Set<String> allWinID = driver.getWindowHandles();
	 * System.out.println("Total Window size:" +allWinID.size());
	 * System.out.println("All win IDs are:"); for (String allIDs : allWinID) {
	 * System.out.println(allIDs); }
	 * 
	 * 
	 * // Using Iterator to iterate with in windows and print the window url which
	 * matches expected window title Iterator<String> itr = allWinID.iterator();
	 * while (itr.hasNext()) { String childWinID = itr.next(); // Compare whether
	 * the main window is not equal to child window. If not equal, we will close
	 * child windows. if(!parentWinID.equalsIgnoreCase(childWinID)) {
	 * driver.switchTo().window(childWinID);
	 * 
	 * if(driver.getTitle().equalsIgnoreCase("Selenium143")) {
	 * System.out.println("Child URL is:"+driver.getCurrentUrl());
	 * System.out.println("Child Win Title is:"+driver.getTitle()); }
	 * Thread.sleep(2000); driver.close(); } } // This is to switch to the main
	 * window driver.switchTo().window(parentWinID);
	 * //driver.switchTo().defaultContent(); driver.quit();
	 * 
	 * }
	 */

}
