package com.guru99.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserPassword_DataProvider {

@Test(dataProvider="getData")
	
	public void instanceDbProvider(String User, String Password) {
		
		System.out.println("DataProvider " + "Example: Data(" + User + ", " + Password);
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		return new Object[][]{{"mngr146952", "muvequg"}};
	}
}
