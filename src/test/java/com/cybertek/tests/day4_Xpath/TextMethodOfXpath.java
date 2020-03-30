package com.cybertek.tests.day4_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodOfXpath {
    /*
    go to http://practice.cybertekschool.com/context_menu
    verify  Context Menu  is on the page
    //tagName[text()='exact Text']
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/context_menu");

        //locate the element Context Menu
        WebElement contextMenu = driver.findElement(By.xpath("//h3[text() = \"Context Menu\"]"));

        //Verify --> expect vs actual
        String expectedText = "Context Menu";
        String actualText = contextMenu.getText();

        if (actualText.equals(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }

        driver.quit();


    }
}
