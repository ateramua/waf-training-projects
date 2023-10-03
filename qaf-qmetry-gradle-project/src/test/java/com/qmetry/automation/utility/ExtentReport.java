package com.qmetry.automation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	


	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	
	public static void getReporter() {
		
		try {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("target/Spark.html");
		    extent.attachReporter(spark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
