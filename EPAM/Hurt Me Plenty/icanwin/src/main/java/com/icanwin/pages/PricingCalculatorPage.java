package com.icanwin.pages;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PricingCalculatorPage extends AbstractPage{
    private final String URL ="https://cloud.google.com/products/calculator";

    @FindBy(id  = "input_92")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "select_value_label_87")
    private WebElement seriesDefaultOption;

    @FindBy(id = "select_option_203")
    private WebElement seriesN1Option;

    @FindBy(id = "select_value_label_88")
    private WebElement machineTypeDefaultOption;

    @FindBy(id = "select_option_430")
    private WebElement machineTypeN1Standart8Option;

    @FindBy(xpath = "//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    private WebElement addGpuCheckbox;

    @FindBy(id = "select_468")
    private WebElement selectGpuType;

    @FindBy(id = "select_option_473")
    private WebElement selectGpuTypeNVIDIATeslaV100;

    @FindBy(id = "select_value_label_467")
    private WebElement selectNumberOfGpuDefaultOption;
    
    @FindBy(id = "select_option_479")
    private WebElement selectNumberOfGpuOneOption;
    
    @FindBy(id = "select_value_label_424")
    private WebElement selectLocalSSDDefaulOption;
     
    @FindBy(id = "select_option_451")
    private WebElement selectLocalSSDD2x375GbOption;

    @FindBy(id = "select_value_label_90")
    private WebElement selectDatacenterLocationDeafultOption;
    
    @FindBy(id = "select_option_230")
    private WebElement selectDatacenterLocationFrankfurtOption;

    @FindBy(id = "select_value_label_91")
    private WebElement selectCommitedUsageDefaultOption;

    @FindBy(id = "select_option_130")
    private WebElement selectCommitedUsage1YearOption;

    @FindBy(xpath = "//div[@class='layout-align-end-start layout-row']//button")
    private List<WebElement> listOfAddToEstimateButtons;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//md-list-item//div[1]")
    private List<WebElement> valuesToCheck;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage fillForm(){
        WebElement iframe1 = driver.findElement(By.xpath("//devsite-iframe//iframe"));
        driver.switchTo().frame(iframe1);
        WebElement iframe2 = driver.findElement(By.xpath("//div//iframe[@id='myFrame']"));
        driver.switchTo().frame(iframe2);
        inputNumberOfInstances.click();
        inputNumberOfInstances.sendKeys("4");
        seriesDefaultOption.click();
        waitToClickOnElement(seriesN1Option);
        seriesN1Option.click();
        machineTypeDefaultOption.click();
        waitToClickOnElement(machineTypeN1Standart8Option);
        machineTypeN1Standart8Option.click();
        waitToClickOnElement(addGpuCheckbox);
        addGpuCheckbox.click();
        selectGpuType.click();
        selectGpuTypeNVIDIATeslaV100.click();
        selectNumberOfGpuDefaultOption.click();
        selectNumberOfGpuOneOption.click();
        selectLocalSSDDefaulOption.click();
        waitToClickOnElement(selectLocalSSDD2x375GbOption);
        selectLocalSSDD2x375GbOption.click();
        selectDatacenterLocationDeafultOption.click();
        waitToClickOnElement(selectDatacenterLocationFrankfurtOption);
        selectDatacenterLocationFrankfurtOption.click();
        selectCommitedUsageDefaultOption.click();
        selectCommitedUsage1YearOption.click();
        listOfAddToEstimateButtons.get(0).click();
        return this;
    }

    public boolean checkFilledValue(){
        List<String> listOfWriteAnswers = Arrays.asList(
        "Region: Frankfurt",
        "2,920 total hours per month",
        "Commitment term: 1 Year",
        "Provisioning model: Regular",
        "Instance type: n1-standard-8\nCommitted Use Discount applied",
        "Committed Use Discount applied",
        "Operating System / Software: Free",
        "GPU dies: 1 NVIDIA TESLA P100\nCommitted Use Discount applied",
        "USD 2,943.36",
        "Local SSD: 2x375 GiB\nCommitted Use Discount applied",
        "USD 181.44",
        "Estimated Component Cost: USD 4,024.56 per 1 month"
        );
        for(int i = 0;i<valuesToCheck.size();i++){
            if(listOfWriteAnswers.contains(valuesToCheck.get(i).getText().trim())==false){
                return false;
            }
        }
        return true;
}

    @Override
    public PricingCalculatorPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
    
}
