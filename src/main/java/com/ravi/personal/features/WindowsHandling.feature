Feature: Validate Sign In Process

    Background:
        Given I set Browser Type and Environment Type from Configuration File
        And I Launch "http://toolsqa.com/automation-practice-switch-windows/" in Specified Browser

    @VerifyWindowsHandling
    Scenario Outline: Verify Windows Handling
        Given I click on Button

#        And I Verify Search Box is Available
#        And I Enter User given Value in Search Box
#        And I Verify Search Box is Available and enter "Selenium"
#        And I Verify Gmail Link is Available and Click
#        And I read Excel file to get search values
#        And I get all links available on the SignIn Page

        Examples:
            |UserId  |PassWord|
            |        |        |
