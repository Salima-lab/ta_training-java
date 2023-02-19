package com.icanwin.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage{
    private final String URL = "https://cloud.google.com/s/results?q=Google%20Cloud%20Platform%20Pricing%20Calculator&text=Google%20Cloud%20Platform%20Pricing%20Calculator";
    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private WebElement firstSearch;
    
    protected SearchPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage clickOnFirstSearch(){
        waitToClickOnElement(firstSearch);
        firstSearch.click();
        return new PricingCalculatorPage(driver);
    }

    
    @Override
    public SearchPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
    
}
