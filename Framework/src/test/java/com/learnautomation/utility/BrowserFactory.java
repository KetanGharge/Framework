package com.learnautomation.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appurl) {
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
		
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","./IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			
			
		}
		else throw new IllegalArgumentException();
		
		driver.get(appurl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}

}
