package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(), 'Praveen Tiwari')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contacts;

	@FindBy(xpath="//span[contains(text(), 'Deals')]")
	WebElement deals;

	@FindBy(xpath="//span[contains(text(), 'Tasks')]")
	WebElement tasks;

	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomepagetitle(){
		
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername(){
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickcontacts(){
		
		contacts.click();
		return new ContactsPage(); // here we are returning object of class ContactsPage (new ContactsPage)
	}
	
	public DealsPage clickdeals(){
		deals.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickTasks(){
		
		tasks.click();
		return new TasksPage();
	}
	
}
