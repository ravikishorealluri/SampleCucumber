package com.xebia.google.steps;

import cucumber.api.java.After;

import static com.xebia.google.utils.confUtils.webDriver;

public class hooks {

    @After
    public void tearDown() throws Throwable{

        webDriver.close(); //* Closes the Current Open Window
//        webDriver.quit(); //* closes all Browser Windows associated with Web driver and safely ends the session.
    }
}
