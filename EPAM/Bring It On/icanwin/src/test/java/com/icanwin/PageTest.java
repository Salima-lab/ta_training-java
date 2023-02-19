package com.icanwin;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.icanwin.pages.PastebinNewPasteCreatePage;
public class PageTest extends BaseTest{
    @Test
    public void testNewPasteTitle(){
        Boolean newPaste = new PastebinNewPasteCreatePage(driver)
                .openPage()
                .fillNewPaste()
                .checkNewPaste();
                
        
        Assert.assertTrue(newPaste);
    }
}
