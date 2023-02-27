package com.epam.ta.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.ta.model.User;
import com.epam.ta.pages.MainPage;
import com.epam.ta.service.UserCreator;
 

public class SearchTest extends CommonConditions{
    @Test
    public void testAutamaticallyFilledValuePriceEqualToManuallyFilledValuePrice(){
        User userdata = UserCreator.withCredentialsFromProperty();
        boolean isTotalEstimatedCostMatch = new MainPage(driver)
        .openPage()
        .searchForPricingCalculator(userdata)
        .clickOnFirstSearch()
        .fillForm(userdata)
        .openPage()
        .copyRandomEmail()
        .enterYopmailEmail()
        .compareTotalEstimatedMonthlyCost(userdata);
        Assert.assertTrue(isTotalEstimatedCostMatch);
    }
}
