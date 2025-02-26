package com.stepdefinations;

import java.io.IOException;

import com.base.Library;
import com.pages.SearchPage;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchMobile_TestCases extends Library{

	SearchPage sp;
	seleniumReusable sr;

	@Given("launch the Flipkart Applcation")
	public void launch_the_flipkart_applcation() throws IOException {
		launchingApplication();
	}

	@When("close the popup")
	public void close_the_popup() {
		System.out.println(driver.getTitle());

	}

	@Then("It should navigate to the homepage")
	public void it_should_navigate_to_the_homepage() {
		System.out.println(driver.getTitle());
	}

	@Given("user enter the search product name")
	public void user_enter_the_search_product_name() {
		sp=new SearchPage(driver);
		sp.search("mobile");
	}

	@When("click a search button")
	public void click_a_search_button() {
		sp.clickSearch();

	}

	@Then("it should navigate to the search result page and display the relevent details")
	public void it_should_navigate_to_the_search_result_page_and_display_the_relevent_details() {
		sp.result();
		sr=new seleniumReusable(driver);
		try {
			sr.waits();
		} catch (InterruptedException e) {
			System.err.println("result not found");
		}

	}
	@Then("Extract the results and print in console")
	public void extract_the_results_and_print_in_console() {
	   sp.printEntireResult();
	}

	@Then("print the thrid result and keep it in console")
	public void print_the_thrid_result_and_keep_it_in_console() {
		sp.print3rdResult();
	}	


}
