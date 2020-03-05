package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Faker fakeData = new Faker();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        //I want to get value of type attribute
        //type="text" getAttribute(attribute name)

        //locate username box
        WebElement userName = driver.findElement(By.name("username"));

        //<input type="text" name="username">

        String valueOfType = userName.getAttribute("type");
        System.out.println("valueOfType = " + valueOfType);


        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        String classValue = loginButton.getAttribute("class");
        System.out.println("classValue = " + classValue);


        driver.quit();

    }
}
