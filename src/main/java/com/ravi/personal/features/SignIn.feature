Feature: Validate Sign In Process

    Background:
        Given I set Browser Type and Environment Type from Configuration File
        And I Launch Application in Specified Browser

    @VerifySignIn
    Scenario Outline: Verify Error Messages when User try to Sign In with null UserID and Password
        Given I should be on SignIn Page and I verify Page Title is "Google"
        And I Verify Search Box is Available
#        And I Enter User given Value in Search Box
        And I Verify Search Box is Available and enter "Selenium"
        And I Verify Gmail Link is Available and Click
        And I read Excel file to get search values
        And I read csv file to get search values
#        And I get all links available on the SignIn Page
#        And I Verify Search Box is Available and take a Screenshot when fails

        Examples:
            |UserId  |PassWord|
            |        |        |
