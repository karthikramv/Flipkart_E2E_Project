package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

public class MultipleSearch extends Library{

	seleniumReusable sr;
	public MultipleSearch(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='Pke_EE']")
	WebElement searchField;
	
	public void enterSearch(String searchText) {
		sr=new seleniumReusable(driver);
		sr.enterValue(searchField, searchText);
	}
	public void clickToSearch() {
		searchField.sendKeys(Keys.ENTER);
	}

}
