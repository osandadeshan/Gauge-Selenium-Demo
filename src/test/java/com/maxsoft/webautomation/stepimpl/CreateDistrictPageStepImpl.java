package com.maxsoft.webautomation.stepimpl;

import com.maxsoft.webautomation.pages.CreateDistrictPage;
import com.maxsoft.webautomation.pages.LoginPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

import java.util.List;


public class CreateDistrictPageStepImpl {

    private WebDriver driver = Driver.driver;
    private CreateDistrictPage createDistrictPage = PageFactory.initElements(driver, CreateDistrictPage.class);


    @Step("Create a new District Fill Information <table>")
    public void createDistrict(Table table) {
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : table.getTableRows()) {
            createDistrictPage.createDistrict(
                    row.getCell(columnNames.get(0)),
                    row.getCell(columnNames.get(1)),
                    row.getCell(columnNames.get(2)),
                    row.getCell(columnNames.get(3)),
                    row.getCell(columnNames.get(4)),
                    row.getCell(columnNames.get(5)),
                    row.getCell(columnNames.get(6)),
                    row.getCell(columnNames.get(7))
            );
        }
    }
}