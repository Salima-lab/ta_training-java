package com.icanwin;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.icanwin.pages.MainPage;
 

public class SearchTest extends BaseTest{
    @Test
    public void testAutamaticallyFilledValuesEqualToManuallyFilledValues(){
        boolean isTotalEstimatedCostMatch = new MainPage(driver)
        .openPage()
        .searchForPricingCalculator()
        .clickOnFirstSearch()
        .fillForm()
        .openPage()
        .copyRandomEmail()
        .enterYopmailEmail()
        .compareTotalEstimatedMonthlyCost();
        Assert.assertTrue(isTotalEstimatedCostMatch);
    }
}
