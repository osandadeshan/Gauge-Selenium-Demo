package com.maxsoft.webautomation.pages;

import com.maxsoft.webautomation.common.CommonPage;
import com.maxsoft.webautomation.util.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:18 PM
 * Description  :
 **/


public class FeatureCataloguePage extends CommonPage {

    private WebDriver driver = Driver.driver;

    //District Set Up Locators
    @FindBy(id = "district-setup-menu-item-link")
    private WebElement LBL_DISTRICTSETUP;

    @FindBy(id = "manage-districts-menu-item-link")
    private WebElement MANAGEDISTRICT;


    public FeatureCataloguePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateTodistrictCreation(){

        clickElement(LBL_DISTRICTSETUP);
        waitUntilLoadingCompleted();
    }


}

