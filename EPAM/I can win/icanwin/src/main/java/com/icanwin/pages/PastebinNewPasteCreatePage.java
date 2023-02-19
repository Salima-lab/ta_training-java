package com.icanwin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
 

public class PastebinNewPasteCreatePage extends AbstractPage{
    
    private final String URL = "https://pastebin.com/";
    @FindBy(id = "postform-text")
    private WebElement postformTextInput;

    @FindBy(id = "postform-name")
    private WebElement postformNameInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement postformExpirationContainer;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement postformExpirationTenMinutesOption;

    @FindBy(xpath = "//button[@class = 'btn -big']")
    private WebElement submitNewPasteButton;

    public PastebinNewPasteCreatePage(WebDriver driver){
        super(driver);
    }

    public PastebinNewPasteCreatePage fillNewPaste(){
        postformTextInput.sendKeys("Hello from WebDriver");
        postformExpirationContainer.click();
        postformExpirationTenMinutesOption.click();
        postformNameInput.sendKeys("helloweb");
        submitNewPasteButton.click();
        return this;
    }
    @Override
    public PastebinNewPasteCreatePage openPage(){
        driver.navigate().to(URL);
        return this;
    }

}
