Feature: Validate Sign In Process

    Background:
        Given I set Browser Type and Environment Type from Configuration File
        And I Launch Application in Specified Browser

    @SearchOnHomePage
    Scenario: Launch Application, Search given value and verify
        Given I should be on SignIn Page and I verify Page Title is "Google"
        Then I Verify Search Box is Available and enter "ducks"
        And I capture the number of results displayed from google
        And I compare above total with database query result
        And I verify text "Ducks" and I click on first result

    @VerifySearchInputOnHomePage
    Scenario: Launch Application, Verify Search Input is Available on Home Page
        Given I should be on SignIn Page and I verify Page Title is "Google"
        Then I Verify Search Box is Available and take a Screenshot when fails