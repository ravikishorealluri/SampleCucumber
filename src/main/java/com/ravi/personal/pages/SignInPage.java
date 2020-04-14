package com.ravi.personal.pages;

import com.ravi.personal.pageObject.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ravi.personal.utils.confUtils.webDriver;

public class SignInPage extends PageObject {
    public SignInPage() {  super(webDriver);    }

    @FindBy(css="div.a4bIc > input")
    public WebElement SearchInput;

    @FindBy(linkText="Gmail")
    public WebElement GmailLink;

    @FindBy(css = "div.a4bIc > inpu")
    public WebElement SearchValue;

    public WebElement getGoogleSearchInput(){return SearchInput;}
    public WebElement getGoogleGmailLink(){return GmailLink;}
    public WebElement getGoogleSearchValue(){return SearchValue;}

}
