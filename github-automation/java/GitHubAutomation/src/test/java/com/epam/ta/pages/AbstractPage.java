package com.epam.ta.pages;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
	protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ArrayList<String> switchToPage(){
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        return handles;
    }

    public void waitToClickOnElement(WebElement element){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
        .elementToBeClickable(element));
    }
    public abstract AbstractPage openPage();
    
}
