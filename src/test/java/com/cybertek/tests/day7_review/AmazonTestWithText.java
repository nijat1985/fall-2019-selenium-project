package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithText {
    /**
     * open browser
     * got to amazon
     * search for "seleniom cookbook"
     * verify that the result with text "Selenium Testing Tools Cookbook - Second Edition"

     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/form/div[3]/div/input"));
        searchInput.sendKeys("selenium cookbook" + Keys.ENTER);

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
        System.out.println("result = " + result.getText());


        driver.quit();

    }



}
