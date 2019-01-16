package com.maxsoft.webautomation.page;

import com.maxsoft.webautomation.util.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Kushani Karunarathne
 * Version      : 1.0.0
 * Date         : 01/03/2019
 * Time         : 2:18 AM
 * Description  :
 **/


public class CreateSchoolPage extends CommonPage {

    private static String LoginPageUrl = URL;
    private WebDriver driver = Driver.driver;

    // Main root level menu elements

    @FindBy(xpath = "//a[@class='btn btn-primary']" )
    private WebElement BTN_SCHOOL_CREATE;

    @FindBy(xpath = "//button[@class='btn btn-primary'][@title='Next']" )
    private WebElement BTN_NEXT;

     //School Registration section

    @FindBy(id = "schoolCode" )
    private WebElement TXT_SCHOOL_CODE;

    @FindBy(id = "schoolName" )
    private WebElement TXT_SCHOOL_NAME;

    @FindBy(id = "schoolKind" )
    private WebElement DROPDOWN_SCHOOL_KIND;

    @FindBy(id = "schoolType" )
    private WebElement DROPDOWN_SCHOOL_TYPE;

    @FindBy(id = "location" )
    private WebElement TXT_SCHOOL_ADDRESS;

    @FindBy(id = "line1" )
    private WebElement TXT_SCHOOL_ADDRESS_LINE1;

    @FindBy(id = "suburb" )
    private WebElement TXT_SCHOOL_SUBURB;

    @FindBy(id = "timezone" )
    private WebElement DROPDOWN_TIME_ZONE;

    @FindBy(id = "postCode" )
    private WebElement TXT_POSTAL_CODE;

    @FindBy(id = "state" )
    private WebElement TXT_STATE;

    @FindBy(id = "country" )
    private WebElement TXT_COUNTRY;

    @FindBy(css = "span.select2-search.select2-search--dropdown > input.select2-search__field]" )
    private WebElement DROPDOWN_TIME_ZONE_SEARCH_BOX;

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']" )
    private WebElement BTN_DISTRICT_ADMIN_NAVIGATION;

    //Contact Information section

    @FindBy(xpath = "techContactEmployeeNumber" )
    private WebElement TXT_STAFF_ID;

    @FindBy(xpath = "techContactFirstName" )
    private WebElement TXT_SCHOOL_ADMIN_FIRST_NAME;

    @FindBy(xpath = "techContactLastName" )
    private WebElement TXT_SCHOOL_ADMIN_LAST_NAME;

    @FindBy(xpath = "techContactPhone" )
    private WebElement TXT_PHONE;

    @FindBy(xpath = "techContactEmail" )
    private WebElement TXT_SCHOOL_ADMIN_EMAIL;

    @FindBy(xpath = "techContactEmailRepeat" )
    private WebElement TXT_SCHOOL_ADMIN_REPEAT_EMAIL;


    public CreateSchoolPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCreateSchool(){
        waitUntilLoadingCompleted();
        clickElement(BTN_SCHOOL_CREATE);
    }

    public void createSchool(String schoolCode, String schoolName, String schoolKind, String schoolType, String schoolAddress, String schoolAddressLine1, String suburb, String timeZone, String postalCode, String state, String country,
                             String staffId, String schoolAdminFirstName, String schoolAdminLastName, String phone, String schoolAdminEmail, String schoolAdminRepeatEmail) {

        //School Registration section
        waitUntilLoadingCompleted();
        closeSocialSideBarMenu();
        setTextAs(TXT_SCHOOL_CODE, schoolCode);
        setTextAs(TXT_SCHOOL_NAME, schoolName);
        selectFromDropdown(DROPDOWN_SCHOOL_KIND, schoolKind);
        selectFromDropdown(DROPDOWN_SCHOOL_TYPE, schoolType);
        setTextAs(TXT_SCHOOL_ADDRESS, schoolAddress);
        setTextAs(TXT_SCHOOL_ADDRESS_LINE1, schoolAddressLine1);
        setTextAs(TXT_SCHOOL_SUBURB, suburb);
        setTextAs(TXT_POSTAL_CODE, postalCode);
        setTextAs(TXT_STATE, state);
        setTextAs(TXT_COUNTRY, country);
        selectFromDropdown(DROPDOWN_TIME_ZONE, timeZone);
        clickElementByJavascriptExecutor(BTN_NEXT);

        //Contact Information section
        setTextAs(TXT_STAFF_ID, staffId);
        setTextAs(TXT_SCHOOL_ADMIN_FIRST_NAME, schoolAdminFirstName);
        setTextAs(TXT_SCHOOL_ADMIN_LAST_NAME, schoolAdminLastName);
        setTextAs(TXT_PHONE, phone);
        setTextAs(TXT_SCHOOL_ADMIN_EMAIL, schoolAdminEmail);
        setTextAs(TXT_SCHOOL_ADMIN_REPEAT_EMAIL, schoolAdminRepeatEmail);
        clickElement(BTN_NEXT);

    }


}
