package com.icanwin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.icanwin.driver.DriverSingleton;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        DriverSingleton.closeDriver();
    }
}
