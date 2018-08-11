package com.facebook.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;

public class TestHomePage {
	
	GlobalDataStore gds = new GlobalDataStore();
	String GeckoDriver;
	WebDriver driver = null;
	String HomePage;
	String ChromeDriver;
	FaceBookHomePage FBPage;
	
	@Parameters({ "BrowserName", "HomePage" })
	@BeforeClass
	public void setUp(@Optional("Firefox")String BrowserName, String HomePage) {
		System.out.println(" The BrowserName....");
		System.out.println(" The Browser Name" + BrowserName);
		
		gds.initParameters();
		
		String baseDir = System.getProperty("user.dir");
		System.out.println(" the base dir " + baseDir);
		
		GeckoDriver = GlobalDataStore.GeckoDriver_MAC;
		this.HomePage = HomePage;
		System.out.println("The Home Page " + HomePage);
		System.out.println("The GeckoDriver " + GeckoDriver);
		
		if (BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",  GeckoDriver);
			driver = new FirefoxDriver();
		}
		
		else if (BrowserName.equalsIgnoreCase("chrome")) {
			System.out.println(" The Chrome Driver " +  GlobalDataStore.ChromeDriver_MAC);
			System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_MAC);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			//driver.navigate().to(HomePage);
		}
		
		else if (BrowserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			//driver.navigate().to(HomePage);
		}
		FBPage= new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		
	}
	
	@Test
	public void testFaceBookTitleOnPageLoad()
	{
		//String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		// launch fire fox and direct it to the Base URL
		driver.get(HomePage);
		
		//get actual value of the title
		actualTitle = driver.getTitle();
		actualTitle = actualTitle.trim();
		System.out.println("The actual title " + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
				
	}
	
	@Test
	public void testFaceBookTitleOnPageLoadPage()
	{
		//String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		// create the instance
		FBPage  = new FaceBookHomePage(driver);
		
		// launch fire fox and direct it to the Base URL
		FBPage.launchHomePage(HomePage);
		
		//get actual value of the title
		actualTitle = FBPage.getLoginTitle();
		//System.out.println("The actual title " + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
				
	}		
	
	@Test
	@Parameters({ "firstName", "lastName" })
	public void testUserRegistration(String firstName, String lastName)
	{
		//print first name and last name
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		
		// create the instance
		//FBPage  = new FaceBookHomePage(driver);
		
		// launch fire fox and direct it to the Base URL
		//FBPage.launchHomePage(HomePage);
		
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		
		//driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//driver.findElement(By.xpath(".//input[@name='lastname']")).sendKeys(lastName);
		
		 driver.findElement(By.name("reg_email__")).sendKeys("888-99-8888");
	}		
	
	@Test
	@Parameters({"sUsername","sPassword"})
	public void testUserLogin(String sUsername, String sPassword){  
		System.out.println(" The userName " +sUsername);
		System.out.println("The Password "+sPassword);
		//FBPage= new FaceBookHomePage(driver);
		//FBPage.launchHomePage(HomePage);
		//driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(sUsername);
		driver.findElement(By.id("email")).sendKeys(sUsername);
		driver.findElement(By.id("pass")).sendKeys(sPassword);
		driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
		driver.findElement(By.name("email")).sendKeys(sUsername);
		//driver.findElement(By.name("pass")).sendKeys(sPassword);
		driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
		//driver.findElement(By.name("pass")).sendKeys(sPassword);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		  
		driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]"));
		//System.out.println(");  
	  }
	
	@Test
	public void verifyTextContains() {
		//FBPage= new FaceBookHomePage(driver);
		//FBPage.launchHomePage(HomePage);
		//WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]"));
		//String actualTitle = element.getText().trim();
		//System.out.print("the text : " + element.getText().trim());
		//String expectedTitle = "Sign Up";
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		WebElement element1 = driver.findElement(By.xpath("//h2[contains(text(), ' Connect with friends')]"));
		String actualTitle1 = element1.getText().trim();
		String actualTitleSubStr = actualTitle1.substring(0, 20);
		System.out.println(actualTitleSubStr);
		//Connect with friends and the world around you on Facebook
		//System.out.print("the text : " + element1.getText().trim());
		String expectedTitle1 = "Connect with friends";
		Assert.assertEquals(actualTitleSubStr, expectedTitle1);
	}
	
	@Test
	public void verifyLinkTextContains() {
		//FBPage= new FaceBookHomePage(driver);
		//FBPage.launchHomePage(HomePage);
		
		//WebElement element = driver.findElement(By.linkText("Forgot account?"));
		//element.click();
		
		//WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Forgot account?')]"));
		WebElement element = FBPage.findElementByxpath("//a[contains(text(),'Forgot account?')]");
		element.click();
	}
	
	@Test
	public void verifyComboSelection() {
		//FBPage= new FaceBookHomePage(driver);
		//FBPage.launchHomePage(HomePage);
		
		Select sel1 = new Select(driver.findElement(By.xpath(".//select[@id='month']")));
		sel1.selectByVisibleText("Jul");
		Select sel2 = new Select(driver.findElement(By.xpath(".//select[@id='day']")));
		sel2.selectByValue("5");;
		Select sel3 = new Select(driver.findElement(By.xpath(".//select[@id='year']")));
		sel3.selectByIndex(5);
		
		//driver.findElement(By.name("reg_email__"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Female')]")));
		element.click();
		WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
		signUp.click();
	}
		
		
	@AfterClass
	public void cleanUp() {
		//close firefox	
		//driver.close();
	}		
								
}
