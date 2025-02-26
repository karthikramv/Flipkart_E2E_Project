package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/resources/features",
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"com.stepdefinations","com.hooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@reg"
		)

public class Runner extends AbstractTestNGCucumberTests{

}
