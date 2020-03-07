package com.cybertek.tests.day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {
    /*
    go to http://practice.cybertekschool.com/dynamic_loading
    locate: Example 1: Element on page that is hidden and become visible after trigger
    print out href attribute's value
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //locate Example 1
        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        String hrefValue = example1.getAttribute("href");
        System.out.println("hrefValue = " + hrefValue);


        driver.quit();
    }
}
