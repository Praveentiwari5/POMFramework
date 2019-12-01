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

	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactText() {
		System.out.println("hi");
		
		System.out.println("hik");
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		//boolean res=contactslabel.isDisplayed();
		System.out.println("res :"+contactslabel.getText());
		return true;

	}

}
