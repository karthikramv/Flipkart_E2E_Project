package com.reusableFunctions;

import java.io.File;

import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.base.Library;

import io.cucumber.java.Scenario;

public class seleniumReusable extends Library{

	Actions action;
	private static final Logger logger=LogManager.getLogger(seleniumReusable.class);
	public seleniumReusable(RemoteWebDriver driver) {
		this.driver=driver;
	}

	//	Enter the text of element 
	public void enterValue(WebElement element, String text) {
		try {
			element.sendKeys(text);
			logger.info("Entered Value");

		} catch (Exception e) {
			throw new RuntimeException("Element not found");
		}
	}
	//	click element
	public void click(WebElement element) {
		try {
			element.click();
			logger.info("clicked button");
		} catch (Exception e) {
			throw new RuntimeException("No such element");
		}
	}
	//	get the title of the page
	public void getTitle() {
		try {
			System.out.println(driver.getTitle());
			logger.info("title getted");
		} catch (Exception e) {
			throw new RuntimeException("Couldn't get the title");
		}
	}
	//	take the screenshot of the element
	public void screenshot(String path) {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotAs, new File(path));
			logger.info("screenshot takened");
		} catch (Exception e) {
			throw new RuntimeException("Couldn't take Screenshot");
		}
	}
	public void multipleGetText(List<WebElement> elements) {
		List<WebElement> text=elements;
		System.out.println(text.size());
		for (WebElement textCount: text) {
			String totalList = textCount.getText();
			logger.info("getting Multiple text");
			System.out.println("*********************************************");
			System.out.println(totalList);
		}
	}
	public void getValue(WebElement element) {
		String text = element.getText();
		logger.info("Single Element value is geted");
		System.out.println(text);
	}
	public void dropDown(WebElement element,String value) {
		Select drp=new Select(element);
		drp.selectByValue(value);
		logger.info("dropdown values showing");
	}
	public void scrollDown(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		logger.info("scrolldown done");
	}
	public void waits() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("waitted for 3 seconds");
	}
	public void mouseHover(WebElement element) {
		action=new Actions(driver);
		action.moveToElement(element).build().perform();
		logger.info("MouseHover action is done");
	}
	public void moveElement(WebElement element) {
		action.moveToElement(element).click().build().perform();
		logger.info("Element moved successfully");
	}
	public void windowsHandling(WebElement element) {
		String parentWindow = driver.getWindowHandle();
		element.click();
		logger.info("Clicked element");
		System.out.println("Parent window: "+parentWindow.toString());
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println("After No of window: "+allWindow.size());

		for (String childWindow : allWindow) {
			driver.switchTo().window(childWindow);
			logger.info("Move to new window");
		}
	}
	public void attachScreenShot(Scenario scenario) {
		boolean failed = scenario.isFailed();
		if (failed) {
			System.out.println("is failed");
			logger.info("Failed for the Scenario");
		}else {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "flipkart/png", scenario.getName() +scenario.getLine().toString());
			logger.info("Attached screenshot to the Extend report");
		}
	}
	public void closeUp() {
		driver.close();
		System.out.println("Browser closed");
		logger.info("Closed current window");
	}

	public void screenshotfilename(String path,String filename) {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotAs, new File(path,filename));
			logger.info("Screenshot taken");
		} catch (Exception e) {
			throw new RuntimeException("Couldn't take Screenshot");
		}
	}
}
