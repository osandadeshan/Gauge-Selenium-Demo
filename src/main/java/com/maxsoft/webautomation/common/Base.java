package com.maxsoft.webautomation.common;

import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


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
    private static final long TIMEOUT = Long.parseLong(System.getenv("timeout"));
    private static String testDataExcelFilePath = System.getenv("test_data_excel_file_path");

    private WebDriver driver = Driver.driver;

    public Base(){
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementEnabled(final WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsEnabled = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isEnabled();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
                catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        };
        wait.until(elementIsEnabled);
    }

    protected void waitUntilElementVisible(final WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementVisible(String xpathOfElement){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOfElement)));
    }

    protected void waitUntilElementInvisible(final WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isDisplayed();
                    return false;
                }
                catch (NoSuchElementException e ) {
                    return true;
                }
                catch (StaleElementReferenceException f) {
                    return true;
                }
            }
        };
        wait.until(elementIsDisplayed);
    }

    protected void setTextAs(WebElement element, String text){
        waitUntilElementClickable(element);
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element){
        waitUntilElementClickable(element);
        element.click();
    }

    protected void executeJavascript(String javascriptCode){
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript(javascriptCode);
    }

    protected void clickElementByJavascriptExecutor(String xpath){
        WebElement element=driver.findElement(By.xpath(xpath));
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);
    }

    protected void clickLink(WebElement element){
        waitUntilElementEnabled(element);
        element.click();
    }

    protected String getText(WebElement element){
        waitUntilElementEnabled(element);
        return element.getText();
    }

    public void idle(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void implicitlyWait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void scrollToElement(String xpathOfElement){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
//        actions.perform();
//        waitUntilElementEnabled(element);
        waitUntilElementVisible(xpathOfElement);
        WebElement element = driver.findElement(By.xpath(xpathOfElement));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String testDataExcelFilePath(){
        return CURRENT_DIRECTORY + File.separator + testDataExcelFilePath;
    }

    public static String getCurrentEpochTime(){
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public void print(String text){
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    public String getScenarioDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            String value = (String) scenarioStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Scenario Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public String getSpecificationDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            String value = (String) specDataStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Specification Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public String getSuiteDataStoreValue(String variableNameOfValueStoredInDataStore) {
        try {
            // Fetching Value from the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            String value = (String) suiteStore.get(variableNameOfValueStoredInDataStore);
            System.out.println("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            Gauge.writeMessage("Text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "] is: \"" + value + "\"" + "\n\n");
            return value;
        } catch (Exception ex) {
            System.out.println("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            Gauge.writeMessage("Failed to read the text inside Suite Data Store [" + variableNameOfValueStoredInDataStore + "]" + "\n\n");
            return "";
        }
    }

    public void saveToScenarioDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            scenarioStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Scenario Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToSpecificationDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            specDataStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Specification Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToSuiteDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        try {
            // Adding value to the Data Store
            DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
            suiteStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is successfully saved as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        } catch (Exception ex) {
            System.out.println("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
            Gauge.writeMessage("\"" + valueToBeStoredInDataStore + "\" is failed to save as a text in Suite Data Store [" + variableNameOfValueToBeStoredInDataStore + "]");
        }
    }

    public void saveToDataStore(String dataStoreType, String variableName, String valueToBeStored){
        switch (dataStoreType.toLowerCase()){
            case "spec":
                saveToSpecificationDataStore(variableName, valueToBeStored);
                break;
            case "specification":
                saveToSpecificationDataStore(variableName, valueToBeStored);
                break;
            case "scenario":
                saveToScenarioDataStore(variableName, valueToBeStored);
                break;
            case "suite":
                saveToSuiteDataStore(variableName, valueToBeStored);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
    }

    public String readFromDataStore(String dataStoreType, String variableName){
        String value = "";
        switch (dataStoreType.toLowerCase()){
            case "spec":
                value = getSpecificationDataStoreValue(variableName);
                break;
            case "specification":
                value = getSpecificationDataStoreValue(variableName);
                break;
            case "scenario":
                value = getScenarioDataStoreValue(variableName);
                break;
            case "suite":
                value = getSuiteDataStoreValue(variableName);
                break;
            default:
                Assert.fail("Please provide a valid data store type");
        }
        return value;
    }


}
