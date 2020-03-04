package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskCombineAll {
    public static void main(String[] args) {
        /*
        1. Go to Google website
        2. save the title in a String variable
        3. go to Etsy
        4. save the etsy title in a String
        5. Navigate back to previous page
        6. Verify the title is same as step2
        7. Navigate forward to previous page
        8. Verify the title is same as step4
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        if (driver.getTitle().equals(titleGoogle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected title is " + titleGoogle);
            System.out.println("Actual result is " + driver.getTitle());
        }

        driver.navigate().forward();
        if (driver.getTitle().equals(titleEtsy)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected result is " + titleEtsy);
            System.out.println("Actual result is " + driver.getTitle());
        }

        driver.close();


    }
}
