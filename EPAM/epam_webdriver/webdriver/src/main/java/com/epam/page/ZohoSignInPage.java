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

public class ZohoSignInPage extends AbstractPage{
    @FindBy(id = "login_id")
    private WebElement emailInput;

    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath  = "//div[@class='zmavatar__image-wrapper']")
    private WebElement avatar;

    @FindBy(xpath = "//span[contains(text(),'abdrashovasalima@gmail.com')]")
    private WebElement registeredEmail;

    @FindBy(xpath = "//div[@class='fielderror errorlabel']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@title='slimshady386@protonmail.com']")
    private WebElement sentMessage;

    @FindBy(xpath = "//div[@class='zmtoken__text']")
    private WebElement unreadMessagesButton;

    @FindBy(xpath = "//div[@class='zmList zmLUrd zmLFcs']//span[@class='zmLSub']")
    private WebElement sentMessageText;
    
    public ZohoSignInPage(WebDriver driver) {
        super(driver);
    }

    public ZohoSignInPage loginWithCorrectData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        emailInput.sendKeys(TestData.validEmailZoho);
        nextButton.click();
        wait.until(ExpectedConditions
        .elementToBeClickable(By
        .id("password")));
        passwordInput.sendKeys(TestData.validPasswordZoho);
        nextButton.click();
        return this;
    }

    public boolean loginWithIncorrectData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(emailInput));
        emailInput.sendKeys(TestData.invalidEmailZoho);
        nextButton.click();
        wait.until(ExpectedConditions
        .visibilityOf(errorMessage));
        if(errorMessage.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean loginWithEmptyData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(emailInput));
        emailInput.sendKeys("");
        nextButton.click();
         wait.until(ExpectedConditions
        .visibilityOf(errorMessage));
        if(errorMessage.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean checkPresenceOfNewEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(sentMessage));
        unreadMessagesButton.click();
        if(TestData.validEmailProton.equals(sentMessage.getText()) && sentMessageText.getText().equals(TestData.subjectText)){
            return true;
        }
        return false;
    }


    public boolean checkEmailMatch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
        .visibilityOf(avatar));
        avatar.click();
        wait.until(ExpectedConditions
        .visibilityOf(registeredEmail));
        if(registeredEmail.getText().equals(TestData.validEmailZoho)){
            return true;
        }
        return false;
    }

    @Override
    public ZohoSignInPage openPage() {
        driver.navigate().to(ConfigData.zohoSignInWebPage);
        return this;
    }

    @Override
    public void closePage() {
        driver.close();
    }
    
}
