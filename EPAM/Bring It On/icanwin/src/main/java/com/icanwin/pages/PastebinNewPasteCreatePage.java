package com.icanwin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.icanwin.TestData;
 
 

public class PastebinNewPasteCreatePage extends AbstractPage{
    
   
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

    @FindBy(id = "select2-postform-format-container")
    private WebElement postformSyntaxHighlightingContainer;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement postformSyntaxHighlightingBashOption;

    public PastebinNewPasteCreatePage(WebDriver driver){
        super(driver);
    }

    public CreatedNewPastePage fillNewPaste(){
        postformTextInput.sendKeys(TestData.codeLine1);
        postformTextInput.sendKeys(TestData.codeLine2);
        postformTextInput.sendKeys(TestData.codeLine3);
        postformSyntaxHighlightingContainer.click();
        postformSyntaxHighlightingBashOption.click();
        postformExpirationContainer.click();
        postformExpirationTenMinutesOption.click();
        postformNameInput.sendKeys("how to gain dominance among developers");
        submitNewPasteButton.click();
        return new CreatedNewPastePage(driver);
    }
    @Override
    public PastebinNewPasteCreatePage openPage(){
        driver.navigate().to(TestData.URL);
        return this;
    }

}
