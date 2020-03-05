package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        WebElement login = driver.findElement(By.id("wooden_spoon"));
        login.click();

        WebElement welcomeMessage = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = welcomeMessage.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.close();


    }
}
