package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		
		super();
	}
	
	@BeforeMethod 
	public void setup(){

		initialization();
	    loginpage = new LoginPage(); // We created object of LoginPage to access methods of LoginPage
	}
	
	@Test(priority = 1)
	public void validateTitleTest(){
		String title = loginpage.validateLoginPageTitle(); // Here we are calling validate title method inside LoginPage
		Assert.assertEquals(title, "Cogmento CRM");
		System.out.println("Title test passed successfully");
		
	}
	
	@Test(priority = 2)
	public void loginTest(){
		// In below code, we are calling login method inside LoginPage class.
		// We are able to access prop since it is defined in TestBase class and we have inherited it.
		homepage = loginpage.login(prop.getProperty("uName"), prop.getProperty("Pass")); 
		// Since login page is returning homepage object and in order to access it's method we are storing it into homepage variable.
		System.out.println("Login test passed successfully");

	}
	
	@AfterMethod
	public void teardown(){
		
		//driver.quit();
		
	}
}
