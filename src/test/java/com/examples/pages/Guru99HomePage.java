package com.examples.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99HomePage {
	
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
	By demoSiteSelDropDown = By.xpath("//ul[@class='nav navbar-nav']/li[1]/a[1]");
	
	
	// ECOM: Begins
	By EcomHomePageTitle = By.xpath("//div[@class='page-title']");
	By EcomHomeMobileLink = By.xpath("//a[contains(text(),'Mobile')]");
	By EcomHomeMobilePageTitle = By.xpath("//h1[contains(text(),'Mobile')]");
	By EcomHomeMobileSortByTEMPORARY = By.xpath("//select[@title='Sort By']");
	By EcomHomeMobileSonyXperiaTitle = By.xpath("//a[@title='Sony Xperia']");
	By EcomHomeMobileSonyXperiaLstPgCost = By.xpath("//span[contains(text(),'$100.00')]");
	By EcomHomeMobileSonyXperiaDtlPgCost = By.xpath("//span[@class='price']");
	By EcomHomeMobileSonyXperiaImage = By.cssSelector("#product-collection-image-1");
		
	
	
	// assigning same instance
	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		System.out.println("START: setWebDriver ");
		logger.info("START: setWebDriver ");
		this.driver = webDriver;
		System.out.println("END: setWebDriver ");
		logger.info("END: setWebDriver ");
	}
	
	// Get the user name from Home Page
	public String getHomePageDashboardUserName() {
		System.out.println("START: getHomePageDashboardUserName ");
		logger.info("START: getHomePageDashboardUserName ");
		System.out.println("coming here");
		System.out.println("END: getHomePageDashboardUserName ");
		logger.info("END: getHomePageDashboardUserName ");
		return driver.getElementText(homePageUserName);
	}

	// Get the steps to generate access text
	public String getStepstoGenerateAccessText() {
		System.out.println("START: getStepstoGenerateAccessText ");
		logger.info("START: getStepstoGenerateAccessText ");
		System.out.println("coming here");
		System.out.println("END: getStepstoGenerateAccessText ");
		logger.info("END: getStepstoGenerateAccessText ");
		return driver.getElementText(getStepsToGeneratexpath);
	}

	// check the here link exists
	public Boolean checkHereLinkExists() {
		System.out.println("START: checkHereLinkExists ");
		logger.info("START: checkHereLinkExists ");
		System.out.println("coming here");
		System.out.println("END: checkHereLinkExists ");
		logger.info("END: checkHereLinkExists ");
		return driver.CheckLinkExists(checkhereLinkExists);
	}
	
	// return web element if here link exists
	public WebElement ReturnHereLinkWE() {
		System.out.println("START: ReturnHereLinkWE ");
		logger.info("START: ReturnHereLinkWE ");
		System.out.println("coming here");
		System.out.println("END: ReturnHereLinkWE ");
		logger.info("END: checkHereLinkExists ");
		if (checkHereLinkExists()) {
			return driver.FindElement(checkhereLinkExists);
		}	
		return null;
	}
	// return web element to register email id for enrollment
	public WebElement returnRegisterEmailID() {
		System.out.println("START: returnRegisterEmailID ");
		logger.info("START: returnRegisterEmailID ");
		System.out.println("coming here");
		System.out.println("END: returnRegisterEmailID ");
		logger.info("END: returnRegisterEmailID ");
		if (driver.CheckLinkExists(registerEmailId)) {
			return driver.FindElement(registerEmailId);
		}
		return null;
	}
	
	public WebElement submitButtonEmailReg() {
		System.out.println("START: submitButtonEmailReg ");
		logger.info("START: submitButtonEmailReg ");
		System.out.println("coming here");
		System.out.println("END: submitButtonEmailReg ");
		logger.info("END: submitButtonEmailReg ");
		return driver.FindElement(submitButtonEmailReg);
	}
	
	public WebElement RegisterUserID() {
		System.out.println("START: RegisterUserID ");
		logger.info("START: RegisterUserID ");
		System.out.println("coming here");
		System.out.println("END: RegisterUserID ");
		logger.info("END: RegisterUserID ");
		return driver.FindElement(demoSiteUserId);
	}
	
	public WebElement RegisterPassword() {
		System.out.println("START: RegisterPassword ");
		logger.info("START: RegisterPassword ");
		System.out.println("coming here");
		System.out.println("END: RegisterPassword ");
		logger.info("END: RegisterPassword ");
		return driver.FindElement(demoSitePassword);
	}
	
	// Get the user id label text from Home Page
	public String getUserIDTextFromHomePage() {
		System.out.println("START: getUserIDTextFromHomePage ");
		logger.info("START: getUserIDTextFromHomePage ");
		System.out.println("coming here");
		System.out.println("END: getUserIDTextFromHomePage ");
		logger.info("END: getUserIDTextFromHomePage ");
		return driver.getElementText(demoSiteUserIdLabel);
	}
	// Get the  password label text from Home Page
	public String getPasswordLabelFromHomePage() {
		System.out.println("START: getPasswordLabelFromHomePage ");
		logger.info("START: getPasswordLabelFromHomePage ");
		System.out.println("coming here");
		System.out.println("END: getPasswordLabelFromHomePage ");
		logger.info("END: getPasswordLabelFromHomePage ");
		return driver.getElementText(demoSitePasswordLabel);
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
	
	public void ClickSeleniumDropDownMenu() {
		
		System.out.println("START: SeleniumDropDownMenu ");
		logger.info("START: SeleniumDropDownMenu ");
		System.out.println("coming here");
		
		
		WebElement element =  driver.FindElement(demoSiteSelDropDown);
		driver.clickElement(element);
		
		System.out.println("END: SeleniumDropDownMenu ");
		logger.info("END: SeleniumDropDownMenu ");
	
	}
	
	
	
	
	//ECOM: Get home page title
	public String Ecom_Get_HomePage_Title() {
		System.out.println("START: Ecom_Get_Home_Page_Title ");
		logger.info("START: Ecom_Get_Home_Page_Title ");
		System.out.println("coming here");
		System.out.println("END: Ecom_Get_Home_Page_Title ");
		logger.info("END: Ecom_Get_Home_Page_Title ");
		return driver.getElementText(EcomHomePageTitle);
	}
	
	// ECOM: return Mobile Link WebElement from ecom home page
	public WebElement Ecom_HomePage_Mobile_link() {
		System.out.println("START: Ecom_HomePage_Mobile_link ");
		logger.info("START: Ecom_HomePage_Mobile_link ");
		System.out.println("coming here");
		System.out.println("END: Ecom_HomePage_Mobile_link ");
		logger.info("END: Ecom_HomePage_Mobile_link ");
		if (driver.CheckLinkExists(EcomHomeMobileLink)) {
			return driver.FindElement(EcomHomeMobileLink);
		}
		return null;
	}
	
	//ECOM: Get home page title
	public String Ecom_Get_MobilePage_Title() {
		System.out.println("START: Ecom_Get_MobilePage_Title ");
		logger.info("START: Ecom_Get_MobilePage_Title ");
		System.out.println("coming here");
		System.out.println("END: Ecom_Get_MobilePage_Title ");
		logger.info("END: Ecom_Get_MobilePage_Title ");
		return driver.getElementText(EcomHomeMobilePageTitle);
	}
	
	//  TEMPORARY SOLUTION
	public Select ECOMverifyComboSelection() {
		System.out.println("START: ECOMverifyComboSelection ");
		logger.info("START: ECOMverifyComboSelection ");
		System.out.println("coming here");
		
		Select sel1 = new Select(driver.FindElement(EcomHomeMobileSortByTEMPORARY));
		System.out.println("END: ECOMverifyComboSelection ");
		logger.info("END: ECOMverifyComboSelection ");
		
		return sel1;
	
	}
	
	// ECOM: return Sony Xperia cost from list page
	public String Ecom_ListPage_SonyXperia_Cost() {
		System.out.println("START: Ecom_ListPage_SonyXperia_Cost ");
		logger.info("START: Ecom_ListPage_SonyXperia_Cost ");
		System.out.println("coming here");
		System.out.println("END: Ecom_ListPage_SonyXperia_Cost ");
		logger.info("END: Ecom_ListPage_SonyXperia_Cost ");
		return driver.getElementText(EcomHomeMobileSonyXperiaLstPgCost);
	}
	
	// ECOM: return Sony Xperia Mobile Link WebElement from list page
	public WebElement Ecom_ListPage_SonyXperiaImg() {
		System.out.println("START: Ecom_ListPage_SonyXperiaImg ");
		logger.info("START: Ecom_ListPage_SonyXperiaImg ");
		System.out.println("coming here");
		System.out.println("END: Ecom_ListPage_SonyXperiaImg ");
		logger.info("END: Ecom_ListPage_SonyXperiaImg ");
		if (driver.CheckLinkExists(EcomHomeMobileSonyXperiaImage)) {
			return driver.FindElement(EcomHomeMobileSonyXperiaImage);
		}
		return null;
	}
	
	// ECOM: return Sony Xperia cost from list page
	public String Ecom_DetailPage_SonyXperia_Cost() {
		System.out.println("START: Ecom_DetailPage_SonyXperia_Cost ");
		logger.info("START: Ecom_DetailPage_SonyXperia_Cost ");
		System.out.println("coming here");
		System.out.println("END: Ecom_DetailPage_SonyXperia_Cost ");
		logger.info("END: Ecom_DetailPage_SonyXperia_Cost ");
		return driver.getElementText(EcomHomeMobileSonyXperiaDtlPgCost);
	}
	/*
	 * By EcomHomeMobileSonyXperiaTitle = By.xpath("//a[@title='Sony Xperia']");
	 * By EcomHomeMobileSonyXperiaLstPgCost = By.xpath("//span[contains(text(),'$100.00')]");
	 * By EcomHomeMobileSonyXperiaDtlPgCost = By.xpath("//span[@class='price']");
	 * By EcomHomeMobileSonyXperiaImage = By.cssSelector("#product-collection-image-1");
	 */
		
	
	
		
	public static void setLogCategory(String LogFile) {
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);
	}
	 
}