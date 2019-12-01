package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	// Default constructor which will called from other classes using super keyword. 
	// This will read the config.properties file.
	public TestBase(){
		
		try{
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("C:\\Users\\Praveen\\workspace\\frameTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip); // This will load config.properties in this script.
			
		}catch (FileNotFoundException e){	
			e.printStackTrace();			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	// Static method so that we can call it directly from any class
	// In this method we are setting up initial steps which will be called in setup in @BeforeMethod in test cases file.
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Study\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	}
}
