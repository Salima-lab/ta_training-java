package com.epam.ta.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.ta.model.User;

public class MainPage extends AbstractPage {
    private final String URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchInput;

     

    public MainPage(WebDriver driver) {
        super(driver);
    }

     
    public SearchResultsPage searchForPricingCalculator(User formdata){
        searchInput.click();
        searchInput.sendKeys(formdata.getSearchCalculatorText());
        searchInput.sendKeys(Keys.RETURN);
        return new SearchResultsPage(driver);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(URL);
        logger.info("Main page opened");
        return this;
    }
    
}
