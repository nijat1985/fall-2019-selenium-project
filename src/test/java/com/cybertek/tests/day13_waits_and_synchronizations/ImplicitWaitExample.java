package com.cybertek.tests.day13_waits_and_synchronizations;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS); //TODO waits until it finds element

    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException{
       driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

       WebElement message = driver.findElement(By.cssSelector("#finish>h4"));

       Assert.assertTrue(message.isDisplayed());

        System.out.println("message = " + message.getText());


        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        message = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(message.isDisplayed());

        System.out.println("message = " + message.getText());


    }
}
