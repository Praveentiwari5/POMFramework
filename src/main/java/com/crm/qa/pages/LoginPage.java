package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Page Factory or Object Repository - Shortcut to find elements.
	
	// Here we are finding the Web Elements using page factory 
 	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//*[contains(text(), 'Login')]")
	WebElement loginbtn;
	
//	Initializing Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this); // Need to dive more into this.
	}

	// Actions that we need to perform
	// Validate title
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	//click on login after entering username and password
	public HomePage login(String username, String password){
		
		userName.sendKeys(username);
		pwd.sendKeys(password);
		loginbtn.click();
		
		return new HomePage();
	}
}
