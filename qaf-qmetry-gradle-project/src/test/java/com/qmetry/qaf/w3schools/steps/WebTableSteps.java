package com.qmetry.qaf.w3schools.steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;
import com.qmetry.qaf.Utility.Constants;
import com.qmetry.qaf.Utility.Utilities;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.w3schools.page.W3schoolWebTablePage;

public class WebTableSteps extends WebDriverTestCase {
	W3schoolWebTablePage w3 = new W3schoolWebTablePage();
	Constants cons = new Constants();
	//Test
	
	@QAFTestStep(description = "user is on w3school home page")
	public void navToW3SchoolsHome() throws InterruptedException {
		w3.openPage(null, "");
		Reporter.log("Don't worry I am on W3school Home Page *****************************");
		
	}
	
	@QAFTestStep(description = "Verify Chrome driver")
	public void validateBrowsers() throws InterruptedException {
		w3.openPage(null, "");
		Thread.sleep(10000);
		
	}
	
	
	
	
	
	@QAFTestStep(description = "user stores row {rowNumber} data in key {storedValue}")
	public Map<String, String> saveRowValuesInMap(int rowNumber,String storedValue) throws InterruptedException {
	w3.waitForPageToLoad();
		
		Reporter.log("Page loaded successfully");
		Thread.sleep(10000);
		Utilities.scrollIntoView(getDriver(),w3.customerTable);
		w3.customerTable.isDisplayed();
		Reporter.log(" is the Customer table Displayed ? " + w3.customerTable.isDisplayed());
		
		List<WebElement> rows = w3.customerTable.findElements(By.xpath(cons.tableRows));
		//	String columnName [] = {"Company","Contact","Country"};
			int rowIndex = rowNumber;
			Map<String,String> rowValues = new HashMap<String, String>();
			WebElement row = rows.get(rowIndex);
			Reporter.log(" Does the row in question exists ********************************************** " + row.isDisplayed());
			
			
			List<WebElement> cells = row.findElements(By.tagName("td"));
			Reporter.log(" CELL size is "+ cells.size());
			
			

			for(int y=0;y<cells.size();y++) {
				rowValues.put(Constants.columnName[y], cells.get(y).getText().trim());
				Reporter.log("Column Value Pairs are " + Constants.columnName[y] + "," + cells.get(y).getText().trim());
			}
			
			
			Reporter.log(" is the map data empty - line 65 " +rowValues.isEmpty());
			
			ConfigurationManager.getBundle().setProperty(storedValue, rowValues);
			return rowValues;
			
		//	Map<String, String> lolest = rowValues.entrySet();
	}
		
	
	//Store row values
	
	@QAFTestStep(description = "user saves row {rowNumber} values in hashmap and stores them in a keyy {storedValue}")
	public  String saveRowOneValuesInMap(int rowNumber,String storedValue) throws InterruptedException {
		
		//Valdiate Table Exists
		w3.waitForPageToLoad();
		
		Reporter.log("Page loaded successfully");
		
		Thread.sleep(10000);
		Utilities.scrollIntoView(getDriver(),w3.customerTable);
//		w3.customerTable.isDisplayed();
//		Reporter.log(" is the Customer table Displayed ? " + w3.customerTable.isDisplayed());
		
		
		//Update
//		List<WebElement> rows = w3.customerTable.findElements(By.xpath(cons.tableRows));
//		String columnName [] = {"Company","Contact","Country"};
//		int rowIndex = 6;
//		Map<String, String> rowValues = new HashMap<String, String>();
//		WebElement row = rows.get(rowIndex);
//		Reporter.log(" Does the row in question exists ********************************************** " + row.isDisplayed());
//		List<WebElement> cells = row.findElements(By.tagName("td"));
//		Reporter.log(" CELL size is "+ cells.size());
		
		WebElement table = w3.customerTable;
		String rowXpath = cons.tableRows;
		String [] colName = cons.columnName;
		
		Map<String, String> rowData = w3.saveTableRowData(rowNumber, table, rowXpath, colName);
		
		List<WebElement> rows = w3.customerTable.findElements(By.xpath(cons.tableRows));
		//	String columnName [] = {"Company","Contact","Country"};
			int rowIndex = rowNumber;
			Map<String,String> rowValues = new HashMap<String, String>();
			WebElement row = rows.get(rowIndex);
			Reporter.log(" Does the row in question exists ********************************************** " + row.isDisplayed());
			
			
			List<WebElement> cells = row.findElements(By.tagName("td"));
			Reporter.log(" CELL size is "+ cells.size());

			for(int y=0;y<cells.size();y++) {
				rowValues.put(Constants.columnName[y], cells.get(y).getText().trim());
				Reporter.log("Column Value Pairs are " + Constants.columnName[y] + "," + cells.get(y).getText().trim());
			}

		Reporter.log(" is the map data empty " +rowValues.isEmpty());
//		
		ConfigurationManager.getBundle().setProperty(storedValue, rowValues);

		return storedValue;
	}
	
	
	
	//verfies column value for given column name
	@QAFTestStep(description = "verfies column value for given column name from map {storedValue}")
	public void validateColumnValue(String storedValue) {

		Map<String, String> rowValueStored = (Map<String, String>)ConfigurationManager.getBundle().getProperty(storedValue);
		String contact = rowValueStored.get("Contact");
		Reporter.log(contact + "********************************************");
	    //Map<String, String> retrievedTestData = (Map<String, String>) ConfigurationManager.getBundle().getObject(storedValue);
	//	String c = ConfigurationManager.getBundle().getPropertyValue(storedValue).toString();
	//	Validator.assertTrue(firstColumnValue.equalsIgnoreCase("Centro comercial Moctezuma"), "First Column storedis not 'Centro comercial Moctezuma'", "First Column storedis 'Centro comercial Moctezuma'");
	}
	
	@QAFTestStep(description = "store values")
	public void toStore() {
		//String a = "Test";
		
		Map<String, String> mapData = new HashMap<String,String>();
		mapData.put("Name", "Abdi");
		mapData.put("Age", "39");
		Gson gson = new Gson();
		String d = gson.toJson(mapData);
		//Reporter.log("This is the string value that I want to print ************* " + d);
		//ConfigurationManager.getBundle().setProperty("b", d);
		ConfigurationManager.getBundle().setProperty("b", mapData);
	}
	
	@QAFTestStep(description = "retreive stored values")
	public void retreiveStore() {
		//String c = (String)ConfigurationManager.getBundle().getProperty("b");
		//Reporter.log(c);
		//Gson gson = new Gson();
		Map<String, String> myMap = (Map<String,String>)ConfigurationManager.getBundle().getProperty("b");
		
//		Map<String, String> myMap = gson.fromJson(c, Map.class);
		   for (Map.Entry<String, String> entry : myMap.entrySet()) {
	            String key = entry.getKey();
	            String value = entry.getValue();
	            System.out.println("Key: " + key + ", Value: " + value);
	            Reporter.log("Key: " + key + ", Value: " + value);
	        }
		Reporter.log("This will tell you if the map is empty ********************" + myMap.isEmpty());
	}
	
//	@QAFTestStep(description = "header row {rowNumber}")
//	public void getHeaderRow(int rowNumber) {
//		//colIndex list of column name and their index
//
//		String c [] = {"Company","Country"};
//		List<WebElement> header = w3.customerTable.findElements(By.tagName("th"));
//		Map<Integer, String> colIndex = new HashMap<Integer,String>();
//		ArrayList<Integer> bList = new ArrayList<Integer>();
//		Map<String, String> mapData = new HashMap<String, String>();
//		
//
//		for(int i=0;i<header.size();i++) {	
//				String headerText = header.get(i).getText();
//			for(String ele:c) {
//				if(headerText.contains(ele)) {
//					bList.add(i);
//					colIndex.put(i, ele);
//					
//					List<WebElement> rows = w3.customerTable.findElements(By.xpath(cons.tableRows));
//					WebElement row = rows.get(rowNumber);
//					List<WebElement> cells = row.findElements(By.tagName("td"));
//					for(WebElement cell:cells) {
//						String cellValue = cells.get(i).getText();		
//						mapData.put(ele, cellValue);
//					}
//					break;
//			}
//		}
// 
//		 for (Entry<String, String> entry : mapData.entrySet()) {
//	            String key = entry.getKey();
//	            String value = entry.getValue();
//	            Reporter.log("Key: " + key + ", Value: " + value);
//	     }	
//		
//}
//		
//		
// 
//		
//	}
	
	@QAFTestStep(description = "header row {rowNumber}")
	public void getHeaderRow(int rowNumber) {
		
		String []columnName = {"Company","Contact"};
		ArrayList<Integer> indexList = w3.getColmnNameIndex(columnName,w3.customerTable);
		
		for(Integer ele:indexList) {
			
			Map<String, String> columnValuePair = w3.getCellValues(w3.customerTable,cons.tableRows,rowNumber, ele);
			 for (Entry<String, String> entry : columnValuePair.entrySet()) {
			        String key = entry.getKey();
			        String value = entry.getValue();
			        Reporter.log("Key: " + key + ", Value: " + value);
			 }
		}

 
	}
	
	@QAFTestStep(description = "get header rows and store in map")
	public void getHeaderRowAndSaveInMap(int rowNumber) {
		Map<String,String> rowValues = new HashMap<String, String>();
		String columnName [] = {"Company","Country",""};
		//Column name required
	 	//Find all rows
		List<WebElement> rows = w3.customerTable.findElements(By.xpath(cons.tableRows)); 
		int rowIndex = rowNumber;
		//Find specific row
		WebElement row = rows.get(rowIndex);
		List<WebElement> cells = row.findElements(By.tagName("td"));
		for(int i=0;i<cells.size();i++) {		
			String cellValue = cells.get(i).getText().trim();
			rowValues.put(columnName[i], cellValue);
		}
		
		 for (Entry<String, String> entry : rowValues.entrySet()) {
	            String key = entry.getKey();
	            String value = entry.getValue();
	            //System.out.println("Key: " + key + ", Value: " + value);
	            Reporter.log("Key: " + key + ", Value: " + value);
	     }
	}
	
	
	
}
