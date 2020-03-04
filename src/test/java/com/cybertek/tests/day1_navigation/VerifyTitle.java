package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        /*
        1. Go to cybertek praciceweb site  http://practice.cybertekschool.com/
        2. Verify Title -> Practice
         */

        //connect browser and driver
        //setup browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        driver.manage().window().fullscreen();

        String expectedResult = "practice";

        String actualTitle = driver.getTitle();

        if (expectedResult.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedResult);
            System.out.println("The actual title is " + actualTitle);
        }

        driver.close();




    }
}
