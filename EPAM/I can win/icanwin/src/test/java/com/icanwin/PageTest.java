package com.icanwin;
import org.testng.annotations.Test;

import com.icanwin.pages.PastebinNewPasteCreatePage;

public class PageTest extends BaseTest{
    @Test
    public void shouldAnswerWithTrue(){
        new PastebinNewPasteCreatePage(driver)
                .openPage()
                .fillNewPaste();
    }
}
