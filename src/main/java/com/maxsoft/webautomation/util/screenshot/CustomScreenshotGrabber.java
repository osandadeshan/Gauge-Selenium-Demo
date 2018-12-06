package com.maxsoft.webautomation.util.screenshot;

import com.maxsoft.webautomation.util.driver.Driver;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Project Name : Virtuoso UI Automation
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/02/2018
 * Time         : 2:31 PM
 * Description  :
 **/


// Using WebDriver public class
public class CustomScreenshotGrabber implements ICustomScreenshotGrabber {

    public CustomScreenshotGrabber(){}

    private WebDriver driver = Driver.driver;

    // Return a screenshot byte array
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
