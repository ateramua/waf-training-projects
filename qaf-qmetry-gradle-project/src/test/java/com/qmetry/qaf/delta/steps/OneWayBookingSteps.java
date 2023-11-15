package com.qmetry.qaf.delta.steps;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qmetry.qaf.Utility.Utilities;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.AbstractTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.delta.page.BookingPage;

import ch.qos.logback.classic.pattern.Util;


public class OneWayBookingSteps {
	BookingPage bookingpage = new BookingPage();
	Utilities util = new Utilities();
	
	
	@QAFTestStep(description = "User is on Kayak Booking Page")
	public void navigateToKayakBookingPage() {
		bookingpage.openPage(null, "");
		bookingpage.waitForPageToLoad();
		bookingpage.getTopSignInButton().waitForPresent(100000);
		Validator.assertTrue(bookingpage.getTopSignInButton().isDisplayed(), "User failed to navigate to Kayak Booking page", "User successfully navigated to Kayak Booking Page");
	}
	
	
	
	
	
	/*
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	*/
	
	/*
	@Before
	public void setup() {
		
	
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
	}
*/





	@QAFTestStep(description = "User is on Delta Booking Page")
	public void navigateToDeltaBookingPage() {
		//test = extent.createTest("Validate user can navigate to Delta Booking Page");
		BookingPage bookingpage = new BookingPage();
		bookingpage.openPage(null, "");
		Validator.assertTrue(bookingpage.getBook().isDisplayed(), "User failed to navigate to Booking Page", "User successfully navigated to booking page");
		Reporter.log(bookingpage.getBook().getText() + " This is what book web element reads");
	}
	
	@QAFTestStep(description = "User is on United Booking Page") 
	public  void userSelectsOneWayTrip() {
		BookingPage bookingpage = new BookingPage();
		bookingpage.getOneWay().click();
	}


	@QAFTestStep(description = "User clicks on From Test")
	public void clickTest(){
		bookingpage.getFrom().waitForPresent(10000);
		Reporter.log(bookingpage.getFrom().isEnabled() + " is enabled ");
		Reporter.log(bookingpage.getFrom().isDisplayed()+ " is displayed");
		Reporter.log(bookingpage.getFrom().isPresent() + " is present");
	}
	
	@QAFTestStep(description = "User clicks on From Link")
	public void userClickOnFromLink(){
		//Utilities.scrollAndClick(bookingpage.getDriver(), bookingpage.getFrom());
		Reporter.log(bookingpage.getTest().getText() + " web element reads");
		bookingpage.getFrom().click();
		bookingpage.getAirPortSearchTextBox().waitForPresent(10000);
		Validator.assertTrue(bookingpage.getAirPortSearchTextBox().isPresent(), "Script failed to click on From Link", "Script successfully clicked on From Link");
	}

	@QAFTestStep(description = "User enters departure airport {dAirPort}")
	public void clickOnFromLink(String dAirPort) throws InterruptedException {
		//test = extent.createTest("Validate User can click on From Link");
		bookingpage.getAirPortSearchTextBox().waitForEnabled(4000);
		bookingpage.getAirPortSearchTextBox().clear();
		bookingpage.getAirPortSearchTextBox().sendKeys(dAirPort);
//		bookingpage.getAirPortSearchTextBox().sendKeys(Keys.ENTER);
//		Reporter.log(bookingpage.getFrom().getText() + "***************************************");
		Validator.assertTrue(bookingpage.getAirPortSearchTextBox().getAttribute("value").equalsIgnoreCase(dAirPort), "User failed to enter Origin Airport", "User successfully entered Origin Airport");
	}

	@QAFTestStep(description = "User selects departure airport {dAirPort} from search results")
	public void selectDepartureAirportFromList(String dAirPort) throws InterruptedException {
		//test = extent.createTest("Validate user can select departure airport from the airport List");


		String xpathh = "//li[contains(@class,'airport-list')]";
		Reporter.log(bookingpage.getAllAirports().isDisplayed()+ " is it displayed");
		Reporter.log(bookingpage.getAllAirports().isEnabled()+ " is it Enabled");
		
	//	Utilities.selectFromDropdown(bookingpage.getAllAirports(), dAirPort, xpathh);
		

		List<WebElement> ddList = bookingpage.getDriver().findElements(By.xpath(xpathh));
//		Thread.sleep(6000);
//		Reporter.log(ddList + "  departure airport list *************");
//		Reporter.log(ddList.size() + "  departure airport list *************");
		int y=0;
		for(int i=0;i<ddList.size();i++) {
			if(ddList.get(i).getText().trim().contains(dAirPort)) {
			y=i;
			}
		}
		Utilities.scrollAndClick(bookingpage.getDriver(), ddList.get(y));
		//ddList.get(y).click();
	

//		for(WebElement ele:ddList) {
//			//Reporter.log(ele.getText()+ "  All airport lists from the dropdown *************");
//			
//			if(ele.getText().trim().contains(dAirPort)) {
				
				
//				Reporter.log(ddList + "  departure airport list *************");
//				Reporter.log(ddList.size() + "  departure airport list *************");
//				ele.sendKeys(Keys.RETURN);
//				ele.click();
//				Reporter.log(ele.isEnabled() + "  is the element present *************");
//				ele.click();
////				Utilities.doubleClickOnAnElement(ele,bookingpage.getDriver());
//				Reporter.log(ele.getText()+" Selected from the dropdown");			
//			} else {
//				Reporter.log(" Airport could not be found ");
//			}
//		}
//		bookingpage.getHeaderBooking().click();
//		
//		Utilities.scrollIntoView(bookingpage.getDriver(), bookingpage.getFrom());
//		Thread.sleep(10000);
//		
//		
//		
//		
//
//		Thread.sleep(10000);
	//	Reporter.log(bookingpage.getFrom().getText() + " is the Airport Selected");
		Assert.assertTrue(bookingpage.getFrom().getText().contains(dAirPort));
		//Validator.assertTrue(bookingpage.getFrom().getText().contains(dAirPort), "fail*********************", "pass************************");
		   try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	            Reporter.log(e + " what is this error message saying ");
	        }
	}

	@QAFTestStep(description = "User clicks on To link")
	public void clickOnToLink() {
		//test = extent.createTest("Validate user can click on 'To' link");
		bookingpage.getTo().click();

	}

	@QAFTestStep(description = "User enters destination airport {aAirPort}")
	public void enterDestinationAirport(String aAirPort) {
		//test = extent.createTest("Validate user can enter destination airport");

	}

	@QAFTestStep(description = "User selects destination airport from search results")
	public void selectDestinationAirportFromList() {
		//test = extent.createTest("Validate user can select destination airport from the list");

	}

	@QAFTestStep(description = "user selects one way trip")
	public void selectOneWayTrip() throws InterruptedException {

	//	bookingpage.getTxtBoxTrip().click();

		bookingpage.getOneWay().click();
		Validator.assertTrue(!bookingpage.getOneWaySelected().getAttribute("checked").isEmpty(), "User failed to select One Way Radio Button", "User successfully selected One Way Radio Button");
	}
	
	@QAFTestStep(description = "User clicks on Trip type dropdown")
	public void selectTripTypee() throws InterruptedException {

		bookingpage.getTxtBoxTrip().click();

		Validator.assertTrue(bookingpage.getDropDownTrip().isDisplayed(), "User failed to click on Trip down", "User successfully clicked on Trip Down");
	}
	
	@QAFTestStep(description = "User SELAM NEW")
	public void selectLwbQ() {
		Reporter.log("User SELAM NEW");
	}

	@QAFTestStep(description = "User selects departure date '02/05/2022'")
	public void selectDepartureDate() {

	}

	@QAFTestStep(description = "User selects number of passenger '2'")
	public void selectNumberOfPassenger() {

	}

	@QAFTestStep(description = "User clicks on search button")
	public void clickOnSearchButton() {

	}

	@QAFTestStep(description = "list of flights should generate")
	public void generateListOfFlights() {

	}



}
