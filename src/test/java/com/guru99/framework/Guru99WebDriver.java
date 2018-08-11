package com.guru99.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Guru99WebDriver {
	
	void init(String Browser);
	
	Boolean navigateTo(final String relativeURL);
	
	// Quits the web driver
	void quitDriver();
	
	//closes browser window
	void closeBrowser();
	
	WebElement FindElement(By element);
	
	List<WebElement> findElements(By element);
	
	public void clickElement(WebElement element);
	
	public String getElementText(By element);
	
	public Boolean CheckLinkExists(By element);

}
