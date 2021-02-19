package com.xebia.google.steps;

import com.xebia.google.pages.homePage;
import com.xebia.google.utils.confUtils;
import com.xebia.google.utils.getAppURL;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage_Steps extends confUtils {
//* Get the Application URL
    getAppURL getAppURL = new getAppURL();
    private homePage SignIn;
    String totalResults="";

    @Given("^I set Browser Type and Environment Type from Configuration File$")
    public void iSetBrowserTypeAndEnvironmentTypeFromConfigurationFile() {
  
    }

    @And("^I Launch Application in Specified Browser$")
    public void iLaunchApplicationInSpecifiedBrowser()  throws Throwable{
        getWebDriver(getProperties().getProperty("browser")).navigate().to(getAppURL.getApplicationURL(getProperties().getProperty("Environment")));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @Given("^I should be on SignIn Page and I verify Page Title is \"([^\"]*)\"$")
    public void iShouldBeOnSignInPageAndIVerifyPageTitleIs(String PageTiTle) throws Throwable {
        Assert.assertTrue(webDriver.getTitle().contains(PageTiTle));
        System.out.println("User Landed On Sign In Page and Page Title is : " + PageTiTle);
    }

    @And("^I Verify Search Box is Available and enter \"([^\"]*)\"$")
    public void iVerifySearchBoxIsAvailableAndEnter(String SearchValue) throws Throwable {
        SignIn = new homePage();
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOf(SignIn.getGoogleSearchInput()));
        Assert.assertTrue(SignIn.getGoogleSearchInput().isDisplayed());
        SignIn.getGoogleSearchInput().sendKeys(SearchValue);
        System.out.println("Search Input Box is Available On Sign In Page and Value Set is : " +SearchValue );
        SignIn.getGoogleSearchInput().sendKeys(Keys.ENTER);
    }

    @And("^I Verify Gmail Link is Available and Click$")
    public void iVerifyGmailLinkIsAvailableAndClick() {
        try{
//         Element#2
            Assert.assertTrue(SignIn.getGoogleGmailLink().isDisplayed()) ;
            System.out.println("Gmail Link Available.");
            SignIn.getGoogleGmailLink().click();
            System.out.println("Gmail Link Clicked.");
            Thread.sleep(2000);

        }catch (Exception e){
            System.out.println("Gmail Link NOT Available.");
        }

    }

    @And("^I Launch \"([^\"]*)\" in Specified Browser$")
    public void iLaunchInSpecifiedBrowser(String Application) throws Throwable {
        getWebDriver(getProperties().getProperty("browser")).navigate().to(Application);
        Thread.sleep(3000);
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @And("^I Verify Search Box is Available and take a Screenshot when fails$")
    public void iVerifySearchBoxIsAvailableAndTakeAScreenshotWhenFails() throws Exception {
       try{
           Assert.assertTrue(webDriver.findElement(By.cssSelector("div.a4bIc > inpu")).isDisplayed());
           System.out.println("Search Input Box is Available On Sign In Page.");
       } catch (Exception e) {
           System.out.println("Search Input Box is NOT Available On Sign In Page.please find attached Screenshot");
           getScreenshot("SearchInputBox");
           Assert.fail();
       }

    }

    @And("^I verify below List of WebElements are Available$")
    public void iVerifyBelowListOfWebElementsAreAvailable(List<String> WebElements) throws Exception {
        SignIn = new homePage();
        for(String ElementName:WebElements){
            switch (ElementName){
                case "Gmail Link":
                    isElementPresence(SignIn.getGoogleGmailLink(),ElementName);
                    break;
                case "Search Input":
                    isElementPresence(SignIn.getGoogleSearchInput(),ElementName);
                    break;
            }

        }
    }

    @And("^I capture the number of results displayed from google$")
    public void iCaptureTheNumberOfResultsDisplayedFromGoogle() {
        totalResults = webDriver.findElement(By.id("result-stats")).getText();
        String[] array =totalResults.split("results");
        totalResults =  array[0].replaceAll("[^0-9]", "");
    }

    @And("^I compare above total with database query result$")
    public void iCompareAboveTotalWithDatabaseQueryResult() {
        System.out.println("total results= "+totalResults);
    }

    @And("^I verify text \"([^\"]*)\" and I click on first result$")
    public void iVerifyTextAndIClickOnFirstResult(String searchValue) throws Throwable {

        try{
        List<WebElement> results = webDriver.findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3/span"));
        System.out.println("search Results Links: "+results.size() +", available On the Home Page.");
        Assert.assertTrue(results.get(0).getText().contains(searchValue));
        System.out.println("search Value : "+searchValue +", is available On the first search Result.");
        results.get(0).click();
        System.out.println("Clicked On the first search Result Link.");
        Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Search Results NOT Available On Home Page.please find attached Screenshot");
            getScreenshot("SearchResultsNotAvailable");
            Assert.fail();
        }

    }

}//* Close class

