package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class GlobalDataStore {
	
	private static Logger logger;
	private Properties configFile = new Properties();
	public static String GeckoDriver_MAC;
	public static String ChromeDriver_MAC;
	public static String HomePage;
	public static String Guru99HomePage;
	public static String LogCategory;
	public static String Guru99ECOMPage;
	public static String Guru99LoginPage;
	public static String TestDataFile;
	
		/*
		 * Initialize log4j Appenders
		 */
		public static void setLogCategory(String LogFile) {
			LogCategory = LogFile;
			logger = Logger.getLogger(LogCategory);
		}

		public void initParameters() {
			
			String baseDir = System.getProperty("user.dir");
			
			String propFile = "selenium.properties";
			
			FileInputStream fis = null;
			
			System.out.println("GDS:initParameters() Base dir: " + baseDir);
			
			try {
				
				fis = new FileInputStream(baseDir + "/" + "src/test/resources/" + propFile);
				configFile.load(fis);
				
				GeckoDriver_MAC = configFile.getProperty("GECKO_DRIVER_MAC");
				ChromeDriver_MAC = configFile.getProperty("CHROME_DRIVER_MAC");
				
				HomePage = configFile.getProperty("BASE_URL");
				Guru99HomePage = configFile.getProperty("GURU99_HOMEPAGE");
				Guru99ECOMPage = configFile.getProperty("GURU99_ECOMPAGE");
				Guru99LoginPage = configFile.getProperty("GURU99_LOGINPAGE");
				TestDataFile = configFile.getProperty("TEST_DATA_FILE");
				
			} catch (FileNotFoundException e) {
				
				System.out.println("File not found" + e.getMessage());
				
			} catch (IOException e) {
				
				System.out.println("IO Exception " + e.getMessage());
			}
		} 
}
