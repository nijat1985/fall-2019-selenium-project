package com.cybertek.tests.day6_css;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssExample {
    public static void main(String[] args) throws Exception{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //WebElement button = driver.findElement(By.cssSelector("#disappearing_button")); //find element by id in css
        //WebElement button = driver.findElement(By.cssSelector(".nav-link")); //find element by class name
        //WebElement button = driver.findElement(By.cssSelector("h4")); //find element by tagname
        //WebElement button = driver.findElement(By.cssSelector("html>body>nav>ul>li>a")); //  from parent to child in css
        //WebElement button = driver.findElement(By.cssSelector("html>body>nav>ul a")); //if you want skip some nodes in css you can put space, but in xpath we put //
        //button[onclick='button1()']
        //WebElement button = driver.findElement(By.cssSelector("button[onclick='button1()']")); //find element specifying attribute name and value in css
        //button[id$='_button']
        //WebElement button = driver.findElement(By.cssSelector("button[id$='_button']")); //find the element in css ends with _button

        //WebElement button = driver.findElement(By.cssSelector("button[id^='button_']"));//find the element in css starts with _button

        //WebElement button = driver.findElement(By.cssSelector("button[id*='_button']"));//find the element which contains _button
        //button:nth-of-type(2)
        //WebElement button = driver.findElement(By.cssSelector("button:nth-of-type(2)"));//find the 2nd button in document
        //p~button
        WebElement button = driver.findElement(By.cssSelector("p~button"));//find following sibling in css
        System.out.println(button.getText());


        Thread.sleep(3000);
        driver.quit();
    }
}
