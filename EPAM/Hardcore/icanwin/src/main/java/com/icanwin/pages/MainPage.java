package com.icanwin.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private final String URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchInput;

     

    public MainPage(WebDriver driver) {
        super(driver);
    }

     
    public SearchPage searchForPricingCalculator(){
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.RETURN);
        return new SearchPage(driver);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
    
}
