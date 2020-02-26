Feature: Validate Sign In Process

    Background:
        Given I set Browser Type and Environment Type from Configuration File
        And I Launch Application in Specified Browser

    @VerifySignIn
    Scenario Outline: Verify Error Messages when User try to Sign In with null UserID and Password
        Then I should be on SignIn Page and I verify Page T itle is "Google"
        And I Encrypt PassWord "Test@123"
        And I Decrypt PassWord
        And I verify below List of WebElements are Available
        |Gmail Link  |
        |Search Input|
        And I verify all above steps are passed

        Examples:
            |UserId  |PassWord|
            |        |        |
