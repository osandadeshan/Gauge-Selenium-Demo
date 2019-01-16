package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.page.CreateSchoolPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.maxsoft.webautomation.common.Base.getCurrentEpochTime;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Kushani Karunarathne
 * Version      : 1.0.0
 * Date         : 01/03/2019
 * Time         : 2:18 AM
 * Description  :
 **/


public class CreateSchoolPageStepImpl {

    private WebDriver driver = Driver.driver;
    private CreateSchoolPage createSchoolPage = PageFactory.initElements(driver, CreateSchoolPage.class);

    private static final String SCHOOL_CODE = "School Code";
    private static final String SCHOOL_NAME = "School Name";
    private static final String SCHOOL_KIND = "School Kind";
    private static final String SCHOOL_TYPE = "School Type";
    private static final String SCHOOL_ADDRESS = "School Address";
    private static final String SCHOOL_ADDRESS_LINE1 = "School Address Line 1";
    private static final String SUBURB = "Suburb";
    private static final String TIMEZONE = "Time Zone";
    private static final String POSTAL_CODE = "Postal Code";
    private static final String STATE = "State";
    private static final String COUNTRY = "Country";
    private static final String STAFF_ID = "Staff Id";
    private static final String SCHOOL_ADMIN_FIRST_NAME = "School Admin First Name";
    private static final String SCHOOL_ADMIN_LAST_NAME = "School Admin Last Name";
    private static final String PHONE = "Phone";
    private static final String EMAIL = "Email";
    private static final String REPEAT_EMAIL = "Repeat Email";

    @Step("On School Creation page")
    public void navigateToCreateSchool(){
        createSchoolPage.navigateToCreateSchool();
    }

    @Step("Create a new school <table>")
    public void createSchool(Table table) {
        String currentEpochTime = "";
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : table.getTableRows()) {
            currentEpochTime = getCurrentEpochTime();
            createSchoolPage.createSchool(
                    // School Registration Section
                    row.getCell(SCHOOL_CODE).concat(currentEpochTime),
                    row.getCell(SCHOOL_NAME).concat(currentEpochTime),
                    row.getCell(SCHOOL_KIND),
                    row.getCell(SCHOOL_TYPE),
                    row.getCell(SCHOOL_ADDRESS),
                    row.getCell(SCHOOL_ADDRESS_LINE1),
                    row.getCell(SUBURB),
                    row.getCell(TIMEZONE),
                    row.getCell(POSTAL_CODE),
                    row.getCell(STATE),
                    row.getCell(COUNTRY),

                    // Contact Information Section
                    row.getCell(STAFF_ID),
                    row.getCell(SCHOOL_ADMIN_FIRST_NAME),
                    row.getCell(SCHOOL_ADMIN_LAST_NAME),
                    row.getCell(PHONE),
                    row.getCell(EMAIL),
                    row.getCell(REPEAT_EMAIL)
            );
            createSchoolPage.saveToScenarioDataStore("schoolName", row.getCell(columnNames.get(1)).concat(currentEpochTime));
        }
    }


}