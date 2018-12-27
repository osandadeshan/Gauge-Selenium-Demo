package com.maxsoft.webautomation.stepimpl.page;

import com.maxsoft.webautomation.page.LoginPage;
import com.maxsoft.webautomation.util.driver.Driver;
import com.maxsoft.webautomation.util.reader.Excel;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:18 PM
 * Description  :
 **/


public class LoginPageStepImpl {

    private WebDriver driver = Driver.driver;
    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Step("On Login page")
    public void navigateToLogin(){
        loginPage.navigateToLogin();
    }

    @Step("Login to the application using the username as <username> and password as <password>")
    public void login(String username, String password){
        loginPage.login(username, password);
    }

    @Step("Login to the application using the username and password <table>")
    public void login(Table table){
        for (TableRow row : table.getTableRows()) {
            loginPage.login(Excel.getData(row.getCell("Sheet Name For Username"), row.getCell("Key Name For Username")),
                    Excel.getData(row.getCell("Sheet Name For Password"), row.getCell("Key Name For Password")));
        }
    }


}