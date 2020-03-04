package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLOfPracticeWeb {
    public static void main(String[] args) {
        //http://practice.cybertekschool.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        driver.manage().window().maximize();

        String expectedURL = "http://practe.cybertekschool.com/";
        String actualResult = driver.getCurrentUrl();

        if (expectedURL.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL...:(");
            System.out.println("Expected result is: " + expectedURL);
            System.out.println("Actual result is: " + actualResult);
        }

        driver.close();

    }
}
