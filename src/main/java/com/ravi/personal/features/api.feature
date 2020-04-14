Feature: Validate Search API
#
#    Background:
        Given I set Base URL based on Environment type from config file
        And I set "Search" api Base path
        And I set API Endpoint URL using Base URL and Base path
        And I set Authorization with given Username "File" and Password "File"
        And I set Headers
        |content-type |application/json|
        |Authorization|                |
        And I get and set the SessionID

#    @WeatherAPI
    Scenario: Verify Weather by city API Response
        Given I set "http://restapi.demoqa.com/utilities/weather/city/" Base URL
        And I set City "Delhi" in Base path
        And I call the GET Method
        And I verify response Status Code as 200
        And I verify city "Delhi" present in response

#    @CreateAPI
    Scenario: I Verify New Value Created
        Given I set "http://restapi.demoqa.com/utilities/weather/city/" Base URL
        And I set City "Delhi" in Base path
        And I call the POST Method
        And I verify response Status Code as 201
        And I verify city "Delhi" present in response






