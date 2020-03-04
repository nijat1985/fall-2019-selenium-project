package com.cybertek.tests.day2_locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) throws Exception {
        /*
        User story: As as user, I should be able to login VyTrack app.
        test case-1;
        1. go to VyTrack login page
        2. write username data : storemanager52
        3. write pwd  UserUser123
        4. And clik on login button
        5. Verify that user is on the homepage

        Test case 2: negative one
        1. go to login page
        2. write invalid username
        3. write invalid password
        4. click login button
        5. Verify that user sees that error message
         */

        /*
        go to VyTrack login page
        write username:    data: storemanager52
        write password           UserUser123
        click login button
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();


        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected title is: " + expectedTitle);
            System.out.println("Actual title is: " + actualTitle);
        }

        String expectedURL = "https://app.vytrack.com/";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ExpectedURL is: " + expectedURL);
            System.out.println("ActualURL is: " + actualURL);
        }

        Thread.sleep(3000);
        driver.close();


    }
}
