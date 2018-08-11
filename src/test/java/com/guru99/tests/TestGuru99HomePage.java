package com.guru99.tests;

import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class TestGuru99HomePage {
	
	final static Logger logger = Logger.getLogger("GURU99_TESTS");
	
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	Boolean HomePageLaunch = false;
	Guru99HomePage objHomePage;
	
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("Firefox") String BrowserName) throws MalformedURLException {
		
		System.out.println("START: In set-up Method");
		logger.info("START: In set-up Method");
		
		gds.initParameters();
		
		// calls the init method in getWebDriverInstance and gets the WebDriverImpl 
		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		BankHomePage = GlobalDataStore.Guru99HomePage;
		HomePageLaunch = driver.navigateTo(BankHomePage);
		objHomePage = new Guru99HomePage();
		Guru99HomePage.setLogCategory("GURU99_TESTS");
		objHomePage.setWebDriver(driver);
		
		System.out.println("END: In set-up Method");
		logger.info("END: In set-up Method");
	
	}
	
	@Test
	public void test_Home_Page_DashBoard_userName() {
		
		System.out.println("START: test_Home_Page_DashBoard_userName");
		logger.info("START: test_Home_Page_DashBoard_userName");
		
		//Assert.assertTrue(HomePageLaunch);
		if (HomePageLaunch == true) {
			String loginPageTitle = objHomePage.getHomePageDashboardUserName();
			System.out.println("the login title " + loginPageTitle);
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		}
		
		System.out.println("END: test_Home_Page_DashBoard_userName");
		logger.info("END: test_Home_Page_DashBoard_userName");
	}
	
	@Test
	public void test_SeleniumDropDownMenu() {
		
		System.out.println("START: test_SeleniumDropDownMenu");
		logger.info("START: test_SeleniumDropDownMenu");
		
		//Assert.assertTrue(HomePageLaunch);
		if (HomePageLaunch == true) {
			objHomePage.ClickSeleniumDropDownMenu();
		}
		
		System.out.println("END: test_SeleniumDropDownMenu");
		logger.info("END: test_SeleniumDropDownMenu");
	}
	
	@Test
	public void test_getSteptoGenerateAccess() {
		
		System.out.println("START: test_getSteptoGenerateAccess");
		logger.info("START:test_getSteptoGenerateAccess");
		
		//Assert.assertTrue(HomePageLaunch);
		if (HomePageLaunch == true) {
			String getStepsGenAccess = objHomePage.getStepstoGenerateAccessText();
			System.out.println("steps to generate " + getStepsGenAccess);
			logger.info("steps to generate " + getStepsGenAccess);
			Assert.assertTrue(getStepsGenAccess.contains("Steps To Generate Access"));
		}
		
		System.out.println("END: test_getSteptoGenerateAccess");
		logger.info("END: test_getSteptoGenerateAccess");
	}
	
	@Test
	public void test_UserIdPasswdLabels() {
		
		System.out.println("START: test_UserIdPasswdLabels");
		logger.info("test_UserIdPasswdLabels");
		
		//Assert.assertTrue(HomePageLaunch);
		if (HomePageLaunch == true) {
			
			String UserIdLabel = objHomePage.getUserIDTextFromHomePage();
			System.out.println("User Id Label: " + UserIdLabel);
			logger.info("User Id Label: " + UserIdLabel);
			String UserIdLabelExp = "UserID";
			Assert.assertEquals(UserIdLabel, UserIdLabelExp);
			
			String PasswordLabel = objHomePage.getPasswordLabelFromHomePage();
			System.out.println("Password Label: " + PasswordLabel);
			logger.info("Password Label: " + PasswordLabel);
			String PasswordLabelExp = "Password";
			Assert.assertEquals(PasswordLabel, PasswordLabelExp);
			
		}
		
		System.out.println("END: test_UserIdPasswdLabels");
		logger.info("END: test_UserIdPasswdLabels");
	}
	
	@Test
	public void test_checkHereLinkExists() {
		
		System.out.println("START: checkHereLinkExists");
		logger.info("START: checkHereLinkExists");
		//Assert.assertTrue(HomePageLaunch);
		
		if (HomePageLaunch == true) {
			boolean checkHereLinkEnabled = objHomePage.checkHereLinkExists();
			System.out.println("checkHereLinkEnabled " + checkHereLinkEnabled);
			logger.info("checkHereLinkEnabled " + checkHereLinkEnabled);
			if (checkHereLinkEnabled) {
				WebElement HereLinkWe = objHomePage.ReturnHereLinkWE();
				HereLinkWe.click();
			}
			Assert.assertTrue(checkHereLinkEnabled);
		}
		
		System.out.println("END: checkHereLinkExists");
		logger.info("END: checkHereLinkExists");
	}
	
	@Test
	@Parameters({ "emailID" })
	public void test_UserEnrollment(String emailID)
	{
		System.out.println("START: test_UserEnrollment");
		logger.info("START: test_UserEnrollment");
		//print email id
		System.out.println("email id : " + emailID);
		
		WebElement userEnroll = objHomePage.returnRegisterEmailID();
		userEnroll.sendKeys(emailID);
		WebElement submitAfterEmailReg = objHomePage.submitButtonEmailReg();
		submitAfterEmailReg.click();
		System.out.println("END: test_UserEnrollment");
		logger.info("END: test_UserEnrollment");
	}
	
	@Test
	@Parameters({"sUsername","sPassword"})
	public void test_DemoSiteUserLogin(String sUsername, String sPassword){  
		
		System.out.println("START: test_DemoSiteUserLogin");
		logger.info("START: test_DemoSiteUserLogin");
		System.out.println(" The userName " +sUsername);
		System.out.println("The Password "+sPassword);
		
		WebElement RegUserID = objHomePage.RegisterUserID();
		RegUserID.sendKeys(sUsername);
		
		WebElement RegPasswd = objHomePage.RegisterPassword();
		RegPasswd.sendKeys(sPassword);
		
		WebElement loginButton = objHomePage.loginButtonExist();
		if (loginButton != null) {
			loginButton.click();
		}
		
		System.out.println("END: test_DemoSiteUserLogin");
		logger.info("END: test_DemoSiteUserLogin");
	}
	
	@Test
	@Parameters({"sUsername","sPassword"})
	public void test_DemoSiteUserLoginReset(String sUsername, String sPassword){  
		
		System.out.println("START: test_DemoSiteUserLoginReset");
		logger.info("START: test_DemoSiteUserLoginReset");
		System.out.println(" The userName " +sUsername);
		System.out.println("The Password "+sPassword);
		
		WebElement RegUserID = objHomePage.RegisterUserID();
		RegUserID.sendKeys(sUsername);
		
		WebElement RegPasswd = objHomePage.RegisterPassword();
		RegPasswd.sendKeys(sPassword);
		
		WebElement resetButton = objHomePage.resetButtonExist();
		if (resetButton != null) {
			resetButton.click();
		}
		
		System.out.println("END: test_DemoSiteUserLoginReset");
		logger.info("END: test_DemoSiteUserLoginReset");
	}
	
	
	@AfterClass
	public void teardown() {
		logger.info("START: tear down");
		//this.driver.quitDriver();
		//driver.quitDriver();
		logger.info("END: tear down");
	}

}
