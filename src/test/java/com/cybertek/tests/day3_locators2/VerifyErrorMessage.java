package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {

    /*
        1. go to login page http://practice.cybertekschool.com/login
        2. enter invalid username
        3. enter invalid password
        4. Verify the error massage "Your username is invalid!"
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Faker fakeData = new Faker();

        driver.get("http://practice.cybertekschool.com/login");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys(fakeData.name().username());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(fakeData.gameOfThrones().character());

        WebElement login = driver.findElement(By.id("wooden_spoon"));
        login.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessageText = errorMessage.getText();

        if (actualErrorMessageText.contains(expectedErrorMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected text: " + expectedErrorMessage);
            System.out.println("Actual text: " + actualErrorMessageText);
        }


        driver.quit();
    }
}
