package com.maxsoft.webautomation.pages;

import com.maxsoft.webautomation.common.CommonPage;
import com.maxsoft.webautomation.util.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.AccessDeniedException;

public class CreateDistrictPage extends CommonPage {

    private static String LoginPageUrl = URL;
    private WebDriver driver = Driver.driver;

    // Basic Information section

    @FindBy(id = "district-name")
    private WebElement TXT_DISTRICTNAME;

    @FindBy(id = "location")
    private WebElement TXT_ADDRESS;

    @FindBy(id = "select2-district-tz-container")
    private WebElement TXT_TIMEZONE;

    @FindBy(xpath = "//ul[@class='select2-results__options'][@id='select2-district-tz-results']/li[contains(text(), '(GMT+8:00) Australia/Perth')]")
    private WebElement DRPDWN_TIMESELECTION;

    @FindBy(id = "district-domain")
    private WebElement TXT_EMAILDOMAIN;

    @FindBy(id = "security-realm")
    private WebElement TXT_REALAM;

    //Scholastic Years section

    @FindBy(xpath = "//*[@id=\"navigation-panel\"]//a[text()='Scholastic Years']")
    private WebElement BTN_SCHYEARNAVIGATION;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='year']")
    private WebElement TXT_YEAR;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='scholasticYear.startDate']")
    private WebElement TXT_STARTDATE;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='scholasticYear.endDate']")
    private WebElement TXT_ENDDATE;

    // District Administrator section

    @FindBy(xpath = "//*[@id=\"navigation-panel\"]//a[text()='District Administrators']")
    private WebElement BTN_DISTRICTADMINNAVIGATION;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='firstName']")
    private WebElement TXT_FIRSTNAME;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='lastName']")
    private WebElement TXT_LASTNAME;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='employeeNumber']")
    private WebElement TXT_EMPLOYEENO;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='email']")
    private WebElement TXT_EMAIL;

    @FindBy(xpath = "//button[@title='Next']")
    private WebElement BTN_NEXT;

    @FindBy(xpath = "//button[@class='btn btn-primary'][@title='Submit']")
    private WebElement BTN_SUBMIT;



    public CreateDistrictPage() {
        PageFactory.initElements(driver, this);
    }

    public void createDistrict(String districtname, String address, String emaildomain, String realam, String firstname, String lastname, String empno, String email) {

        waitUntilLoadingCompleted();
        setTextAs(TXT_DISTRICTNAME, districtname);
        setTextAs(TXT_ADDRESS, address);
        //setTextAs(TXT_TIMEZONE, timezone);
        setTextAs(TXT_EMAILDOMAIN, emaildomain);
        setTextAs(TXT_REALAM, realam);
        clickElement(BTN_NEXT);

        waitUntilLoadingCompleted();
        //setTextAs(TXT_YEAR, year);
        //setTextAs(TXT_STARTDATE, startdate);
        //setTextAs(TXT_ENDDATE, enddate);
        waitUntilToastMessageDisappeared();
        clickElement(BTN_NEXT);

        waitUntilLoadingCompleted();
        setTextAs(TXT_FIRSTNAME, firstname);
        setTextAs(TXT_LASTNAME, lastname);
        setTextAs(TXT_EMPLOYEENO, empno);
        setTextAs(TXT_EMAIL, email);
        clickElement(BTN_SUBMIT);

    }



}
