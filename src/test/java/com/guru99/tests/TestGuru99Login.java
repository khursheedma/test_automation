package com.guru99.tests;

import java.net.MalformedURLException;
import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.ExcelUtils;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class TestGuru99Login {

final static Logger logger = Logger.getLogger("GURU99_LOGIN_TESTS");
	
	Guru99WebDriverImpl driver;
	
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	String BankLoginPage;
	Boolean HomePageLaunch = false;
	Boolean LoginPageLaunch = false;
	Guru99HomePage objHomePage;
	Guru99LoginPage objLoginPage;
	String baseDir;
	String FilePath;
	
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
		Guru99HomePage.setLogCategory("GURU99_LOGIN_TESTS");
		objHomePage.setWebDriver(driver);
		
		objLoginPage = new Guru99LoginPage();
		Guru99LoginPage.setLogCategory("GURU99_LOGIN_TESTS");
		objLoginPage.setWebDriver(driver);
		
		baseDir= System.getProperty("user.dir");
		//FilePath=baseDir+ "/" +"src/test/resources/" + GlobalDataStore.TestDataFile;
		FilePath=baseDir+ "/" + GlobalDataStore.TestDataFile;
		
		System.out.println("END: In set-up Method");
		logger.info("END: In set-up Method");
	
	}
	
	@DataProvider
	public Object[][] Authentication() throws Exception{

	       Object[][] testObjArray = ExcelUtils.getTableArray(FilePath,"Sheet1");

	       return (testObjArray);

			}
	/*
	@DataProvider
	public Object[][] AuthenticationOLD() {
		
		return new Object[][]{{"mngr146952", "muvequg"}};
	}
	*/
	
	@Test(dataProvider="Authentication")
	public void testGuru99Login (String sUserName, String sPassword) throws Exception {
		logger.info("In Test Login Method ");
		String loginTitle = null;
		//System.out.println("The file path " + FilePath);
		//driver.navigateTo(BankHomePage);
		
		//ExcelUtils.setExcelFile(FilePath, "sheet1");
		
		//driver.navigateTo(BankHomePage);		  
		logger.info(" The userName from Excel " +sUserName);
		logger.info(" The password from Excel " +sPassword);
		/*
		objLoginPage.loginToGuru99(sUserName,sPassword);
		loginTitle = objLoginPage.getLoginTitle();
		System.out.println("the login title " +loginTitle);
		*/
		
		WebElement RegUserID = objLoginPage.SetUp_UserID();
		RegUserID.sendKeys(sUserName);
		
		WebElement RegPasswd = objLoginPage.SetUp_Password();
		RegPasswd.sendKeys(sPassword);
		
		WebElement loginButton = objLoginPage.loginButtonExist();
		if (loginButton != null) {
			loginButton.click();
		}
		
		WebElement logout = objLoginPage.logout_validation();
		if (logout != null) {
			//String popupTextExpected = "Log out"; 
			//String popupTextActual = logout.getText();
			//System.out.println("Pop Up Text: " +  popupTextActual);
			//logger.info("Pop Up Text: " +  popupTextActual);
			//Assert.assertEquals(popupTextExpected, popupTextExpected);
			
			logout.click();
			
			//String alertTextExp = "You Have Successfully Logged Out!!";
			String alertTextExp = "You Have Succesfully Logged Out!!";
			Alert simpleAlert = objLoginPage.demoSiteAcceptAlertMessage();
			String alertText = simpleAlert.getText();
			System.out.println("Alert text is " + alertText);
			logger.info("Alert text is " + alertText);
			Assert.assertEquals(alertText, alertTextExp);
			simpleAlert.accept();
			
		}
		
	
		//Thread.sleep(1000);
		
		
	
	}
	
	//@Parameters({"sUsername","sPassword"})
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
		
		WebElement logout = objLoginPage.logout_validation();
		if (logout != null) {
			
			logout.click();
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

