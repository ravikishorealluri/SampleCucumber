package com.xebia.google.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class confUtils {
//* Variables
    public static WebDriver webDriver;
    public static Properties propertiesInfo=new Properties();
    private static File PropertyFilePath = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Configuration.properties");
    public static String userInput;

//* Get Property File
    public static Properties getProperties() throws Throwable{

            try{
                InputStream input = new FileInputStream(PropertyFilePath);
                propertiesInfo.load(input);
            }
            catch (Exception e){
                System.out.println("Properties Configuration file path is null.");
            }

        return propertiesInfo;
    }

//* Get WebDriver
    public static WebDriver getWebDriver(String browserName) throws Throwable{
//        String browserName= getProperties().getProperty("browser");
        switch (browserName.toLowerCase()){
            case "chrome" :
//                System.setProperty("webdriver."+browserName.toLowerCase() +".driver","C:\\BrowserDrivers\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "ie" :
                System.setProperty("webdriver."+browserName.toLowerCase() +".driver","C:\\BrowserDrivers\\IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver","C:\\BrowserDrivers\\geckodriver.exe");
                webDriver = new FirefoxDriver();
        break;
        }
        return webDriver;
    }

//* Get User Input
    public static String getUserInput() throws Throwable{

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.promptResponse=prompt('Please enter the USER Input ')");
        isAlertPresent();
        String userInput = (String) js.executeScript("return window.promptResponse");
        Thread.sleep(2000);
        return userInput;
    }
//* Alerts
    private static void isAlertPresent() {
        try
        {
            webDriver.switchTo().alert();
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // even though not needed

            isAlertPresent();
        }   // try
        catch (NoAlertPresentException Ex)
        {

        }
    }

//* Encrypt Password
    public static String encrypt(String encryptStr){
        String encryptedString = null;
        encryptedString = Base64.encodeBase64String(encryptStr.getBytes());
        return encryptedString;
    }//* Close Encrypt Password

//* Decrypt Password
    public static String decrypt(String decryptStr){
        String decryptedString = null;
        if(StringUtils.isNotBlank(decryptStr) && Base64.isBase64(decryptStr))
        decryptedString = new String(Base64.decodeBase64(decryptStr));
        return decryptedString;
    }//* Close Decrypt Password

//* Read Excel
    public List readExcel(String ExcelFilePath) throws FileNotFoundException  {
        List<String> rowInfoList = new ArrayList<>();
        try {
//            ClassLoader classLoader =this.getClass().getClassLoader();
            FileInputStream excelFile = new FileInputStream(new File(ExcelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet workSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = workSheet.iterator();

            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                if(currentRow.getRowNum()>0){
                    rowInfoList.add(getCellInfo(currentRow).toString());
                }//Close if
            }//* Close While
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowInfoList;

    }//* Close Read Excel Method

//* Get Cell Info of a Row from Excel
    public List getCellInfo(Row row){
        List<String> RowInfoList = new ArrayList<>();
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            RowInfoList.add(cell.toString());
        }
        return RowInfoList;
    } //* Close Method

//* Verify Element is Present
    public void isElementPresence( WebElement Element,String ElementName) throws Exception {

        try{
            Element.isDisplayed();
            System.out.println("Element Name: "+ElementName+" is Available.");
        }catch (Exception e){
            System.out.println("Element Name: "+ElementName+" is NOT Available.Please Refer Screenshot...");
            getScreenshot(ElementName);
        }

    }
//* Get a Screenshot
    public static void getScreenshot(String screenShotFileName) throws Exception
    {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\ScreenShots\\"+screenShotFileName+".png"));
    }

//* Read CSV
    public List readCSV(String csvFilePath) throws Throwable{
        List<String> csvFileInfoList = new ArrayList<>();
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            String newLine;
            while ((newLine = br.readLine()) != null) {
                newLine = br.readLine();
                csvFileInfoList.add(newLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            br.close();
        }
        return csvFileInfoList;
    }

    public int getRandomNum(int min, int max) {
        Random rand = new Random();
        int randomNum = min + rand.nextInt((max - min) + 1);
        return randomNum;
    }
    public String getReverseString(String Input){
        String outPut = new StringBuffer(Input).reverse().toString();
        return outPut;
    }
    public void performAction(WebElement LoanStep) throws Throwable {
        Actions action = new Actions(getWebDriver(getProperties().getProperty("browser"))) ;
        action.moveToElement(LoanStep).build().perform();
    }

}//* Close Class
