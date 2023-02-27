package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchResultsPage extends AbstractPage{
    private final String URL = "https://cloud.google.com/s/results?q=Google%20Cloud%20Platform%20Pricing%20Calculator&text=Google%20Cloud%20Platform%20Pricing%20Calculator";
    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private WebElement firstSearch;
    private final Logger logger = LogManager.getRootLogger();
    
    protected SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage clickOnFirstSearch(){
        waitToClickOnElement(firstSearch);
        firstSearch.click();
        return new PricingCalculatorPage(driver);
    }

    
    @Override
    public SearchResultsPage openPage() {
        driver.navigate().to(URL);
        logger.info("Search results page opened");
        return this;
    }
    
}
