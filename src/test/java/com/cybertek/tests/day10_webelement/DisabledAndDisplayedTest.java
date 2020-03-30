package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledAndDisplayedTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    /*
    go to http://practice.cybertekschool.com/radio_buttons
    verify green is disabled
    verify black is enabled
     */

    @Test
    public void test(){
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        System.out.println("green is enabled? " + green.isEnabled());
        System.out.println("black is enabled? " + black.isEnabled());

        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());

    }

    @Test
    public void disabledTestWithAtrribute() throws InterruptedException {
        Thread.sleep(2000);
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        System.out.println("green = " + green.getAttribute("disabled"));
        System.out.println("black = " + black.getAttribute("disabled"));

        //verify that certain value is equal to null. verify element is enabled
        Assert.assertEquals(black.getAttribute("disabled"),null);
        //verify that value of black.getAttribute("disabled") is null
        Assert.assertNull(black.getAttribute("disabled"));

        //verify that certain value is equal to true. verify element is disabled
        Assert.assertEquals(green.getAttribute("disabled"),"true"); //because the result is String true
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled"))); //because the result is String true
    }

    @Test
    public void testElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));

        //verify that username is not visible
        // isDisplayed() --> returns true if we found element in HTML is visible on page
        System.out.println("Username is visible " + userName.isDisplayed());

        System.out.println("click on start");
        start.click();

        Thread.sleep(5000);
        System.out.println("Username is visible " + userName.isDisplayed());

        Assert.assertTrue(userName.isDisplayed());
    }

}
