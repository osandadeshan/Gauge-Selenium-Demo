package com.maxsoft.webautomation.stepimpl;

import com.maxsoft.webautomation.pages.FeatureCataloguePage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FeatureCataloguePageStepImpl {

    private WebDriver driver = Driver.driver;
    private FeatureCataloguePage featureCataloguePage = PageFactory.initElements(driver, FeatureCataloguePage.class);

    @Step("On district creation page")
    public void navigateToDistrictCreation(){
        featureCataloguePage.navigateTodistrictCreation();
    }




}