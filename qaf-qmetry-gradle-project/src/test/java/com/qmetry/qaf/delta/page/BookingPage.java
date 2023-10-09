package com.qmetry.qaf.delta.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.annotations.PageIdentifier;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class BookingPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'link=BOOK';'desc':'Header of Page'}")
	QAFWebElement book;
	public QAFWebElement getBook() {
	 return book;
	}
	
	//*[@id="fromAirportName"]/span[1]
	//span[text()="Departure Airport or City"]
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'xpath=//*[@id='fromAirportName']/span[3]';'desc':'From Link'}")
	//*[@id='fromAirportName']/span[3]
	//@FindBy(locator = "{'locator':['css=#fromAirportName';'id=fromAirportName';'xpath=.//a[@id=\'fromAirportName\']/span[1]'];'desc':'From Link'}")
	QAFWebElement from;
	public QAFWebElement getFrom() {
	 return from;
	}
	
	@PageIdentifier 
	//*[@id='search_input']
	@FindBy(locator = "{'locator':'xpath=//*[@id='search_input']';'desc':'Airport Search TextBox'}")
	QAFWebElement airPortSearchTextBox;
	public QAFWebElement getAirPortSearchTextBox() {
	 return airPortSearchTextBox;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.header';'desc':'Header of Page'}")
	QAFWebElement to;
	public QAFWebElement getTo() {
	 return to;
	}
	
	
	
//	@PageIdentifier 		
	@FindBy(locator = "{'locator':'css=#selectTripType-val';'desc':'trip button'}")
	QAFWebElement getTextBoxTrip;
	public QAFWebElement getTxtBoxTrip() {
	 return getTextBoxTrip;
	}
	

	
	@FindBy(locator = "{'locator':'css=#selectTripType-desc';'desc':'trip dropdown'}")
	QAFWebElement dropDownTrip;
	public QAFWebElement getDropDownTrip() {
	 return dropDownTrip;
	}

	@PageIdentifier 
	@FindBy(locator = "{'locator':'xpath=//*[@id=\"booking\"]//span[1]/span[1])[1]';'desc':'Round'}")
	QAFWebElement round;
	public QAFWebElement getRound() {
	 return round;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'xpath=//li[@id='ui-list-selectTripType1']';'desc':'One Way'}")
	QAFWebElement oneWay;
	public QAFWebElement getOneWay() {
	 return oneWay;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'xpath=//li[@id='ui-list-selectTripType1']';'desc':'Multi-City'}")
	QAFWebElement multiCity;
	public QAFWebElement getMultiCity() {
	 return multiCity;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.calenderDepartSpan';'desc':'depart'}")
	QAFWebElement depart;
	public QAFWebElement getDepart() {
	 return depart;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=#ui-list-passengers0;'desc':'1 Passenger'}")
	QAFWebElement onePassenger;
	public QAFWebElement selectOnePassenger() {
	return onePassenger;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers1';'desc':'2 Passengers'}")
	QAFWebElement twoPassengers;
	public QAFWebElement selectTwoPassengers() {
	return twoPassengers;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers2';'desc':'3 Passengers'}")
	QAFWebElement threePassengers;
	public QAFWebElement selectThreePassengers() {
	return threePassengers;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers3';'desc':'4 Passengers'}")
	QAFWebElement fourPassengers;
	public QAFWebElement selectFourPassengers() {
	return fourPassengers;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers4';'desc':'5 Passengers'}")
	QAFWebElement fivePassengers;
	public QAFWebElement selectFivePassengers() {
	return fivePassengers;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers5';'desc':'6 Passengers'}")
	QAFWebElement sixPassengers;
	public QAFWebElement selectSixPassengers() {
	return sixPassengers;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers6';'desc':'7 Passengers'}")
	QAFWebElement sevenPassengers;
	public QAFWebElement selectSevenPassengers() {
	return sevenPassengers;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers7';'desc':'8 Passengers'}")
	QAFWebElement eightPassengers;
	public QAFWebElement selectEightPassengers() {
	return eightPassengers;
	}
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'css=.#ui-list-passengers8';'desc':'9 Passengers'}")
	QAFWebElement ninePassengers;
	public QAFWebElement selectNinePassengers() {
	return ninePassengers;
	}
	
	
	@PageIdentifier 
	@FindBy(locator = "{'locator':'xpath=//*[text()='I UNDERSTAND']';'desc':'I Understand'}")
	QAFWebElement btnUnderstand;
	public QAFWebElement getButtonUnderstand() {
	return btnUnderstand;
	}
	
	public void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		clearBrowserCache(getDriver());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
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
	
	
	//#ui-list-passengers1
	
}
	
/*
	QAFExtendedWebDriver driver;
	
	//ExtentTest test;
	//ExtentReports extent = ExtentFactory.getInstance();
	
	
  	//ExtentTest test
	public bookPage(QAFWebDriver driver) {
		this.driver = driver;
		//this.test = test;
	}
	
	
	public void clickOnBook() {
		
		QAFWebElement Book = driver.findElement(By.xpath("//a[@id='headPrimary1']"));
		Assert.assertTrue(Book.isDisplayed());
		//test.log(Status.PASS, "WebElement 'Book' is Present");
		Book.click();
		QAFWebElement ToR = driver.findElement(By.xpath("//span[contains(text(), 'Your Destination')]"));
		Assert.assertTrue(ToR.isDisplayed(), "Script failed to click on 'Book'");
		//test.log(Status.PASS, "Script have successfully clicked on 'Book' Tab");
	}
	
	public void clickonFromR() {
		QAFWebElement FromR = driver.findElement(By.xpath("//*[@id='fromAirportName']/span[3]"));
		Assert.assertTrue(FromR.isDisplayed());
		//test.log(Status.PASS, "WebElement 'From' is Present");
		FromR.click();
		QAFWebElement OriginAirport = driver.findElement(By.xpath("//*[@id='search_input']"));
		Assert.assertTrue(OriginAirport.isDisplayed(), "Script failed to click on 'From' Link");
		//test.log(Status.PASS, "Script have successfully clicked on 'From' Link");
	}
	
	public void clickonToR() {
		QAFWebDriverWait wait = new QAFWebDriverWait(driver , 20);
		QAFWebElement ToR = driver.findElement(By.xpath("//*[@id=\"toAirportName\"]/span[3]"));
		
	    // Wait for 'To' to be clickable
		ToR = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='toAirportName']/span[3]")));
		//span[contains(text(), 'Your Destination')]
		//Assert.assertTrue(ToR.isDisplayed());
		//test.log(Status.PASS, "WebElement 'To' is Present");
		ToR.click();
		QAFWebElement destAirport = driver.findElement(By.xpath("//*[@id='search_input']"));
		Assert.assertTrue(destAirport.isDisplayed(), "Script failed to click on 'To' Link");
		//test.log(Status.PASS, "Script have successfully clicked on 'To' Link");
	}
	
	
	public void enterOriginAirport(String origin) {
		QAFWebElement originAirport = driver.findElement(By.xpath("//*[@id='search_input']"));
		Assert.assertTrue(originAirport.isDisplayed());
		//test.log(Status.PASS, "Origin Airport TextBox is Present");
		originAirport.sendKeys(origin);
		originAirport.sendKeys(Keys.RETURN);
		originAirport.click();
		Assert.assertTrue(originAirport.isDisplayed());
		//test.log(Status.PASS, "Script entered Origin Airport Successfully");
	}
	
	public void enterdestAirport(String destination) {
		
		QAFWebElement destAirport = driver.findElement(By.xpath("//*[@id='search_input']"));
		Assert.assertTrue(destAirport.isDisplayed());
		//test.log(Status.PASS, "Destination Airport TextBox is Present");
		destAirport.sendKeys(destination);
		destAirport.sendKeys(Keys.RETURN);
		destAirport.click();
		Assert.assertTrue(destAirport.isDisplayed());
		//test.log(Status.PASS, "Script entered Destination Airport Successfully");

	}
	
	public void selectoriginAirportSearchResult() {
		QAFWebElement originAirportSearchResult = driver.findElement(By.cssSelector("span.col-sm-2"));
		QAFWebElement from = driver.findElement(By.xpath("//*[@id='fromAirportName']/span[1]"));
		Assert.assertTrue(originAirportSearchResult.isDisplayed(), "No Search Result is present for Origin Airport");
		//test.log(Status.PASS, "Origin Airport Search results is displayed");
		originAirportSearchResult.click();
		Assert.assertTrue(from.isDisplayed());
		//test.log(Status.PASS, "Script Selected Origin Airport Successfully");
		
		
		
		
		
	}
	public void selectDestAirportSearchResult() {
		QAFWebElement destAirportSearchResult = driver.findElement(By.cssSelector("span.col-sm-2"));
		QAFWebElement to = driver.findElement(By.xpath("//*[@id='toAirportName']/span[1]"));
		Assert.assertTrue(destAirportSearchResult.isDisplayed(), "No Search Result is present for Destination Airport");
		//test.log(Status.PASS, "WebElement 'Done' is Present in the Calendar picker");
		destAirportSearchResult.click();
		Assert.assertTrue(to.isDisplayed());
		//test.log(Status.PASS, "Script Selected Destination Airport Successfully");
	}
	
	public void clickOnTripType() {
		QAFWebElement tripType = driver.findElement(By.xpath("//*[@id='selectTripType-val']"));
		QAFWebElement RoundTrip = driver.findElement(By.cssSelector("li#ui-list-selectTripType0"));
		Assert.assertTrue(tripType.isDisplayed(), "Done Button is not Present");
		//test.log(Status.PASS, "WebElement 'tripType' is Present");
		tripType.click();
		Assert.assertTrue(RoundTrip.isDisplayed(), "Round Trip is displayed in the dropdown list");
		//test.log(Status.PASS, "Script Selected Destination Airport Successfully");
	}
	
	public void selectRoundTrip() {
		QAFWebElement refundFaresCheckBox = driver.findElement(By.cssSelector("input#refundableFlightsOnly"));
		QAFWebElement RoundTrip = driver.findElement(By.cssSelector("li#ui-list-selectTripType0"));
		Assert.assertTrue(RoundTrip.isDisplayed(), "Round Trip Selection is not Present");
		//test.log(Status.PASS, "WebElement 'RoundTrip' is Present");
		RoundTrip.click();
		Assert.assertTrue(refundFaresCheckBox.isDisplayed(), "Round Trip is still displayed in the dropdown list");
		//test.log(Status.PASS, "Script Selected Destination Airport Successfully");

	}
	
	public void selectDepartureDate() {
		QAFWebElement CalDoneButton = driver.findElement(By.cssSelector("button.donebutton"));
		QAFWebElement noDepDate = driver.findElement(By.xpath("//*[@id=\"calDepartLabelCont\"]//input[@value=\"\"]"));
		QAFWebElement departDate = driver.findElement(By.xpath("//tbody[@class='dl-datepicker-tbody-1']//a[contains(text(), '6')]"));
		Assert.assertTrue(departDate.isDisplayed(), "Departure Date selection is NOT Present");
		//test.log(Status.PASS, "Departure Date selection is Present");
		departDate.click();
		CalDoneButton.click();
		Assert.assertFalse(noDepDate.isDisplayed(), "Departure Date is NOT selected");
		//test.log(Status.PASS, "Script Clicked on 'Done' button successfully");
		//test.log(Status.PASS, "Script Selected Departure Date Successfully");
	}
	
	public void selectReturnDate() {
		QAFWebElement CalDoneButton = driver.findElement(By.cssSelector("button.donebutton"));
		QAFWebElement noReturnDate = driver.findElement(By.xpath("//*[@id='calReturnLabelCont']//input[@value='']"));
		QAFWebElement returnDate = driver.findElement(By.xpath("//tbody[@class='dl-datepicker-tbody-1']//a[contains(text(), '13')]"));
		Assert.assertTrue(returnDate.isDisplayed(), "Return Date selection is NOT Present");
		//test.log(Status.PASS, "Return Date Selection is Present");
		returnDate.click();
		CalDoneButton.click();
		Assert.assertFalse(noReturnDate.isDisplayed(), "Return Date is Not Selected");
		//test.log(Status.PASS, "Script Clicked on 'Done' button successfully");
		//test.log(Status.PASS, "Script Selected Return Date Successfully");
	}
	
	public void clickOnNumberOfPassengers() {
		QAFWebElement passengerTwo = driver.findElement(By.cssSelector("li#ui-list-passengers1"));
		QAFWebElement numberOfPassengers = driver.findElement(By.xpath("//*[@id='passengers-val']"));
		Assert.assertTrue(numberOfPassengers.isDisplayed(), "Passenger 1 is not Present");
		//test.log(Status.PASS, "WebElement 'Passenger 1' is Present");
		numberOfPassengers.click();
		Assert.assertTrue(passengerTwo.isDisplayed(), "Number of Passenger DropDown List is Not Present");
		//test.log(Status.PASS, "Script Selected number of Passenger Successfully");
	}
	
	
	public void selectNumPassengerTwo() {
		QAFWebElement passengerTwo = driver.findElement(By.cssSelector("li#ui-list-passengers1"));
		Assert.assertTrue(passengerTwo.isDisplayed(), "WebElement 'Passenger 2' is not Present");
		//test.log(Status.PASS, "WebElement 'Passenger 2' is Present");
		passengerTwo.click();
		QAFWebElement numPassenger = driver.findElement(By.xpath("//*[@id='passengers-val']"));
		String actual = numPassenger.getText();
		String Expected = "1 Passenger";
		Assert.assertNotSame(actual, Expected);
		//test.log(Status.PASS, "Script Selected number of Passenger as '2' Successfully");

	}
	

	public void clickOnDepartR() {
		
		QAFWebElement DepartR = driver.findElement(By.cssSelector("span.calenderDepartSpan"));
		Assert.assertTrue(DepartR.isDisplayed(), "WebElement 'Depart' is not Present");
		//test.log(Status.PASS, "WebElement 'Depart' is Present");
		DepartR .click();
		QAFWebElement departDate = driver.findElement(By.xpath("//tbody[@class='dl-datepicker-tbody-1']//a[contains(text(), '6')]"));
		Assert.assertTrue(departDate.isDisplayed(), "WebElement 'Depart' is NOT Present");
		//test.log(Status.PASS, "Script clicked on WebElement 'Depart' Successfully");
	}
	
	
	public void clickOnReturnR() {
		QAFWebElement ReturnR = driver.findElement(By.xpath("//*[@id='calReturnLabelCont']/span[2]"));
		Assert.assertTrue(ReturnR.isDisplayed(), "WebElement 'Return' is not Present");
		//test.log(Status.PASS, "WebElement 'Return' is Present");
		ReturnR.click();
		Assert.assertTrue(ReturnR.isDisplayed(), "WebElement 'Return' is still Present");
		//test.log(Status.PASS, "Script clicked on WebElement 'Return' Successfully");
		
	}
	
	public void clickOnSearch() {
		QAFWebElement Search = driver.findElement(By.xpath("//button[@id='btn-book-submit']"));
		Assert.assertTrue(Search.isEnabled(), "Search Button is not Present");
		//test.log(Status.PASS, "WebElement 'Search' is Present");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Search);
		Assert.assertFalse(Search.isDisplayed(), "Done Button is Present");
		//test.log(Status.PASS, "Script clicked on 'Search' button Successfully");
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		//Search.click();
	}
	
*/

