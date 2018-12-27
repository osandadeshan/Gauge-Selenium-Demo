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
 * Date         : 12/20/2018
 * Time         : 2:18 PM
 * Description  :
 **/


public class FeatureCataloguePage extends CommonPage {

    private WebDriver driver = Driver.driver;

    // District Set Up Locators
    @FindBy(id = "district-setup-menu-item-link")
    private WebElement LBL_DISTRICT_SETUP;

    @FindBy(id = "manage-districts-menu-item-link")
    private WebElement LBL_MANAGE_DISTRICT;


    public FeatureCataloguePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToDistrictCreation(){
        clickElement(LBL_DISTRICT_SETUP);
        waitUntilLoadingCompleted();
    }

    public void navigateToManageDistricts(){
        clickElement(LBL_MANAGE_DISTRICT);
        waitUntilLoadingCompleted();
    }


}

