package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.page.CreateDistrictPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import static com.maxsoft.webautomation.common.Base.getCurrentEpochTime;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Kushani Karunarathne
 * Version      : 1.0.0
 * Date         : 12/23/2018
 * Time         : 9:18 AM
 * Description  :
 **/


public class CreateDistrictPageStepImpl {

    private WebDriver driver = Driver.driver;
    private CreateDistrictPage createDistrictPage = PageFactory.initElements(driver, CreateDistrictPage.class);

    private static final String DISTRICT_NAME = "District Name";
    private static final String ADDRESS = "Address";
    private static final String EMAIL_DOMAIN = "Email Domain";
    private static final String REALAM = "Realam";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String EMP_NO = "EMP No";

    @Step("Fill district information <table>")
    public void createDistrict(Table table) {
        String currentEpochTime = "";
        for (TableRow row : table.getTableRows()) {
            currentEpochTime = getCurrentEpochTime();
            createDistrictPage.fillDistrictInfo(
                    // Basic Information Section
                    row.getCell(DISTRICT_NAME).concat(currentEpochTime),
                    row.getCell(ADDRESS),
                    row.getCell(EMAIL_DOMAIN),
                    row.getCell(REALAM),

                    // District Administrator Section
                    row.getCell(FIRST_NAME),
                    row.getCell(LAST_NAME).concat(currentEpochTime),
                    row.getCell(EMP_NO)
            );
            createDistrictPage.saveToScenarioDataStore("districtName", row.getCell(DISTRICT_NAME).concat(currentEpochTime));
        }
    }

    @Step("Submit district information")
    public void submit(){
        createDistrictPage.submit();
    }


}