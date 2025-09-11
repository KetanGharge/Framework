package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDatProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDatProvider conf;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and Test is getting ready", true);
		excel = new ExcelDataProvider();
		conf = new ConfigDatProvider();
		report = new ExtentReports();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM+"+Helper.getCurrentDateTime()+".html"));
		report.attachReporter(extent);
		
		Reporter.log("Settings Done-Test can be started",true);
	}
	
	//To pass browser and Url from Config.properties file
//	@BeforeClass
//	public void setup() {
//		Reporter.log("trying to start Browser and getting application ready",true);
//		driver = BrowserFactory.startApplication(driver, conf.getBrowser(), conf.getStagingURL());
//		Reporter.log("Browser and application up and running",true);
//	}

	//To pass browser and Url from testNG.XML
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String urlToBeTested) {
		Reporter.log("trying to start Browser and getting application ready",true);
		driver = BrowserFactory.startApplication(driver, browser, urlToBeTested);
		Reporter.log("Browser and application up and running",true);
	}
	
	@AfterClass
	public void tearDwon() {
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		Reporter.log("Test is about to end",true);
		if(ITestResult.FAILURE == result.getStatus())
		{
			logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(ITestResult.SUCCESS == result.getStatus())
		{
			logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(ITestResult.SKIP == result.getStatus())
		{
			logger.skip("test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		report.flush();
		
		Reporter.log("Test Completed >>> Reports generated",true);
	}
	

}
