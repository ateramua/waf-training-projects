package com.qmetry.qaf.w3schools.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.Utility.Constants;
import com.qmetry.qaf.Utility.Utilities;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.annotations.PageIdentifier;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class W3schoolWebTablePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	Constants cons = new Constants();

	//table[@id='customers']
	
	@PageIdentifier
	@FindBy(locator="xpath=	//table[@id='customers']")
	public WebElement customerTable;

    public static void clearBrowserCache(WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            
            // Execute JavaScript to clear the browser cache
            jsExecutor.executeScript("window.location.reload(true);");
        } else {
            System.out.println("Warning: WebDriver does not support JavaScript execution.");
        }
    }

	
	public void invoke() {
		launchPage(null);
	}
	
	public QAFExtendedWebDriver getDriver() {
		return ((QAFExtendedWebDriver) getTestBase().getDriver());
	}
	
	public void waitForPageToLoad() {
	    super.waitForPageToLoad();
	}
	

	
	
	public void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
		clearBrowserCache(getDriver());
		driver.manage().deleteAllCookies();
		
		
	}
	
	public Map<String, String> saveTableRowData(int rowNumber, WebElement table, String rowsXpath, String columnName[]) {
		
		List<WebElement> rows = table.findElements(By.xpath(rowsXpath));
	//	String columnName [] = {"Company","Contact","Country"};
		int rowIndex = rowNumber;
		Map<String,String> rowValues = new HashMap<String, String>();
		WebElement row = rows.get(rowIndex);
		Reporter.log(" Does the row in question exists ********************************************** " + row.isDisplayed());
		
		
		List<WebElement> cells = row.findElements(By.tagName("td"));
		Reporter.log(" CELL size is "+ cells.size());
		
		

		for(int y=0;y<cells.size();y++) {
			rowValues.put(columnName[y], cells.get(y).getText().trim());
			Reporter.log("Column Value Pairs are " + columnName[y] + "," + cells.get(y).getText().trim());
		}
		//ConfigurationManager.getBundle().addProperty("storedValue", rowValues);
		
	//	Map<String, Map<String,String>>storedValueIs = new HashMap<>();
	//	storedValueIs.put("storedValue",rowValues);
		//ConfigurationManager.getBundle().setProperty("storedValue", rowValues);
		return rowValues;
	}
	
	/*
	 * Method - returns column index numbers for specified column names
	 */
			
	public static ArrayList<Integer> getColmnNameIndex(String colName[], WebElement table) {
		ArrayList<Integer> columnIndex = new ArrayList<Integer>();
		List<WebElement> header = table.findElements(By.tagName("th"));
		for(int i=0;i<header.size();i++) {	
				String headerText = header.get(i).getText();
			for(String ele:colName) {
				if(headerText.contains(ele)) {
					columnIndex.add(i);
					break;
				}
			}
		}
		return columnIndex;
	}
	
	/*
	 * Method - creates column name and value pair for a given row
	 */
	public static Map<String, String> getCellValues(WebElement table, String rowXpath, int rowNumber, int columnIndex) {
		
		Map<String, String> mapData = new HashMap<String, String>();
		List<WebElement> rows = table.findElements(By.xpath(rowXpath));
		WebElement row = rows.get(rowNumber);
		List<WebElement> cells = row.findElements(By.tagName("td"));
		for(WebElement cell:cells) {
			List<WebElement> header = table.findElements(By.tagName("th"));
			String cellValue = cells.get(columnIndex).getText();		
			mapData.put(header.get(columnIndex).getText(), cellValue);
		}
		
		return mapData;
	}
	
	
}
