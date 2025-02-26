package com.stepdefinations;

import com.base.Library;
import com.pages.UpToAddCartPage;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UptoAddCart_TestCases extends Library {
	
	seleniumReusable sr;
	UpToAddCartPage up;
	
	@Given("user can move to the login link")
	public void user_can_move_to_the_login_link() throws InterruptedException {
		up=new UpToAddCartPage(driver);
		sr=new seleniumReusable(driver);
		up.mouseMoveToLogin();
		System.out.println("Parent windows tittle");
		sr.getTitle();
	    
	}

	@When("user can click the flipkart plus zone")
	public void user_can_click_the_flipkart_plus_zone() throws InterruptedException {
	    sr.waits();
	    up.clickFlipkartPlusZone();
	    
	}

	@When("mouse move to the sports,Book&More link")
	public void mouse_move_to_the_sports_book_more_link() throws InterruptedException {
	    sr.waits();
	    up.mouseMoveToSportsBookLinkand();
	}

	@When("going to click cricket link")
	public void going_to_click_cricket_link() throws InterruptedException {
	    sr.waits();
	    up.clickCricketLink();
	    
	}

	@When("scroll down the page and click one particular result")
	public void scroll_down_the_page_and_click_one_particular_result() {
	    up.switchToChildWindow();
	    
	}

	@When("Enter delivery pincode and click the check link")
	public void enter_delivery_pincode_and_click_the_check_link() {
		System.out.println("Child window title");
		sr.getTitle();
	    up.enterInput();
	    up.clickCheckLink();
	    
	}

	@Then("pincode should be checked and displayed and verify the titles")
	public void pincode_should_be_checked_and_displayed_and_verify_the_titles() {
	    up.getDeliveryDetails();
	    sr.screenshot("src/test/resources/screenshots/UpToCart.png");
	    
	}

}
