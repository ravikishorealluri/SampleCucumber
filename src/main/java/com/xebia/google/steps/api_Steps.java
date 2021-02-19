package com.xebia.google.steps;

import com.xebia.google.utils.confUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class api_Steps extends confUtils {
    private Response response = null;

    @Given("^I set \"([^\"]*)\" Base URL$")
    public void iSetBaseURL(String BaseURL) {
        RestAssured.baseURI = BaseURL;
        System.out.println("Successfully set Base URL.");
    }

    @And("^I set \"([^\"]*)\" in Base path$")
    public void iSetCityInBasePath(String BasePath) {
       RestAssured.basePath = BasePath;
       System.out.println("Successfully set Base Path.");
    }

    @Then("^I call the GET Method$")
    public void iCallTheGetMethod() {
        response = RestAssured.get();
        System.out.println("Successfully Call the Get Method.");
    }

    @When("^I verify response Status Code as (\\d+)$")
    public void iVerifyResponseStatusCodeAs(int ResponseCode) {
//        assertThat(response.prettyPrint()+"\n",response.getStatusCode(), is(ResponseCode));
        assertThat(response.getStatusCode(), is(ResponseCode));
        System.out.println("Response Code : "+ResponseCode+" as Expected.");
    }

    @And("^I verify id value (\\d+) present in response$")
    public void iVerifyIdValuePresentInResponse(int totalRec) {
        assertThat(response.jsonPath().getList("id").get(totalRec-1), is(totalRec));
        System.out.println("id : "+totalRec+" is present in response.");
    }

}//* Close class

