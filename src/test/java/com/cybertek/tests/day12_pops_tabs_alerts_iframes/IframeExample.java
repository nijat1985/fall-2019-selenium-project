package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeExample {
//http://practice.cybertekschool.com/tinymce
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        Thread.sleep(2000);
        //TODO switch by id/name
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great.thanks");

        //TODO get out of iframe
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by webelement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great.thanks");

        //TODO switch by frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by index
        driver.switchTo().frame(0);
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great.thanks");

    }
}
