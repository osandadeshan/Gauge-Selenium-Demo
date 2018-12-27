package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.common.CommonPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.maxsoft.webautomation.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:37 PM
 * Description  :
 **/


public class CommonPageStepImpl {

    private WebDriver driver = Driver.driver;
    private CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);

    @Step("Page title is <pageTitle>")
    public void isPageTitleEquals(String pageTitle) {
        Assert.assertEquals("Page title differs!\n", pageTitle, driver.getTitle());
    }

    @Step("Page title equals to the <key> in <sheetName> excel sheet")
    public void isPageTitleEquals(String key, String sheetName) {
        Assert.assertEquals("Page title differs!\n", Excel.getData(sheetName, key), commonPage.getPageTitle());
    }

    @Step("Sign out from the application")
    public void signOut(){
        commonPage.signOut();
    }


}
