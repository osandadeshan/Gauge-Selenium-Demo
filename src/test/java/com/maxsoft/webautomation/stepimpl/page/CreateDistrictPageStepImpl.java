package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.page.CreateDistrictPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import java.util.List;
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

    @Step("Create a new district <table>")
    public void createDistrict(Table table) {
        String currentEpochTime = "";
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : table.getTableRows()) {
            currentEpochTime = getCurrentEpochTime();
            createDistrictPage.createDistrict(
                    // Basic Information Section
                    row.getCell(columnNames.get(0)).concat(currentEpochTime),
                    row.getCell(columnNames.get(1)),
                    row.getCell(columnNames.get(2)),
                    row.getCell(columnNames.get(3)),

                    // District Administrator Section
                    row.getCell(columnNames.get(4)),
                    row.getCell(columnNames.get(5)).concat(currentEpochTime),
                    row.getCell(columnNames.get(6))
            );
            createDistrictPage.saveToScenarioDataStore("districtName", row.getCell(columnNames.get(0)).concat(currentEpochTime));
            currentEpochTime = "";
        }
    }


}