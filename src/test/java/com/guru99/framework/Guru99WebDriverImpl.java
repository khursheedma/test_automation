package com.guru99.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.examples.config.GlobalDataStore;

public class Guru99WebDriverImpl implements Guru99WebDriver{
	// Initialize the web driver
	WebDriver driver;
	
	public void init(String Browser) {
		
		System.out.println("The WebDriver Init Method " + Browser);
		String UserDir = System.getProperty("user.dir");
		String OS = OSDetector();
		
		if (Browser.equalsIgnoreCase("chrome") && (OS.equals("Mac"))) {
			System.out.println(" The Chrome Driver " +  GlobalDataStore.ChromeDriver_MAC);
			System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_MAC);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);		
		}
		
		if (Browser.equals("chrome") && (OS.equals("Windows"))) {
			//System.out.println(" The Chrome Driver " +  GlobalDataStore.ChromeDriver_WIN);
			//System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_WIN);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);		
		}
		
		if (Browser.equals("FireFox") || (Browser.equals("firefox"))) {
			System.out.println("Coming in Firefox");
			if (OS.equals("Mac")) {
				System.out.println("In Firefox Driver and Mac " + UserDir + GlobalDataStore.GeckoDriver_MAC);
				//System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_MAC);
				System.setProperty("webdriver.gecko.driver",   GlobalDataStore.GeckoDriver_MAC);
				driver = new FirefoxDriver();
			}
			else {
				System.out.println("In Fire fox Driver");
				//System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_WIN);
				driver = new FirefoxDriver();
			}
		}
		
	}
	
	public void initSauceLabs(String browserName) throws MalformedURLException{
		
		String USERNAME = "khursheedma";
		String ACCESS_KEY = "99a641d3-9798-439d-ae9b-3918038d859d";
		
		String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//DesiredCapabilities caps = DesiredCapabilities.browserName();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
		capabilities.setCapability("platform", "OS X 10.12");
		//capabilities.setCapability("platform", "mac");
		//capabilities.setCapability("version", "63.0");  chrome
		capabilities.setCapability("version", "60.0"); //  firefox version
		//System.setProperty("webdriver.gecko.driver:, :drivers/geckodriver");
		driver = new RemoteWebDriver(new URL(URL), capabilities);
		
	}
	
	public String OSDetector() {
		
		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.contains("win")) {
			return "windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	
	}
	
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public WebDriver getDriverInstance() {
		return driver;
	}


	@Override
	public Boolean navigateTo(final String urlString) {
		
		Boolean mainPageFound = false;
		
		try {
			
			System.out.println("The Navigate URL " + urlString);
			String navigateUrl;
			navigateUrl = urlString;
			
			//PageFactory.initElements9driver, TMXWebDriverImpl.class);
			this.driver.get(navigateUrl);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String CurrentUrl = getCurrentUrl();
			
			
			if (CurrentUrl != null) {
				mainPageFound = true;
				driver.manage().window().maximize();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return mainPageFound;
	
	}


	@Override
	public void quitDriver() {
		if (this.driver != null) {
			this.driver.quit();
			this.driver = null;
		}
		
	}


	@Override
	public void closeBrowser() {
		System.out.println("Closes Browser");
		this.driver.close();
		
	}


	public WebElement FindElement(By element) {
		System.out.println(" Coming in Find Element");
		
		if (driver.findElement(element).isDisplayed()) {
			System.out.println("The element exists");
			return driver.findElement(element);
		}
		else {
			return null;
		}
		
	}
	
	public List<WebElement> findElements(By element) {

		return driver.findElements(element);
	}

	public String getElementText(By element) {
		try {
			if (driver.findElement(element).isDisplayed()) {
				System.out.println("The element exists");
				return driver.findElement(element).getText();
			}
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
		}
		return null;
	}


	public Boolean CheckLinkExists(By element) {
		
		try {
			if (driver.findElement(element).isEnabled()) {
				System.out.println("The element exists");
				return true;
			}
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
		}
		return null;
	}

	public void clickElement(WebElement element) {
		
		System.out.println("START: click Element value "+element);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
	        //System.out.println("The element is " +element.getText());
	        
	        //Wait.someSec(GlobalDataStore.WAIT_TIME);
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			clickableElement.click();
			
		} catch (StaleElementReferenceException e) {

			System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());

		} catch (NoSuchElementException e) {

			System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());
		} catch (Exception e) {
			
			System.out.println("Element does not exist " + e.getStackTrace());
		}
		
		System.out.println("END: click Element ");

	}
	
	
} // class end
