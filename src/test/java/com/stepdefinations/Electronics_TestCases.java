package com.stepdefinations;

import org.openqa.selenium.By;

import com.base.Library;
import com.pages.Electronis_Page;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Electronics_TestCases extends Library{
	
	Electronis_Page ep;
	seleniumReusable sr;
	
	
	@Given("user to move the Electronics link")
	public void user_to_move_the_electronics_link() throws InterruptedException {
	    ep=new Electronis_Page(driver);
	    sr=new seleniumReusable(driver);
	    
	    
	    sr.waits();
	    ep.moveToElectoronicsLink();
	    
	}

	@When("Cursor to move to the Laptop Accessories link")
	public void cursor_to_move_to_the_laptop_accessories_link() throws InterruptedException {
		sr.waits();
		ep.mouseMoveToLaptopAccessoriesLink();
	}

	@When("Move to Laptop Keyboards and click")
	public void move_to_laptop_keyboards_and_click() throws InterruptedException {
	    sr.waits();
	    ep.clickLaptopKeyBoardLink();
	}

	@When("click the price high to low link")
	public void click_the_price_high_to_low_link() throws InterruptedException {
		String text = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[1]")).getText();
		System.out.println("Before Filter: "+text);

		sr.waits();
		ep.clickPriceHighToLow();
	}

	@Then("It should display the relevent details and get the title")
	public void it_should_display_the_relevent_details_and_get_the_title() {
	    String title = driver.getTitle();
	    System.out.println(title);
		String text = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[1]")).getText();
		System.out.println("After Filter: "+text);
		
	    
	}

}
