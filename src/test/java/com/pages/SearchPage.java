package com.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;
import com.utilities.ExcelUtility;

import io.cucumber.java.Scenario;

public class SearchPage extends Library {

	seleniumReusable se;

	public SearchPage(RemoteWebDriver driver) {		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='Pke_EE']")
	WebElement searchText;

	@FindBy(xpath = "//html[@lang='en-IN']")
	WebElement homepage;

	@FindBy(xpath = "//html[@lang= 'en']")
	WebElement searchResult;

	@FindBy(xpath = "//div[@class='_75nlfW']")
	List<WebElement> entireResult;

	@FindBy(xpath = "(//div[@class='yKfJKb row'])[3]")
	WebElement thirdResult;

	public void search(String text) {
		se=new seleniumReusable(driver);
		se.enterValue(searchText, text);
	}
	public void clickSearch() {
		searchText.sendKeys(Keys.ENTER);
	}
	public void homescreen() {
		Assert.assertEquals(homepage.isDisplayed(), true);
		System.out.println(homepage.isDisplayed());
	}
	public void result() {
		System.out.println(searchResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	public void printEntireResult() {
		se.multipleGetText(entireResult);
	}
	public void print3rdResult()
	{
		System.out.println("*******************Third result******************************");
		se.getValue(thirdResult);
	}
	public void attachScreenshot(Scenario scenario ) {
		se.attachScreenShot(scenario);
	}

}
