package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.examples.config.GlobalDataStore;

public class FirefoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		basicTest();
	}

	private static void basicTest() {
		// TODO Auto-generated method stub
		GlobalDataStore gds = new GlobalDataStore();
		
		gds.initParameters();
		
		String GeckoDriver=gds.GeckoDriver_MAC;
		String ChromeDriver=gds.ChromeDriver_MAC;
		String HomePage = gds.HomePage;
		
		System.out.println("The Home Page " + HomePage);
		System.out.println("The GeckoDriver " + GeckoDriver);
		
		//System.setProperty("webdriver.gecko.driver",  GeckoDriver);
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_MAC);
		WebDriver driver = new ChromeDriver();
		
		//String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		// launch fire fox and direct it to the Base URL
		driver.get(HomePage);
		
		//get actual value of the title
		actualTitle = driver.getTitle();
		actualTitle = actualTitle.trim();
		System.out.println("The actual title " + actualTitle);
		
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
			
		} else {
			System.out.println("Test Failed!");
		}
		
		//close fire fox
		//driver.close();
	}

}
