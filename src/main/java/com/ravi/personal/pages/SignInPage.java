package com.ravi.personal.pages;

import com.ravi.personal.pageObject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ravi.personal.utils.confUtils.webDriver;

public class SignInPage extends PageObject {
    public SignInPage() {  super(webDriver);    }

    @FindBy(css="div.a4bIc > input")
    public WebElement SearchInput;

    @FindBy(linkText="Gmai")
    public WebElement GmailLink;

    public WebElement getGoogleSearchInput(){return SearchInput;}
    public WebElement getGoogleGmailLink(){return GmailLink;}

}
