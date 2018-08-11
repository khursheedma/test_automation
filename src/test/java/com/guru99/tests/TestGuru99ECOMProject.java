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

public class TestGuru99ECOMProject {
	
	final static Logger logger = Logger.getLogger("GURU99_ECOM_TESTS");
	
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String EcomHomePage;
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
		EcomHomePage = GlobalDataStore.Guru99ECOMPage;
		HomePageLaunch = driver.navigateTo(EcomHomePage);
		objHomePage = new Guru99HomePage();
		Guru99HomePage.setLogCategory("GURU99_ECOM_TESTS");
		objHomePage.setWebDriver(driver);
		
		System.out.println("END: In set-up Method");
		logger.info("END: In set-up Method");
	
	}
	
	@Test
	public void test_ECOM_title_of_the_page() {
		
		System.out.println("START: test_ECOM_title_of_the_page");
		logger.info("START: test_ECOM_title_of_the_page");
		
		//Assert.assertTrue(HomePageLaunch);
		if (HomePageLaunch == true) {
			String ecom_homepage_title = objHomePage.Ecom_Get_HomePage_Title();
			System.out.println("the ecom home page title " + ecom_homepage_title);
			logger.info("the ecom home page title " + ecom_homepage_title);
			Assert.assertTrue(ecom_homepage_title.toLowerCase().contains("this is demo site for"));
		}
		
		System.out.println("END: test_ECOM_title_of_the_page");
		logger.info("END: test_ECOM_title_of_the_page");
	}
	
	@Test
	public void test_ECOM_Mobilelink_PageTitle()
	{
		System.out.println("START: test_ECOM_Mobilelink_PageTitle");
		logger.info("START: test_ECOM_Mobilelink_PageTitle");
		
		WebElement ecom_homepage_mobile_link = objHomePage.Ecom_HomePage_Mobile_link();
		if (ecom_homepage_mobile_link !=null) {
			ecom_homepage_mobile_link.click();
		} else {
			logger.info("ERROR: ecom_homepage_mobile_link returned null, please investigate...");
		}
		
		String MobilePageTitle = objHomePage.Ecom_Get_MobilePage_Title();
		if (MobilePageTitle != null) {
			logger.info("MobilePageTitle: " + MobilePageTitle);
			Assert.assertEquals(MobilePageTitle, "MOBILE");
		}
		//BELOW: temp fix
		Select sele = objHomePage.ECOMverifyComboSelection();
		sele.selectByVisibleText("Name");
		
		System.out.println("END: test_ECOM_Mobilelink_PageTitle");
		logger.info("END: test_ECOM_Mobilelink_PageTitle");
	}
	
	//Verify that cost of product in list page and details page are equal
	@Test
	public void test_ECOM_CostOfProdInListPageDetailsPageREqual()
	{
		System.out.println("START: test_ECOM_CostOfProdInListPageDetailsPageREqual");
		logger.info("START: test_ECOM_CostOfProdInListPageDetailsPageREqual");
		
		WebElement ecom_homepage_mobile_link = objHomePage.Ecom_HomePage_Mobile_link();
		if (ecom_homepage_mobile_link !=null) {
			ecom_homepage_mobile_link.click();
		} else {
			logger.info("ERROR: ecom_homepage_mobile_link returned null, please investigate...");
		}
		
		String CostOfProdInListPage = objHomePage.Ecom_ListPage_SonyXperia_Cost();
		WebElement DetPageSXLink =objHomePage.Ecom_ListPage_SonyXperiaImg();
		
		if (DetPageSXLink != null) {
			DetPageSXLink.click();
		}
		
		String CostOfProdInDetailsPage = objHomePage.Ecom_DetailPage_SonyXperia_Cost();
		
		logger.info("CostOfProdInListPage: " + CostOfProdInListPage);
		logger.info("CostOfProdInDetailsPage: " + CostOfProdInDetailsPage);
		Assert.assertEquals(CostOfProdInListPage, CostOfProdInDetailsPage);
		
		
		System.out.println("END: test_ECOM_CostOfProdInListPageDetailsPageREqual");
		logger.info("END: test_ECOM_CostOfProdInListPageDetailsPageREqual");
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
