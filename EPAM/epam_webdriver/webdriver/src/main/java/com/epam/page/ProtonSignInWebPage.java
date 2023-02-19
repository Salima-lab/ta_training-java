package com.epam.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.data.ConfigData;
import com.epam.data.TestData;

public class ProtonSignInWebPage extends AbstractPage{
    @FindBy(id = "username")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "staySignedIn")
    private WebElement staySignedInCheckbox;

    @FindBy(xpath  = "//button[@class='button w100 button-large button-solid-norm mt1-5']")
    private WebElement enterButton;

    @FindBy(xpath  = "//button[@class='button button-large button-solid-norm w100 no-mobile']")
    private WebElement sendNewEmailButton;

    @FindBy(xpath  = "//div[@class='flex-item-fluid flex flex-align-items-center composer-addresses-input-container']//input")
    private WebElement sendToInput;

    @FindBy(xpath = "//input[@class='field-two-input w100']")
    private WebElement subjectInput;

    @FindBy(xpath = "//button[@class='button button-group-item button-solid-norm composer-send-button']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//div[@class='p1 mb0-5 text-break notification notification--in bg-success']")
    private WebElement emailSentAlert;
    public ProtonSignInWebPage(WebDriver driver) {
        super(driver);
    }

    public ProtonSignInWebPage login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(emailInput));
        emailInput.sendKeys(TestData.validEmailProton);
        passwordInput.sendKeys(TestData.validPasswordProton);
        staySignedInCheckbox.click();
        enterButton.click();
        return this;
    }

    public ZohoSignInPage sendMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(sendNewEmailButton));
        sendNewEmailButton.click();
        wait.until(ExpectedConditions.
        presenceOfElementLocated(By.xpath("//div[@class='flex-item-fluid flex flex-align-items-center composer-addresses-input-container']")));
        sendToInput.sendKeys(TestData.validEmailToSendZoho);
        subjectInput.sendKeys(TestData.subjectText);
        sendEmailButton.click();
        wait.until(ExpectedConditions.
        visibilityOf(emailSentAlert));
        return new ZohoSignInPage(driver);
    }



    @Override
    public ProtonSignInWebPage openPage() {
        driver.navigate().to(ConfigData.protonSignInWebPage);
        return this;
    }

    @Override
    public void closePage() {
        driver.close();
    }
    
    
}
