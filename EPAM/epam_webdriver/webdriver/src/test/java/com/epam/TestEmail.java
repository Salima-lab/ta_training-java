package com.epam;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.page.ProtonSignInWebPage;
import com.epam.page.ZohoSignInPage; 

public class TestEmail extends BaseTest{
    @Test(priority = 0)
        public void test1(){
            boolean isValidEmailRegistered = new ZohoSignInPage(driver)
            .openPage()
            .loginWithCorrectData()
            .checkEmailMatch();
            Assert.assertTrue(isValidEmailRegistered);
        }

    @Test(priority = 1)
    public void test2(){
        boolean isErrorMessageDisplayed = new ZohoSignInPage(driver)
        .openPage()
        .loginWithIncorrectData();
        
        Assert.assertEquals(isErrorMessageDisplayed,true);
    }

    @Test(priority = 2)
    public void test3(){
        boolean isErrorMessageDisplayed = new ZohoSignInPage(driver)
            .openPage()
            .loginWithEmptyData();
        Assert.assertTrue(isErrorMessageDisplayed);
    }

    @Test(priority = 3)
    public void test4(){
         boolean isEmailSenderLoginCorrect = new ProtonSignInWebPage(driver)
            .openPage()
            .login()
            .sendMessage()
            .openPage()
            .loginWithCorrectData()
            .checkPresenceOfNewEmail();
        
            Assert.assertTrue(isEmailSenderLoginCorrect);
    }

}

