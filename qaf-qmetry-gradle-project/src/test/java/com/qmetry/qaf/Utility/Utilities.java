package com.qmetry.qaf.Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.delta.page.BookingPage;
import com.qmetry.qaf.w3schools.page.W3schoolWebTablePage;

public class Utilities extends WebDriverTestCase {
	W3schoolWebTablePage w3 = new W3schoolWebTablePage();
	
	/*
	 * Method - Scroll to the Element and Click
	 */
	public static void scrollAndClick(QAFExtendedWebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Reporter.log(element.isDisplayed()+ " element is displayed ");
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static void scrollIntoView(QAFExtendedWebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	


	public static void removeHiddenAttribute(QAFExtendedWebDriver driver, QAFWebElement element) {
	
		driver.executeScript("arguments[0].removeAttribute('hidden');", element);
		
	}
	
	public static void doubleClickOnAnElement(WebElement element,QAFExtendedWebDriver driver) {
		 Actions actions = new Actions(driver);
	     actions.doubleClick(element).perform();
	}
	
	
	public static void switchToNewTab(QAFExtendedWebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>();
		Reporter.log(tabs.size() + " How many tabs are open");
		driver.switchTo().window(tabs.get(1));
	}
	

	
	/*
	 * Method - select from dropdown
	 */
	public static void selectFromDropdown(WebElement dropDown, String dropDownValue, String xpath) {
		List<WebElement> ddList = dropDown.findElements(By.xpath(xpath));
		for(WebElement ele:ddList) {
			if(ele.getText().trim().contains(dropDownValue)) {
				ele.click();
				Reporter.log(ele.getText()+" Selected from the dropdown");		
			}
		}
	
	}

}
