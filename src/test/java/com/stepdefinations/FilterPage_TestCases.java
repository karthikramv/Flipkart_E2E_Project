package com.stepdefinations;

import org.openqa.selenium.By;

import com.base.Library;
import com.pages.FilterPage;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.en.Then;

public class FilterPage_TestCases extends Library{
	FilterPage fp;
	seleniumReusable sp;
	@Then("Select Minimum and maximum price")
	public void select_minimum_and_maximum_price() throws InterruptedException {
		fp=new FilterPage(driver); 
		sp=new seleniumReusable(driver);

		String beforeFilter = driver.findElement(By.xpath("(//div[@class='yKfJKb row'])[1]")).getText();
		System.out.println("**************Before FIlter**********************\n"+beforeFilter);
		
		sp.waits();
		fp.min();
		sp.waits();
		fp.max();
	}

	@Then("Select the Brand")
	public void select_the_brand() throws InterruptedException {
		sp.waits();
		fp.brand();
	}

	@Then("Select the Ram")
	public void select_the_ram() throws InterruptedException {
		sp.waits();
		fp.ram();
	}

	@Then("Select the batteryCapcity")
	public void select_the_battery_capcity() throws InterruptedException {
		sp.waits();
		fp.clickBattery();

	}

	@Then("It should display relevent result")
	public void it_should_display_relevent_result() {
		String afterFilter = driver.findElement(By.xpath("(//div[@class='yKfJKb row'])[1]")).getText();
		System.out.println("**************After FIlter**********************\n"+afterFilter);
		

	}
}
