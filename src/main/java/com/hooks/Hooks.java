package com.hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import com.base.Library;
import com.reusableFunctions.seleniumReusable;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Library{
	
	public static Scenario scenario;
	seleniumReusable sr;
	@Before
	public void test(Scenario scenario) throws IOException {
		this.scenario=scenario;
		launchingApplication();
	}
	@After
	public void cleanUp(Scenario scenario) {
		sr=new seleniumReusable(driver);
		sr.attachScreenShot(scenario);
		sr.trearDown();
	}
}
