package com.maxsoft.webautomation.stepimpl;

import com.maxsoft.webautomation.pages.LoginPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:43 PM
 * Description  :
 **/


public class LoginPageStepImpl {

    private WebDriver driver = Driver.driver;
    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Step("On login page")
    public void navigateToLogin(){
        loginPage.navigateToLogin();
    }

    @Step("Login to the application using the username as <username> and password as <password>")
    public void login(String username, String password){
        loginPage.login(username, password);
    }


}