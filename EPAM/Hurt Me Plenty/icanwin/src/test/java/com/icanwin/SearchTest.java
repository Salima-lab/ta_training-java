package com.icanwin;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.icanwin.pages.MainPage;
 

public class SearchTest extends BaseTest{
    @Test
    public void testAutamaticallyFilledValuesEqualToManuallyFilledValues(){
       boolean isMatchedValues = new MainPage(driver)
        .openPage()
        .searchForPricingCalculator()
        .clickOnFirstSearch()
        .fillForm()
        .checkFilledValue();
        Assert.assertTrue(isMatchedValues);
    }
}
