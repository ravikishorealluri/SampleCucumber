package com.ravi.personal.utils;

public class getBasePath {
    public String getAPIBasePath(String APIEndPointURL) throws Exception{
        String apiURL="";
        switch (APIEndPointURL.toLowerCase()){
            case "search" :
                apiURL="https://www.google.com";
                break;
            case "Categories" :
                apiURL="https://www.yahoo.com";
                break;
            case "articles" :
                apiURL="https://www.Facebook.com";
                break;
            case "homepagemenus" :
                apiURL="https://www.Facebook.com";
                break;
        }//* Close Switch
        return apiURL;
    }//* Close Method
}//* Close Class
