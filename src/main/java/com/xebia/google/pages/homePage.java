package com.xebia.google.pages;

import com.xebia.google.pageObject.PageObject;
import com.xebia.google.utils.confUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends PageObject {
    public homePage() {  super(confUtils.webDriver);    }

    @FindBy(css="div.a4bIc > input")
    public WebElement SearchInput;

    @FindBy(linkText="Gmail")
    public WebElement GmailLink;

    public WebElement getGoogleSearchInput(){return SearchInput;}
    public WebElement getGoogleGmailLink(){return GmailLink;}

}
