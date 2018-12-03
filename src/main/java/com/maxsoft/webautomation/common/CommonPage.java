package com.maxsoft.webautomation.common;

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
 * Time         : 2:15 PM
 * Description  :
 **/


public class CommonPage extends Base {

    private WebDriver driver = Driver.driver;

    @FindBy(xpath = "//i[@class='fa fa-chevron-down']")
    private WebElement MENU_PROFILE;

    @FindBy(xpath = "//a[@class='profile-menu-item-link signout-link no-padding']")
    private WebElement BTN_SIGN_OUT;

    @FindBy(xpath = "//body//div[@id='virtuoso-loader'][@style='display: none;']")
    private WebElement ICON_PAGE_LOADER;


    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilLoadingCompleted(){
        waitForElementNotVisible(ICON_PAGE_LOADER);
    }

    public void signOut(){
        clickElement(MENU_PROFILE);
        clickElement(BTN_SIGN_OUT);
    }


}
