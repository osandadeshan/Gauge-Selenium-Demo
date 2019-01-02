package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.page.ManageDistrictPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Gauge-UI-Automation-Demo
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 23/12/2018
 * Time         : 14:09
 * Description  :
 **/


public class ManageDistrictPageStepImpl {

    private WebDriver driver = Driver.driver;
    private ManageDistrictPage manageDistrictPage = PageFactory.initElements(driver, ManageDistrictPage.class);

    @Step("Scroll to the district from district name <districtName>")
    public void scrollToDistrict(String districtName) {
        manageDistrictPage.scrollToDistrict(districtName);
    }
    @Step("Scroll to the district from district name saved in data store")
    public void scrollToDistrictInDataStore() {
        manageDistrictPage.scrollToDistrict(manageDistrictPage.getScenarioDataStoreValue("districtName"));
    }


}
