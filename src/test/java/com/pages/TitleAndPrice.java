package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

public class TitleAndPrice extends Library{

	seleniumReusable sr;
	public TitleAndPrice(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "q")
	WebElement searchInput;
	
	@FindBy(xpath = "//button[@class='_2iLD__']")
	WebElement searchIcon;
	
	
	public void enterSearchBox(String text) {
		sr=new seleniumReusable(driver);
		sr.enterValue(searchInput, text);
	}
	
	public void clickSearchIcon() {
		sr.click(searchIcon);
	}
	
	
	
}
