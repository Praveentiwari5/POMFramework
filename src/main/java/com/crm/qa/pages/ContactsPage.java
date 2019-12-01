package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui loader']/parent::div")
	WebElement contactslabel;
	
	@FindBy(xpath = "//i[@class = 'edit icon']")
	WebElement newContact;

	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name = 'company']//child::input")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;	
	
	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactText() {
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		contactslabel.isDisplayed();
		//System.out.println("res :"+contactslabel.getText());
		return true;

	}

	public boolean newContact(){
		newContact.isDisplayed();
		return true;
	}
	
	public void clickNewContact(){
		
		newContact.click();
	}
	public void createNewContact(String ftName, String ltName){
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		//company.sendKeys(cmpny);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		saveBtn.click();
	}
}
