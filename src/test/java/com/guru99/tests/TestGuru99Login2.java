package com.guru99.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class TestGuru99Login2 {

final static Logger logger = Logger.getLogger("GURU99_LOGIN_TESTS");
	
	Guru99WebDriverImpl driver;
	
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	String BankLoginPage;
	Boolean HomePageLaunch = false;
	Boolean LoginPageLaunch = false;
	Guru99HomePage objHomePage;
	Guru99LoginPage objLoginPage;
	
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("Firefox") String BrowserName) throws MalformedURLException {
		
		System.out.println("START: In set-up Method");
		logger.info("START: In set-up Method");
		
		gds.initParameters();
		
		// calls the init method in getWebDriverInstance and gets the WebDriverImpl 
		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		//BankHomePage = GlobalDataStore.Guru99HomePage;
		//HomePageLaunch = driver.navigateTo(BankHomePage);
		BankLoginPage = GlobalDataStore.Guru99LoginPage;
		LoginPageLaunch = driver.navigateTo(BankLoginPage);
		
		//objHomePage = new Guru99HomePage();
		objLoginPage = new Guru99LoginPage();
		Guru99LoginPage.setLogCategory("GURU99_LOGIN_TESTS");
		//objHomePage.setWebDriver(driver);
		objLoginPage.setWebDriver(driver);
		
		System.out.println("END: In set-up Method");
		logger.info("END: In set-up Method");
	
	}
	
	@Test
	@Parameters({"sUsername","sPassword"})
	public void test_DemoSiteUserLogin(String sUsername, String sPassword){  
		
		System.out.println("START: test_DemoSiteUserLogin");
		logger.info("START: test_DemoSiteUserLogin");
		System.out.println(" The userName " +sUsername);
		System.out.println("The Password "+sPassword);
		
		WebElement RegUserID = objLoginPage.SetUp_UserID();
		RegUserID.sendKeys(sUsername);
		
		WebElement RegPasswd = objLoginPage.SetUp_Password();
		RegPasswd.sendKeys(sPassword);
		
		WebElement loginButton = objLoginPage.loginButtonExist();
		if (loginButton != null) {
			loginButton.click();
		}
		
		System.out.println("END: test_DemoSiteUserLogin");
		logger.info("END: test_DemoSiteUserLogin");
	}
	
	
	@AfterClass
	public void teardown() {
		logger.info("START: tear down");
		//this.driver.quitDriver();
		//driver.quitDriver();
		logger.info("END: tear down");
	}

}

