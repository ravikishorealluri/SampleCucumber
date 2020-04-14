package com.ravi.personal.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.ravi.personal.steps"},
        features={"src\\main\\java\\com\\ravi\\personal\\features"},
        tags={"@VerifySignIn"},
        plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber-reports/Cucumber.json" }
)
public class TestRunner {
    @BeforeClass
    public static void setup(){
        String reportOutput = File.separator +"html-reports";
    }

}
