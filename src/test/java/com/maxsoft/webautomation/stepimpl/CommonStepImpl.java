package com.maxsoft.webautomation.stepimpl;

import com.maxsoft.webautomation.common.Base;
import com.maxsoft.webautomation.util.driver.Driver;
import com.maxsoft.webautomation.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Gauge-UI-Automation-Demo
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/12/2018
 * Time         : 11:52
 * Description  :
 **/


public class CommonStepImpl {

    private WebDriver driver = Driver.driver;
    private Base base = PageFactory.initElements(driver, Base.class);

    @Step("Idle <seconds> seconds")
    public void idle(int seconds) {
        base.idle(seconds);
    }

    @Step("test")
    public void main() {
        Excel.getData("TestData", "password");
    }

}
