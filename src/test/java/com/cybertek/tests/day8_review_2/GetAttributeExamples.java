package com.cybertek.tests.day8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExamples {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        //get title
        System.out.println(driver.getTitle());

        //get url
        System.out.println(driver.getCurrentUrl());

        //get page source
        //System.out.println(driver.getPageSource());

        //get certain attributes of the element
        WebElement myEbayLink = driver.findElement(By.linkText("My eBay"));
        String classValue = myEbayLink.getAttribute("class");
        System.out.println("classValue = " + classValue);

        String href = myEbayLink.getAttribute("href");
        System.out.println("href = " + href);

        System.out.println(myEbayLink.getText());

        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon");
        System.out.println(input.getAttribute("value"));

        //.getAttribute("innerHTML")); -> returns text of the link
        //System.out.println(input.getAttribute("innerHTML"));
        System.out.println(myEbayLink.getAttribute("innerHTML"));

        //.getAttribute("outerHTML")); -> returns html information of current node
        System.out.println(myEbayLink.getAttribute("outerHTML"));
        System.out.println(input.getAttribute("outerHTML"));

        driver.quit();
    }
}
