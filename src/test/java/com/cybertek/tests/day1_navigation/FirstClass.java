package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws Exception {
        //binary the driver and browser
        WebDriverManager.chromedriver().setup();

        //Webdriver object ---> Interface
        WebDriver driver = new ChromeDriver();

        //I want to open Google home page
        //driver.get("https://www.google.com");

        //Navigations
        //navigate().to() -> open a webpage
        //driver.navigate().to("https://www.google.com");

        //get() vs navigate().to()
        //get() -> waits until every element loads
        //navigate().to() -> doesn't wait just opens and goes the next step

        //navigate().back() ->

        //1. go to Google 2. go to cybertek practice website 3. go back
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);




    }
}
