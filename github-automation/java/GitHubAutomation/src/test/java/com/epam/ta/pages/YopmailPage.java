package com.epam.ta.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.ta.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class YopmailPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//div[@id='listeliens']//a[contains(@href,'email-generator')]")
    private WebElement randomEmail;

    @FindBy(id = "cprnd")
    private WebElement copyRandomEmailButton;

    @FindBy(xpath = "//button[@class='md but text f24 egenbut']//span[text()='Проверить почту']")
    private WebElement goToMailBoxPageButton;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(id = "ifmail")
    private WebElement iframe;

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost')]")
    private WebElement totalEstimatedCost;
    public YopmailPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage copyRandomEmail(){
        randomEmail.click();
        copyRandomEmailButton.click();
        goToMailBoxPageButton.click();
        logger.info("Email copied!");
        return new PricingCalculatorPage(driver);
    }

    public boolean compareTotalEstimatedMonthlyCost(User formdata){
        driver.switchTo().window(switchToPage().get(1));
        boolean displayed = false;
        do{
            try{
                driver.switchTo().frame(iframe);
                displayed = driver.findElement(By.xpath("//h2[contains(text(),'Estimated Monthly Cost')]")).isDisplayed();
            } catch (NoSuchElementException e){
            driver.switchTo().defaultContent();
            refreshButton.click();
        }
        } while(!displayed);
        if(totalEstimatedCost.getText().contains(formdata.getTotalPrice())){
            return true;
        }
        return false;
    }

     

    
    @Override
    public YopmailPage openPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://yopmail.com/ru/','_blank');");
        driver.switchTo().window(switchToPage().get(1));
        logger.info("Yopmail page opened");
    return this;
    
}
}
