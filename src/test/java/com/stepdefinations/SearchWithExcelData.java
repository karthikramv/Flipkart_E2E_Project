package com.stepdefinations;

import java.io.IOException;

import com.base.Library;
import com.pages.SearchExcelPage;
import com.pages.SearchPage;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchWithExcelData extends Library {

	SearchExcelPage sep;
	seleniumReusable sr;

	@Given("enter search Text in the search field")
	public void enter_search_text_in_the_search_field() throws IOException, InterruptedException {
		sep = new SearchExcelPage(driver);
		sr = new seleniumReusable(driver);
		sep.searchWithExcel();

	}

	@When("click search icon")
	public void click_search_icon() throws IOException {

	}

	@Then("it should display the relevent result")
	public void it_should_display_the_relevent_result() {
		sr.getTitle();
	}

}
