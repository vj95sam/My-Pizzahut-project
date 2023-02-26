package com.simplilear.Testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(  plugin = "pretty", features = "src/test/cucumber/pizzahut.feature",glue={"com.simplilear.pizzahurtPorject"})	


public class Runnerfile {

}
