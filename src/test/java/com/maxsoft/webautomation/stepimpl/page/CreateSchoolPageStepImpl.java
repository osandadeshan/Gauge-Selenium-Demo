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
                    row.getCell(columnNames.get(0)).concat(currentEpochTime),
                    row.getCell(columnNames.get(1)).concat(currentEpochTime),
                    row.getCell(columnNames.get(2)),
                    row.getCell(columnNames.get(3)),
                    row.getCell(columnNames.get(4)),
                    row.getCell(columnNames.get(5)),

                    // Contact Information Section
                    row.getCell(columnNames.get(6)),
                    row.getCell(columnNames.get(7)),
                    row.getCell(columnNames.get(8)),
                    row.getCell(columnNames.get(9)),
                    row.getCell(columnNames.get(10)),
                    row.getCell(columnNames.get(11))
            );
            createSchoolPage.saveToScenarioDataStore("schoolName", row.getCell(columnNames.get(1)).concat(currentEpochTime));
        }
    }


}