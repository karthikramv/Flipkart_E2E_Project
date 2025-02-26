package com.stepdefinations;

import com.base.Library;
import com.pages.MultipleSearch;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleSearch_TestCases extends Library{
	
	MultipleSearch ms;
	seleniumReusable sr;
	
	@Given("Enter the {string} in the search field")
	public void enter_the_in_the_search_field(String searchText) {
	    ms=new MultipleSearch(driver);
	    ms.enterSearch(searchText);
	    
	}

	@When("click the search button")
	public void click_the_search_button() {
	    ms.clickToSearch();
	    
	}

	@Then("It should navigate to the next page and display the corresponding page")
	public void it_should_navigate_to_the_next_page_and_display_the_corresponding_page() {
	    sr=new seleniumReusable(driver);
	    sr.getTitle();
	    System.out.println("*******************************************************");
	    sr.screenshot("src/test/resources/screenshots/search.png");
	}


}
