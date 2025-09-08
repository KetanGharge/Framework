package com.learnautomation.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.learnautomation.utility.Helper;



public class TestCaseWithFramework extends BaseClass {
	
	
	@Test(priority=1)
	public void test1() throws InterruptedException {
	
		logger = report.createTest("login to CRM");
		
		
		//initializes all the web elements and returns the class object
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		System.out.println(driver.getTitle());
			
		lp.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Login successsfull");
			
		Helper.captureScreenshot(driver);	
	}
	
	@Test(priority=2)
	public void test2() throws InterruptedException {
	
		logger = report.createTest("logout");
		
		logger.fail("logout Failed");
	}


}
