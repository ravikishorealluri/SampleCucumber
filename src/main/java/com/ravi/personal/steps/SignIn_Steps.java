package com.ravi.personal.steps;

import com.ravi.personal.pages.SignInPage;
import com.ravi.personal.utils.confUtils;
import com.ravi.personal.utils.getAppURL;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignIn_Steps extends confUtils {
//* Get the Application URL
    getAppURL getAppURL = new getAppURL();
    private SignInPage SignIn;
    private static final String ExcelFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\SearchValues.xlsx";
    public String screenShotFileName=null;
    private static final String csvFilePath =System.getProperty("user.dir")+"\\src\\main\\resources\\SearchVals.csv";
    public static Boolean isTestPassed=true;

    @Given("^I set Browser Type and Environment Type from Configuration File$")
    public void iSetBrowserTypeAndEnvironmentTypeFromConfigurationFile() throws Throwable{
  
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

    @And("^I Verify Search Box is Available$")
    public void iVerifySearchBoxIsAvailable() {
        Assert.assertTrue(webDriver.findElement(By.cssSelector("div.a4bIc > input")).isDisplayed());
        System.out.println("Search Input Box is Available On Sign In Page.");
    }

    @And("^I Enter User given Value in Search Box$")
    public void iEnterUserGivenValueInSearchBox() throws Throwable {
    String UserInput=getUserInput();
    webDriver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(UserInput);
    }

    @And("^I Verify Search Box is Available and enter \"([^\"]*)\"$")
    public void iVerifySearchBoxIsAvailableAndEnter(String SearchValue) throws Throwable {
        SignIn = new SignInPage();
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOf(SignIn.getGoogleSearchInput()));
        Assert.assertTrue(SignIn.getGoogleSearchInput().isDisplayed());
        SignIn.getGoogleSearchInput().sendKeys(SearchValue);
        System.out.println("Search Input Box is Available On Sign In Page and Value Set is : " +SearchValue );
    }

    @And("^I Verify Gmail Link is Available and Click$")
    public void iVerifyGmailLinkIsAvailableAndClick() throws InterruptedException {
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

    @And("^I read Excel file to get search values$")
    public void iReadExcelFileToGetSearchValues() throws FileNotFoundException, InterruptedException {
        List<String> searchValuesList = new ArrayList<>();
        searchValuesList = readExcel(ExcelFilePath);
        System.out.println("No. of Search Values got from Excel File are: "+searchValuesList.size());
        Thread.sleep(2000);
    }

    @And("^I get all links available on the SignIn Page$")
    public void iGetAllLinkAvailableOnTheSignInPage() throws InterruptedException {
        List<WebElement> Links = new ArrayList<>();
        List<String> LinksNames = new ArrayList<>();
        Links = webDriver.findElements(By.tagName("a"));
        System.out.println("Total No. of Links Available are: "+Links.size() +" On the SignIn Page.");
     //* Get all the Links Names
        for(WebElement link:Links){
            LinksNames.add(link.getText());
        }//* Close for
     //* Click and Verify all Links
        for(String linkName:LinksNames){
            Links = webDriver.findElements(By.tagName("a"));
            for(WebElement link:Links) {
                if(link.getText().contains(linkName)){
                    link.click();
                    System.out.println("Link: "+linkName +", is clicked On the SignIn Page.");
                    Thread.sleep(2000);
                    webDriver.navigate().back();
                    Thread.sleep(2000);
                    break;
                }
            }//* Close for
        }//* Close for

    }//* Close Method

    @And("^I Launch \"([^\"]*)\" in Specified Browser$")
    public void iLaunchInSpecifiedBrowser(String Application) throws Throwable {
//        Application="http://google.com";
        getWebDriver(getProperties().getProperty("browser")).navigate().to(Application);
        Thread.sleep(3000);
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Given("^I click on Button$")
    public void iClickOnButton() throws InterruptedException {
        String parentWindow = null;
        String childWindow = null;
        List<WebElement> clickElements = webDriver.findElements(By.id("button1"));

        for(WebElement ClickButton:clickElements)
        {
            ClickButton.click();
            Thread.sleep(1000);
            break;
        }

        List<String> WindowsList = new ArrayList<String>(webDriver.getWindowHandles());
            System.out.println("Windows Opened are: " + WindowsList.size());
            if(WindowsList.size()>1){
                parentWindow = WindowsList.get(0);
                childWindow = WindowsList.get(1);
                try{
                    if(webDriver.switchTo().window(childWindow).getCurrentUrl().contains("Link")){
                        System.out.println("Child Window Url Launched Successfully.");
                    }
                }catch(Exception e){
                    System.out.println("Child Window Url NOT Launched.");
                }
            //* Close Child Window
                webDriver.switchTo().window(childWindow).close();
                Thread.sleep(2000);
            //* Switch to main window
                webDriver.switchTo().window(parentWindow).close();
                Thread.sleep(2000);
            }

    }

    @And("^I Verify Search Box is Available and take a Screenshot when fails$")
    public void iVerifySearchBoxIsAvailableAndTakeAScreenshotWhenFails() throws Exception {
       try{
           Assert.assertTrue(webDriver.findElement(By.cssSelector("div.a4bIc > inpu")).isDisplayed());
//           webDriver.findElement(By.cssSelector("div.a4bIc > inpu")).isDisplayed();
           System.out.println("Search Input Box is Available On Sign In Page.");
       } catch (Exception e) {
           System.out.println("Search Input Box is NOT Available On Sign In Page.please find attached Screenshot");
           getScreenshot("SearchInputBox");
           Assert.fail();
       }

    }

    @And("^I read csv file to get search values$")
    public void iReadCsvFileToGetSearchValues() throws Throwable {
        List<String> searchValuesList = new ArrayList<>();
        searchValuesList = readCSV(csvFilePath);
        System.out.println("No. of Search Values got from CSV File are: "+searchValuesList.size());
        Thread.sleep(2000);
    }

    @And("^I verify below List of WebElements are Available$")
    public void iVerifyBelowListOfWebElementsAreAvailable(List<String> WebElements) throws Exception {
        SignIn = new SignInPage();
        for(String ElementName:WebElements){
            switch (ElementName){
                case "Gmail Link":
                    isElementPresence(SignIn.getGoogleGmailLink(),ElementName);
                    break;
                case "Search Input":
                    isElementPresence(SignIn.getGoogleSearchInput(),ElementName);
                    break;
                case "Search Value":
                    isElementPresence(SignIn.getGoogleSearchValue(),ElementName);
                    break;
            }

        }
    }



    @And("^I verify all above steps are passed$")
    public void iVerifyAllAboveStepsArePassed() {
        Assert.assertTrue(isTestPassed);
    }

    @Then("^I verify WebElements are Available$")
    public void iVerifyWebElementsAreAvailable() {
        List<WebElement> elementsList = webDriver.findElements(By.id("Name"));
        System.out.println("Size of Elements list is:"+elementsList.size());
    }


//    @Given("^I will be Printing \"([^\"]*)\"$")
//    public void iWillBePrinting(String printWord) throws Throwable {
//       System.out.println(printWord);
//    }
}//* Close class

