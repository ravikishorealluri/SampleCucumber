$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SignIn.feature");
formatter.feature({
  "line": 1,
  "name": "Validate Sign In Process",
  "description": "",
  "id": "validate-sign-in-process",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Launch Application and Verify Elements",
  "description": "",
  "id": "validate-sign-in-process;launch-application-and-verify-elements",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@VerifySignIn"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I should be on SignIn Page and I verify Page Title is \"Google\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I Verify Search Box is Available",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#        And I Enter User given Value in Search Box"
    }
  ],
  "line": 12,
  "name": "I Verify Search Box is Available and enter \"Selenium\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I Verify Gmail Link is Available and Click",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I read Excel file to get search values",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I read csv file to get search values",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 16,
      "value": "#        And I get all links available on the SignIn Page"
    }
  ],
  "line": 17,
  "name": "I Verify Search Box is Available and take a Screenshot when fails",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "validate-sign-in-process;launch-application-and-verify-elements;",
  "rows": [
    {
      "cells": [
        "UserId",
        "PassWord"
      ],
      "line": 20,
      "id": "validate-sign-in-process;launch-application-and-verify-elements;;1"
    },
    {
      "cells": [
        "",
        ""
      ],
      "line": 21,
      "id": "validate-sign-in-process;launch-application-and-verify-elements;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I set Browser Type and Environment Type from Configuration File",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I Launch Application in Specified Browser",
  "keyword": "And "
});
formatter.match({
  "location": "SignIn_Steps.iSetBrowserTypeAndEnvironmentTypeFromConfigurationFile()"
});
formatter.result({
  "duration": 220537400,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iLaunchApplicationInSpecifiedBrowser()"
});
formatter.result({
  "duration": 16355091800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Launch Application and Verify Elements",
  "description": "",
  "id": "validate-sign-in-process;launch-application-and-verify-elements;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@VerifySignIn"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I should be on SignIn Page and I verify Page Title is \"Google\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I Verify Search Box is Available",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#        And I Enter User given Value in Search Box"
    }
  ],
  "line": 12,
  "name": "I Verify Search Box is Available and enter \"Selenium\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I Verify Gmail Link is Available and Click",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I read Excel file to get search values",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I read csv file to get search values",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 16,
      "value": "#        And I get all links available on the SignIn Page"
    }
  ],
  "line": 17,
  "name": "I Verify Search Box is Available and take a Screenshot when fails",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Google",
      "offset": 55
    }
  ],
  "location": "SignIn_Steps.iShouldBeOnSignInPageAndIVerifyPageTitleIs(String)"
});
formatter.result({
  "duration": 32979700,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iVerifySearchBoxIsAvailable()"
});
formatter.result({
  "duration": 94936600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Selenium",
      "offset": 44
    }
  ],
  "location": "SignIn_Steps.iVerifySearchBoxIsAvailableAndEnter(String)"
});
formatter.result({
  "duration": 393759900,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iVerifyGmailLinkIsAvailableAndClick()"
});
formatter.result({
  "duration": 3462836900,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iReadExcelFileToGetSearchValues()"
});
formatter.result({
  "duration": 3207424400,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iReadCsvFileToGetSearchValues()"
});
formatter.result({
  "duration": 2001950400,
  "status": "passed"
});
formatter.match({
  "location": "SignIn_Steps.iVerifySearchBoxIsAvailableAndTakeAScreenshotWhenFails()"
});
formatter.result({
  "duration": 649926600,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.fail(Assert.java:95)\r\n\tat com.ravi.personal.steps.SignIn_Steps.iVerifySearchBoxIsAvailableAndTakeAScreenshotWhenFails(SignIn_Steps.java:166)\r\n\tat ✽.And I Verify Search Box is Available and take a Screenshot when fails(SignIn.feature:17)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 4856405100,
  "status": "passed"
});
});