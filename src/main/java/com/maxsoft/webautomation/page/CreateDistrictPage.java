package com.maxsoft.webautomation.page;

import com.maxsoft.webautomation.common.CommonPage;
import com.maxsoft.webautomation.util.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Kushani Karunarathne
 * Version      : 1.0.0
 * Date         : 12/23/2018
 * Time         : 9:08 AM
 * Description  :
 **/


public class CreateDistrictPage extends CommonPage {

    private WebDriver driver = Driver.driver;

    // Basic Information Section

    @FindBy(xpath = "//button[@class='btn btn-primary'][@title='Save']")
    private WebElement BTN_SAVE;

    @FindBy(xpath = "//button[@class='btn btn-default'][@title='Cancel']")
    private WebElement BTN_CANCEL;

    @FindBy(id = "district-name")
    private WebElement TXT_DISTRICT_NAME;

    @FindBy(id = "location")
    private WebElement TXT_ADDRESS;

    @FindBy(id = "select2-district-tz-container")
    private WebElement TXT_TIMEZONE;

    @FindBy(xpath = "//ul[@class='select2-results__options'][@id='select2-district-tz-results']/li[contains(text(), '(GMT+8:00) Australia/Perth')]")
    private WebElement DROPDOWN_TIME_SELECTION;

    @FindBy(id = "district-domain")
    private WebElement TXT_EMAIL_DOMAIN;

    @FindBy(id = "security-realm")
    private WebElement TXT_REALAM;

    @FindBy(xpath = "//span[contains(text(),'Select File')]")
    private WebElement BTN_SELECT_FILE;

    // Scholastic Years Section

    @FindBy(xpath = "//*[@id=\"navigation-panel\"]//a[text()='Scholastic Years']")
    private WebElement TAB_SCHOLASTIC_YEARS;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='year']")
    private WebElement TXT_YEAR;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='scholasticYear.startDate']")
    private WebElement TXT_START_DATE;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='scholasticYear.endDate']")
    private WebElement TXT_END_DATE;

    // District Administrator Section

    @FindBy(xpath = "//*[@id=\"navigation-panel\"]//a[text()='District Administrators']")
    private WebElement TAB_DISTRICT_ADMIN;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='firstName']")
    private WebElement TXT_FIRST_NAME;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='lastName']")
    private WebElement TXT_LAST_NAME;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='employeeNumber']")
    private WebElement TXT_EMPLOYEE_NO;

    @FindBy(xpath = "//input[@class='form-control'][@data-field-name='email']")
    private WebElement TXT_EMAIL;

    @FindBy(xpath = "//button[@class='btn btn-primary'][@title='Next']")
    private WebElement BTN_NEXT;

    @FindBy(xpath = "//button[@class='btn btn-primary'][@title='Submit']")
    private WebElement BTN_SUBMIT;


    public CreateDistrictPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillDistrictInfo(String districtName, String address, String emailDomain, String realam, String districtAdminFirstName, String districtAdminLastName,
                                 String districtAdminEmpNo) {
        // Basic Information Section
        waitUntilLoadingCompleted();
        waitUntilElementEnabled(BTN_SELECT_FILE);
        waitUntilElementClickable(BTN_NEXT);
        waitUntilElementClickable(BTN_SAVE);
        waitUntilElementClickable(BTN_CANCEL);
        setTextAs(TXT_DISTRICT_NAME, districtName);
        setTextAs(TXT_ADDRESS, address);
        setTextAs(TXT_EMAIL_DOMAIN, emailDomain);
        setTextAs(TXT_REALAM, realam);
        clickElement(BTN_NEXT);

        // Scholastic Years Section
        waitUntilToastMessageDisappeared();
        clickElement(BTN_NEXT);

        // District Administrator Section
        setTextAs(TXT_FIRST_NAME, districtAdminFirstName);
        setTextAs(TXT_LAST_NAME, districtAdminLastName);
        setTextAs(TXT_EMPLOYEE_NO, districtAdminEmpNo);

        String districtAdminEmail = districtAdminFirstName + "." + districtAdminLastName + "@" + emailDomain;
        setTextAs(TXT_EMAIL, districtAdminEmail);

        waitUntilToastMessageDisappeared();
    }

    public void submit(){
        clickElement(BTN_SUBMIT);
        waitUntilToastMessageDisappeared();
    }


}
