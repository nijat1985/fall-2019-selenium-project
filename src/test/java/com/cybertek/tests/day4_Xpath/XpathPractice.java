package com.cybertek.tests.day4_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) throws Exception {

        /*
        go to practice login page
        locate username box with absolute xpath
        locate username box with relative xpath
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        //absoloute
        WebElement userNameAbsolute = driver.findElement(By.xpath("html/body/div/div[2]/div/div[1]/form/div[1]/div/input"));

        //    //tagname[@attribute='value']

        //    <input type="text" name="username">

        //relative
        WebElement userNameRelative = driver.findElement(By.xpath("//input[@name=\"username\"]"));

        userNameAbsolute.sendKeys("absolut@gmail.com");

        Thread.sleep(3000);
        userNameAbsolute.clear();

        Thread.sleep(3000);
        userNameRelative.sendKeys("relative@gmail.com");

        Thread.sleep(3000);
        driver.quit();


    }
}
