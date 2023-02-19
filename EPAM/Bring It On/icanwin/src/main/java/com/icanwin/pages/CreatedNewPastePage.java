package com.icanwin.pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.icanwin.TestData;

public class CreatedNewPastePage extends AbstractPage{
    private List<WebElement> elementsOfCodeFromWebpage = driver.findElements(By.xpath("//div[@class='de1']"));
    private List<String> elementsOfCodeFromTestData = Arrays.asList(TestData.codeLine1, TestData.codeLine2,TestData.codeLine3);
    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement bashButton;

    public CreatedNewPastePage(WebDriver driver){
        super(driver);
    }

    public boolean checkNewPaste(){
        boolean bool = true;
        int index = 0;
        List<String> stringsFromTestData = new ArrayList<String>();
        for(WebElement e : elementsOfCodeFromWebpage){
            stringsFromTestData.add(e.getText().trim());
        }
        if(driver.getTitle().contains("how to gain dominance among developers") 
        && bashButton.getText().equals("Bash") && stringsFromTestData.equals(elementsOfCodeFromTestData)){
            for(String string : stringsFromTestData){
                if(elementsOfCodeFromTestData.get(index).contains(string)==false){
                    bool = false;
                }
                index++;
            }
        }
        return bool;
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
    
}
