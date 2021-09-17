package com.logiciel.cucumber.run;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//tags = "@SmokeTest and not @RegressionTest", 
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",  glue = "com.logiciel.cucumber.steps", plugin = ("json:target/cucumber.json"), monochrome = true)
public class RunLogiFTPCucumber extends AbstractTestNGCucumberTests {

}