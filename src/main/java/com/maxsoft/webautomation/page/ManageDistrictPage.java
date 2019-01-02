package com.maxsoft.webautomation.page;

import com.maxsoft.webautomation.common.CommonPage;
import com.maxsoft.webautomation.util.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Gauge-UI-Automation-Demo
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 23/12/2018
 * Time         : 14:08
 * Description  :
 **/


public class ManageDistrictPage extends CommonPage {

    private WebDriver driver = Driver.driver;

    @FindBy(id = "username")
    private WebElement TXT_USERNAME;

    @FindBy(id = "password")
    private WebElement TXT_PASSWORD;

    @FindBy(id = "kc-login")
    private WebElement LOGIN_IN;

    private static String districtNameRegex = "districtName";
    private static String districtLocatorXpath = "//span[text()='" + districtNameRegex + "']";


    public ManageDistrictPage() {
        PageFactory.initElements(driver, this);
    }

    public void scrollToDistrict(String districtName){
        scrollToElement(districtLocatorXpath.replace(districtNameRegex, districtName));
    }


}
