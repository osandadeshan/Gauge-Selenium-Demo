package com.maxsoft.webautomation.common;

import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:10 PM
 * Description  :
 **/


public class Base {

    protected static String URL = System.getenv("application_endpoint");
    private String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static long timeout = Long.parseLong(System.getenv("timeout"));
    private WebDriver driver = Driver.driver;

    public Base(){
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementNotVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void setTextAs(WebElement element, String text){
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element){
        waitForElementClickable(element);
        element.click();
    }

    protected void clickElementByJavascriptExecutor(String xpath){
        WebElement element=driver.findElement(By.xpath(xpath));
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);
    }

    protected void clickLink(WebElement element){
        waitForElementVisible(element);
        element.click();
    }

    protected String getText(WebElement element){
        waitForElementVisible(element);
        return element.getText();
    }

    public void idle(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String testDataExcelFilePath(){
        String testDataExcelFilePath = "";
        try {
            testDataExcelFilePath = System.getenv("test_data_excel_file_path");
        } catch (Exception ex) {
           testDataExcelFilePath = "";
        }
        return CURRENT_DIRECTORY + File.separator + testDataExcelFilePath;
    }

    public void print(String text){
        System.out.println(text);
        Gauge.writeMessage(text);
    }


}
