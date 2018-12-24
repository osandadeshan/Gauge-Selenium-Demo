package com.maxsoft.webautomation.stepimpl;

import com.maxsoft.webautomation.pages.FeatureCataloguePage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Kushani Karunarathne
 * Version      : 1.0.0
 * Date         : 12/20/2018
 * Time         : 2:18 PM
 * Description  :
 **/


public class FeatureCataloguePageStepImpl {

    private WebDriver driver = Driver.driver;
    private FeatureCataloguePage featureCataloguePage = PageFactory.initElements(driver, FeatureCataloguePage.class);

    @Step("On District Creation page")
    public void navigateToDistrictCreation(){
        featureCataloguePage.navigateToDistrictCreation();
    }

    @Step("On Manage District page")
    public void navigateToManageDistricts(){
        featureCataloguePage.navigateToManageDistricts();
    }


}