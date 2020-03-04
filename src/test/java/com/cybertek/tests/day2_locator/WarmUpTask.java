package com.cybertek.tests.day2_locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpTask {
    /*
    Task 1:
    1. Go to Bookit login page
    https://cybertek-reservation-qa.herokuapp.com/sign-in
    2. Verify the title of the page
    Task 2:
    2. Go to Bookit login page
    https://cybertek-reservation-qa.herokuapp.com/sign-in
    2. Verify that URL contains “cybertek-reservation”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().maximize();

        String expectedTitle = "bookit";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected title is: " + expectedTitle);
            System.out.println("Actual title is: " + actualTitle);
        }

        driver.close();


        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver1.manage().window().maximize();

        String expectedPartialURL = "cybertek-reservation";

        String actualURL = driver1.getCurrentUrl();
        if (actualURL.contains(expectedPartialURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected title is: " + expectedPartialURL);
            System.out.println("Actual title is: " + actualURL);
        }


        driver1.close();

    }
}
