package com.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBookHomePage {
	
	WebDriver driver;
	
	public FaceBookHomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void launchHomePage(String HomePage) {
		driver.get(HomePage);
		driver.manage().window().maximize();
	}
	
	//Get the title of Login Page
	public String getLoginTitle() {
		return  driver.getTitle();		
	}
	
	public WebElement findElementByxpath(String xpathString) {
		return driver.findElement(By.xpath(xpathString));
	}		
}