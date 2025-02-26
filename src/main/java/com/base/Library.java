package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Library {

	public static RemoteWebDriver driver=null;
	public static Properties prop=null;
	protected static Logger logger;

	@Test
	public void launchingApplication() throws IOException {
		FileInputStream input=new FileInputStream("src/test/resources/properties/config.property");
		prop=new Properties();
		prop.load(input);
		Logger logger=LogManager.getLogger(Library.class);
		logger.info("Launching the browser....");
		try {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
				logger.info("Browser launched sucessfully");
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
				logger.info("Browser launched sucessfully");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
			logger.info("Navigated to the flipkart homepage");
			
		} catch (Exception e) {
			System.out.println("Browser not define");
		}
	}
	public void trearDown() {
		driver.quit();
	}
	public void navigateBack() {
		driver.navigate().back();
	}
}
