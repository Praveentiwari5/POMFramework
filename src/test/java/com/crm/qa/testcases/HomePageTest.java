package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		System.out.println(prop.getProperty("uName"));
		System.out.println(prop.getProperty("Pass"));
		homepage = loginpage.login(prop.getProperty("uName"),prop.getProperty("Pass"));
	}

	// Test cases should be independent, Launch browser before every test case and close after test case executed.
	@Test (priority = 1)
	public void verifyhomepagetitletest() {
		System.out.println("Inside verifyhomepagetitletest");
		String homepageTitle = homepage.verifyhomepagetitle();
		Assert.assertEquals(homepageTitle, "Cogmento CRM");

	}
	
	@Test(priority = 2)
	public void verifyuserNametest(){
	Assert.assertTrue(homepage.verifyCorrectUsername());	
		
	}
	
	@Test(priority = 3)
	public void verifyclickcontacttest(){
		contactspage = homepage.clickcontacts();
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
