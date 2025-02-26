package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

public class UpToAddCartPage extends Library{

	seleniumReusable sr;
	public UpToAddCartPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='_1jKL3b']")
	WebElement notificationLoginLink;
	
	@FindBy(xpath = "(//a[@class='_1TOQfO'])[1]")
	WebElement loginLink;

	@FindBy(linkText = "Flipkart Plus Zone")
	WebElement flipkartPlusLink;

	@FindBy(xpath = "//span[normalize-space(text())='Sports, Books & More']")
	WebElement sportsBookLink;

	@FindBy(linkText = "Cricket")
	WebElement cricketLink;

	@FindBy(xpath = "//a[text()='GLS Slogger Cricket Tennis Full Size with Free Tetron C...']")
	WebElement itemLink;

	@FindBy(id = "pincodeInputId")
	WebElement pincodeInput;

	@FindBy(xpath = "//span[text()='Check']")
	WebElement checkLink;

	@FindBy(xpath = "//div[@class='hVvnXm']")
	WebElement deliveryDetailsText;


	
	public void mouseMoveToLogin() throws InterruptedException {
		sr=new seleniumReusable(driver);
		sr.mouseHover(loginLink);
	}
	public void clickFlipkartPlusZone() {
		sr.moveElement(flipkartPlusLink);
	}
	public void mouseMoveToSportsBookLinkand () {
		sr.mouseHover(sportsBookLink);
	}
	public void clickCricketLink() {
		sr.moveElement(cricketLink);
	}
	
	public void clickOnResult() {
		sr.scrollDown(itemLink);
	}

	public void switchToChildWindow() {
		sr.windowsHandling(itemLink);
	}
	
	public void enterInput() {
		pincodeInput.sendKeys("621211");
	}
	public void clickCheckLink() {
		sr.click(checkLink);
	}
	public void getDeliveryDetails() {
		sr.getValue(deliveryDetailsText);
		
	}
}
