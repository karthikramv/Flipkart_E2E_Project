package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

public class FilterPage extends Library{

	seleniumReusable sp;

	public FilterPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@class='Gn+jFg'])[1]")
	WebElement minimumPrice;
	
	@FindBy(xpath = "(//select[@class='Gn+jFg'])[2]")
	WebElement maximumPrice;
	 
	@FindBy(xpath = "//div[text()='vivo']")
	WebElement brand;
	
	@FindBy(xpath = "//div[text()='6 GB']")
	WebElement ramEle;
	
	@FindBy(xpath = "//div[text()='Battery Capacity']")
	WebElement batteryArrow;
	
	@FindBy(xpath = "//div[text()='4000 - 4999 mAh']")
	WebElement batteryLevel;
	
	public void min() {
		sp=new seleniumReusable(driver);
		sp.dropDown(minimumPrice, "10000");
	}
	public void max() {
		sp.dropDown(maximumPrice, "30000");
	}
	public void brand() {
	sp.click(brand);
	}
	public void ram() {
		sp.scrollDown(ramEle);
	}
	public void clickBattery() {
		sp.scrollDown(batteryArrow);
		sp.click(batteryLevel);
	}
	
	


}
