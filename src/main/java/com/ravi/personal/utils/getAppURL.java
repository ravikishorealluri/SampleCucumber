package com.ravi.personal.utils;

public class getAppURL {
    public String getApplicationURL(String appEnvironment) throws Exception{
        String appURL="";
        switch (appEnvironment.toLowerCase()){
            case "dev" :
                appURL="https://www.google.com";
                break;
            case "test" :
                appURL="https://www.yahoo.com";
                break;
            case "uat" :
                appURL="https://www.Facebook.com";
                break;
        }//* Close Switch
        return appURL;
    }//* Close Method
}//* Close Class
