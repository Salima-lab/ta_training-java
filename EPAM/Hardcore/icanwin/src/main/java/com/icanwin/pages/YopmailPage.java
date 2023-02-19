package com.icanwin.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailPage extends AbstractPage{
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
        return new PricingCalculatorPage(driver);
    }

    public boolean compareTotalEstimatedMonthlyCost(){
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
        if(totalEstimatedCost.getText().contains("4,024.56")){
            return true;
        }
        return false;
    }

     

    
    @Override
    public YopmailPage openPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://yopmail.com/ru/','_blank');");
        driver.switchTo().window(switchToPage().get(1));
    return this;
    
}
}
