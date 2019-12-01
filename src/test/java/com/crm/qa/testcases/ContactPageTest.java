package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	
	public ContactPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup() {

		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("uName"),prop.getProperty("Pass"));
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		contactspage = homepage.clickcontacts();
	}
	
	@Test
	public void verifyContactTextTest(){
		Assert.assertTrue(contactspage.verifyContactText());		
	}
	
	@AfterMethod
	public void teardown(){
	//	driver.quit();
	}

}
