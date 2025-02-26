package com.stepdefinations;

import org.openqa.selenium.By;

import com.base.Library;
import com.pages.TitleAndPrice;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TitleAndPrice_TestCases extends Library{
	
	seleniumReusable sr;
	TitleAndPrice tp;
	
	@Given("Enter the search text in the search field")
	public void enter_the_search_text_in_the_search_field() {
		sr=new seleniumReusable(driver);
		tp=new TitleAndPrice(driver);
		tp.enterSearchBox("shirts");
		
		
	}

	@When("Click the search icon")
	public void click_the_search_icon() {
	    tp.clickSearchIcon();
	    
	}

	@Then("it should display the search result and get the title and price")
	public void it_should_display_the_search_result_and_get_the_title_and_price() {
	    sr.multipleGetText(driver.findElements(By.xpath("//div[@class='hCKiGj']")));
	}

}
