Feature: Validate Search API
##
#    Background:
#        Given I set Base URL based on Environment type from config file
#        And I set "Search" api Base path
#        And I set API Endpoint URL using Base URL and Base path
#        And I set Authorization with given Username "File" and Password "File"
#        And I set Headers
#        |content-type |application/json|
#        |Authorization|                |
#        And I get and set the SessionID
#        And I call the GET Method
#        And I verify response Status Code as 200

#    @SearchAPI
    Scenario: Verify Search API Response
        Given I set "https://jsonplaceholder.typicode.com" Base URL
        And I set "posts" in Base path
        And I call the GET Method
        And I verify response Status Code as 200
        And I verify id value 97 present in response

