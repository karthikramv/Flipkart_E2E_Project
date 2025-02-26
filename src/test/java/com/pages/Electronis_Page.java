package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

public class Electronis_Page extends Library {
	
	seleniumReusable sr;
	
	public Electronis_Page(RemoteWebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@aria-label='Electronics']")
	WebElement electronicsLink;
	
	@FindBy(linkText = "Laptop Accessories")
	WebElement labtopAccessoriesLink;
	
	@FindBy(linkText = "Laptop Keyboards")
	WebElement laptopKeyboardsLink;
	
	@FindBy(xpath = "//div[text()='Price -- High to Low']")
	WebElement priceHighToLow;
	
	public void moveToElectoronicsLink() {
		sr=new seleniumReusable(driver);
		sr.mouseHover(electronicsLink);
	}
	public void mouseMoveToLaptopAccessoriesLink() {
		sr.mouseHover(labtopAccessoriesLink);
	}
	public void clickLaptopKeyBoardLink() {
		sr.moveElement(laptopKeyboardsLink);
	}
	public void clickPriceHighToLow() {
		sr.click(priceHighToLow);
	}
	
	
	
	
}
