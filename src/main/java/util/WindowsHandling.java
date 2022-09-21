package util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.Base;

public class WindowsHandling extends Base {
	public WebDriver driver;
	public boolean flag = false;

	public boolean switchToWindowWithTitleAs(String expectedTitle) throws InterruptedException, IOException {

		driver = initializeDriver();
		// It will return the parent window name as a String
		String parentWinID = driver.getWindowHandle();
		System.out.println("Parent Win ID is: " + parentWinID);
		// It returns no. of windows opened by WebDriver and will return Set of Stringss
		driver.findElement(By.linkText("SeleniumTutorial")).click();
		driver.findElement(By.linkText("Open a popup window")).click();

		Set<String> allWinID = driver.getWindowHandles();
		System.out.println("Total Window size:" + allWinID.size());
		System.out.println("All win IDs are:");
		for (String allIDs : allWinID) {
			System.out.println(allIDs);
		}

		// Using Iterator to iterate with in windows and print the window url which
		// matches expected window title
		Iterator<String> itr = allWinID.iterator();
		while (itr.hasNext()) {
			String childWinID = itr.next();
			// Compare whether the main window is not equal to child window. If not equal,
			// we will close child windows.
			if (!parentWinID.equalsIgnoreCase(childWinID)) {
				driver.switchTo().window(childWinID);

				if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
					System.out.println("Child URL is:" + driver.getCurrentUrl());
					System.out.println("Child Win Title is:" + driver.getTitle());
					System.out.println("Switched to " + expectedTitle);
					flag = true;
					break;
				}
				Thread.sleep(2000);
				driver.close();
			}
		}

		return flag;
	}

	public boolean switchToRequiredWindowAfterMultipleWindowsAreAlredyOpenWithTitlAs(String expectedTitle,
			String parentTitle, WebDriver driver) throws InterruptedException, IOException {
		String requiredWindow = null;

		Set<String> allWinID = driver.getWindowHandles();
		System.out.println("Total Window size:" + allWinID.size());
		System.out.println("All win IDs are:");
		for (String allIDs : allWinID) {
			System.out.println(allIDs);
		}
		// Using Iterator to iterate with in windows and print the window url which
		// matches expected window title
		Iterator<String> itr = allWinID.iterator();
		while (itr.hasNext()) {
			String childWinID = itr.next();

			driver.switchTo().window(childWinID);

			if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
				System.out.println("Child URL is:" + driver.getCurrentUrl());
				System.out.println("Child Win Title is:" + driver.getTitle());
				System.out.println("Switched to " + expectedTitle);
				requiredWindow = childWinID;
				continue;
			}
			// the below statement makes sure that main window is not closed
			if (!driver.getTitle().equalsIgnoreCase(parentTitle)) {
				Thread.sleep(2000);
				driver.close();

			}

		}

		try {
			driver.switchTo().window(requiredWindow);
			System.out.println("Switched to window " + expectedTitle);
			flag = true;
			return flag;
		} catch (Exception e) {
			System.out.println("Window with title " + expectedTitle + " not found");
			// since window not found we will switch to main window
			driver.switchTo().defaultContent();
			flag = false;
			return flag;
		}

	}

	// reusable method to switch to main window / default window
	public boolean switchingToMainWindow(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Switched to main window");
			} else if (!flag) {
				System.out.println("Unable to switch to main window");
			}
		}
	}

	// reusable method to switch to frame using index
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index " + index + " is selected");
			} else {
				System.out.println("Frame with index " + index + " is not selected");
			}
		}
	}

//reuable method to switch to frame using id value
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id " + idValue + " is selected");
			} else {
				System.out.println("Frame with Id " + idValue + " is not selected");
			}
		}
	}

	
//reusable method to switch to frame using name
	public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name " + nameValue + " is selected");
			} else if (!flag) {
				System.out.println("Frame with Name " + nameValue + " is not selected");
			}
		}
	}
	
	
	
	public boolean mouseOverElementClick(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).click().build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
				return flag;
			} else {
				System.out.println("MouseOver action is not performed on");
				return flag;
			}
		}
	}
	
	
	public boolean mouseOverElementOnly(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
				return flag;
			} else {
				System.out.println("MouseOver action is not performed on");
				return flag;
			}
		}
	}
	
	
	
	
	
	
	
	
}
