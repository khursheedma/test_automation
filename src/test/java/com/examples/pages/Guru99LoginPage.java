package com.examples.pages;


import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99LoginPage {
	
	Guru99WebDriverImpl driver;
	private static Logger logger;
	public static String LogCategory;
	
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By getStepsToGeneratexpath = By.xpath("//h4[@class='barone']");
	By checkhereLinkExists = By.xpath("//a[contains(text(),'here')]");
	By registerEmailId = By.xpath("//input[@name='emailid']");
	By submitButtonEmailReg = By.xpath("//input[@value='Submit']");
	By demoSiteUserIdLabel = By.xpath("//td[contains(text(),'UserID')]");
	By demoSitePasswordLabel = By.xpath("//td[contains(text(),'Password')]");
	By demoSiteUserId = By.xpath("//input[@name='uid']");
	By demoSitePassword = By.xpath("//input[@name='password']");
	By demoSiteLOGINButton = By.xpath("//input[@value='LOGIN']");
	By demoSiteRESETButton = By.xpath("//input[@value='RESET']");
	By demoSiteLogout = By.xpath("//a[contains(text(),'Log out')]");
	
	
	// assigning same instance
	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		System.out.println("START: setWebDriver ");
		logger.info("START: setWebDriver ");
		this.driver = webDriver;
		System.out.println("END: setWebDriver ");
		logger.info("END: setWebDriver ");
	}
	
	public WebElement SetUp_UserID() {
		System.out.println("START: SetUp_UserID ");
		logger.info("START: SetUp_UserID ");
		System.out.println("coming here");
		System.out.println("END: SetUp_UserID ");
		logger.info("END: SetUp_UserID ");
		return driver.FindElement(demoSiteUserId);
	}
	
	public WebElement SetUp_Password() {
		System.out.println("START: SetUp_Password ");
		logger.info("START: SetUp_Password ");
		System.out.println("coming here");
		System.out.println("END: SetUp_Password ");
		logger.info("END: SetUp_Password ");
		return driver.FindElement(demoSitePassword);
	}
	
	
	
	// return login button WebElement if enabled
	public WebElement loginButtonExist() {
		System.out.println("START: loginButtonExist ");
		logger.info("START: loginButtonExist ");
		System.out.println("coming here");
		System.out.println("END: loginButtonExist ");
		logger.info("END: loginButtonExist ");
		if (driver.CheckLinkExists(demoSiteLOGINButton)) {
			return driver.FindElement(demoSiteLOGINButton);
		}
		return null;
	}
	
	// return reset button WebElement if enabled
	public WebElement resetButtonExist() {
		System.out.println("START: resetButtonExist ");
		logger.info("START: resetButtonExist ");
		System.out.println("coming here");
		System.out.println("END: resetButtonExist ");
		logger.info("END: resetButtonExist ");
		if (driver.CheckLinkExists(demoSiteRESETButton)) {
			return driver.FindElement(demoSiteRESETButton);
		}
		return null;
	}
	
	// return logout button WebElement if enabled
	public WebElement logout_validation() {
		System.out.println("START: logout_validation ");
		logger.info("START: logout_validation ");
		System.out.println("coming here");
		System.out.println("END: logout_validation ");
		logger.info("END: logout_validation ");
		if (driver.CheckLinkExists(demoSiteLogout)) {
				return driver.FindElement(demoSiteLogout);
			}
			return null;
		}
	public Alert demoSiteAcceptAlertMessage() {
		System.out.println("START: demoSiteAcceptAlertMessage ");
		logger.info("START: demoSiteAcceptAlertMessage ");
		System.out.println("coming here");
		System.out.println("END: demoSiteAcceptAlertMessage ");
		logger.info("END: demoSiteAcceptAlertMessage ");
		
		//Alert simpleAlert = driver.AcceptAlert();
		//String alertText = simpleAlert.getText();
		//System.out.println("Alert text is " + alertText);
		//simpleAlert.accept();
		return driver.AcceptAlert();
	}
	
	public static void setLogCategory(String LogFile) {
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);
	}
	 
}