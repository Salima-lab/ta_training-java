package com.epam.ta.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.util.TestListener;
@Listeners({TestListener.class})
public class CommonConditions {
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
