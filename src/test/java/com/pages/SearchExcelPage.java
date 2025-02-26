package com.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;
import com.utilities.ExcelUtility;

public class SearchExcelPage extends Library {

	seleniumReusable se;
	ExcelUtility excel;

	public SearchExcelPage(RemoteWebDriver driver) {		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='Pke_EE']")
	WebElement searchText;
	
	@FindBy(xpath = "//*[@id='container']/div/div[2]/div/div")
	WebElement homepage;

	public void searchWithExcel() throws IOException, InterruptedException {
		excel=new ExcelUtility();
		se=new seleniumReusable(driver);
		
		for (int i = 1; i <=6; i++) {
			String excelReadData = excel.excelReadData("Sheet1", i, 0);
			se.enterValue(searchText, excelReadData);
			searchText.sendKeys(Keys.ENTER);
			System.out.println(excelReadData);
			se.screenshotfilename("./src/test/resources/screenshots/readExcelData/", excelReadData+".png");
			se.waits();
			if (homepage.isDisplayed()) {
				excel.excelWrite("Sheet1", i, 1, "pass");
			}else {
			excel.excelWrite("Sheet1", i, 1, "fail");
			}
			se.navigateBack();
		}
	}
}
