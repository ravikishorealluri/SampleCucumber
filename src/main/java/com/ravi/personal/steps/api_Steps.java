package com.ravi.personal.steps;

import com.ravi.personal.utils.confUtils;
import com.ravi.personal.utils.getAppURL;
import com.ravi.personal.utils.getBasePath;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class api_Steps extends confUtils {
//* Get the Application URL
    private RestAssured restAssured;
    getBasePath apiBasePath = new getBasePath();
    public String baseURL;
    public String basePath;
    private Response response = null;
    private RequestSpecification httpRequest;
    JSONObject requestJasonPayload = new JSONObject();
    JSONObject requestJasonHeaders = new JSONObject();
    private Map<String,String> apiHeaders =new HashMap<>();
    String requestPayload = "()";
    public String strAuthorization;
    public String responseHdrSessionID;
    public String apiURL;
    public String EncryptedPassword;
    public static Boolean isTestPassed=true;
    getAppURL getAppURL = new getAppURL();
    private String strID;

    @Given("^I set Base URL based on Environment type from config file$")
    public void iGetBaseURLBasedOnEnvironmentTypeFromConfigFile() {

    }

    @And("^I set \"([^\"]*)\" api Base path$")
    public void iGetApiBasepath(String basePath) throws Throwable {
        RestAssured.basePath = basePath;
    }

    @Given("^I set API Endpoint URL using Base URL and Base path$")
    public void iSetAPIUsingBaseURLAndEndPointURL()throws Throwable {
        RestAssured.baseURI = getAppURL.getApplicationURL(getProperties().getProperty("Environment"))+"/"+basePath;
        System.out.println("API URL is:" +apiURL);
        Thread.sleep(200);
    }

    @And("^I set Authorization with given Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void iSetAuthorizationWithGivenUsernameAndPassword(String userName, String Password) throws Throwable {
        if((userName.toLowerCase().contains("file"))&&(userName.toLowerCase().contains("file"))){
            userName= getProperties().getProperty("UserName");
            Password = decrypt(getProperties().getProperty("password"));
            System.out.println("User Name is: "+userName+" and PassWord is: "+Password);
        }
    }

    @And("^I Encrypt PassWord \"([^\"]*)\"$")
    public void iEncryptPassWord(String Password) throws Throwable {
         EncryptedPassword = encrypt(Password);
        System.out.println("Encrypted PassWord is: "+EncryptedPassword);
    }

    @And("^I Decrypt PassWord$")
    public void iDecryptPassWord() {
        String DecryptedPassword = decrypt(EncryptedPassword);
        System.out.println("Decrypted PassWord is: "+DecryptedPassword);
    }

    @And("^I set Headers$")
    public void iSetHeaders(Map<String,String> apiHeaders) throws Throwable {
//        apiHeaders.clear();
        for(Map.Entry<String,String> entry: apiHeaders.entrySet()){
            apiHeaders.put(entry.getKey(),entry.getValue());
        }
    //* Set Authorization
        if(apiHeaders.containsKey("Authorization") && strAuthorization != null){
            apiHeaders.replace("Authorization",strAuthorization);
        }
    //* Set SessionID
        if(apiHeaders.containsKey("SessionId") && strAuthorization != null){
            apiHeaders.replace("SessionId",responseHdrSessionID);
        }
    }

    @And("^I get and set the SessionID$")
    public void iGetAndSetTheSessionID() throws Throwable{
        getSessionID();
        System.out.println("Session ID is: "+responseHdrSessionID);
    }
    public void getSessionID() throws JsonException {
        if(null==responseHdrSessionID) {
            restAssuredOperation("POST");
            if (response.getStatusCode() == 401 &&
                    response.jsonPath().getString("message.errorMessage[0]").equalsIgnoreCase("Multiple Sessions found for the user.")) {
                    getSessionID();
            }//* Close If
            responseHdrSessionID = response.getHeader("x-fnm-sessionId");
        }//* Close If
        requestJasonHeaders.put("x-fnm-sessionId",responseHdrSessionID);
    }

    public void restAssuredHTTPRequest(){
       RestAssured.baseURI = baseURL;
       RestAssured.basePath = basePath;
        httpRequest =
           RestAssured.given()
           .urlEncodingEnabled(false)
            .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .headers(apiHeaders)
            .proxy("proxy.fanniemae.com",10479)
            .relaxedHTTPSValidation();
    }

    public void restAssuredOperation(String Operation){
        restAssuredHTTPRequest();
        switch (Operation){
            case "POST":
                try{
                    response = httpRequest.body(requestPayload).post();
                }catch (Exception e){
                    System.out.println("There is a Problem in POST Request.");
                    e.printStackTrace();
                }
                break;
            case "PUT":
                try{
                    response = httpRequest.body(requestPayload).put();
                }catch (Exception e){
                    System.out.println("There is a Problem in PUT Request.");
                    e.printStackTrace();
                }
                break;
            case "GET":
                try{
                    response = httpRequest.body(requestPayload).get();
                }catch (Exception e){
                    System.out.println("There is a Problem in GET Request.");
                    e.printStackTrace();
                }
                break;
        }

    }

    @Then("^I call the GET Method$")
    public void iCallTheGetMethod() throws Throwable {
        response = RestAssured.get();
    }

    @When("^I verify response Status Code as (\\d+)$")
    public void iVerifyResponseStatusCodeAs(int ResponseCode) throws Throwable {
    assertThat(response.prettyPrint()+"\n",response.getStatusCode(), is(ResponseCode));
    }

    @Then("^I verify city \"([^\"]*)\" present in response$")
    public void iVerifyCityPresentInResponse(String CityName) throws Throwable {
//         List<Map<String,String>> Cities = response.jsonPath().get("City");
//         Map<String,String> resultMap = new HashMap<>();
//
//         for(Map<String,String> singlecity : Cities){
//             if(singlecity.get("name").equalsIgnoreCase("Hyderabad")){
//                 resultMap.put("Hydtemp",singlecity.get("Temperature") );
//                 resultMap.put("HydHumidity",singlecity.get("Humidity") );
//                break;
//             }
//         }
        //sysout --  resultMap
        assertThat(response.jsonPath().get("City"), is(CityName));
    }

    @Given("^I set \"([^\"]*)\" Base URL$")
    public void iSetBaseURL(String BaseURL) throws Throwable {
        RestAssured.baseURI = BaseURL;
    }

    @And("^I set City \"([^\"]*)\" in Base path$")
    public void iSetCityInBasePath(String BasePath) throws Throwable {
       RestAssured.basePath = BasePath;
    }

    @And("^I set Headers as below$")
        public void iSetHeadersAsBelow(Map<String,String> apiHeaders) throws Throwable {
        RestAssured.given().headers(apiHeaders);
    }


    @Given("^Payload is \"([^\"]*)\"$")
    public void payloadIs(String routeCall) throws Throwable {
        requestPayload = System.getProperty("user.dir")+"\\src\\main\\java\\com\\ravi\\personal\\payload\\"+routeCall+".json";
        if(requestPayload.contains("ID")){
            requestPayload = requestPayload.replaceFirst("ID",strID);
        }
        System.out.println("Request Payload is: " +requestPayload);

    }

    @Then("^I \"([^\"]*)\" the api call$")
    public void iTheApiCall(String MethodName) throws Throwable {
        restAssuredOperation(MethodName);
        if (response.getStatusCode() == 401 &&
                response.jsonPath().getString("message.errorMessage[0]").equalsIgnoreCase("Multiple Sessions found for the user.")) {
        }//* Close If
    }

    @And("^I Close the Session \"([^\"]*)\"$")
    public void iCloseTheSession(String arg0) throws Throwable {
       response = httpRequest.body("{}").when().post();
    }

    @And("^I call the POST Method$")
    public void iCallThePOSTMethod() {
        response = RestAssured.post();
    }
}//* Close class

