package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(name="username")
	WebElement user;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	public void loginToCRM(String username,String password) {
		
		user.sendKeys(username);
		pass.sendKeys(password);
		
		loginButton.click();
	
	}

}
