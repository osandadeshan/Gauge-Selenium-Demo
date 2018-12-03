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


public class LoginPage extends CommonPage {

    private static String LoginPageUrl = URL;
    private WebDriver driver = Driver.driver;

    @FindBy(id = "username")
    private WebElement TXT_USERNAME;

    @FindBy(id = "password")
    private WebElement TXT_PASSWORD;

    @FindBy(id = "kc-login")
    private WebElement LOGIN_IN;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLogin(){
        driver.get(LoginPageUrl);
    }

    public void login(String username, String password){
        setTextAs(TXT_USERNAME, username);
        setTextAs(TXT_PASSWORD, password);
        clickElement(LOGIN_IN);
        waitUntilLoadingCompleted();
    }


}
