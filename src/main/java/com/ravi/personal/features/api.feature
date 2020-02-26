Feature: Validate Search API

    Background:
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
        And I set Headers as below
        |content-type |application/json|
        And I call the "GET" Method
        And I verify response Status Code as 200
        And I verify city "Hyderabad" present in response

    @SearchAPI
    Scenario: I Verify Error Codes in Search API Response
        Given Payload is "SearchErrorCodes"
        Then I "POST" the api call
        And I verify response Status Code as 201
        And I Close the Session "/cdxapi/cdxlogout"






