package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //I want to see the full window. We can use fullscreen() and maximize()
        driver.manage().window().fullscreen();

        //navigate().forward()
        //go to practice -> go to google -> back to practice
        //forward to google
        String practiceWebURL = "http://practice.cybertekschool.com/";
        String gglURL = "https://www.google.com";
        driver.get(practiceWebURL);
        Thread.sleep(2000);


        driver.navigate().to(gglURL);
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        //close driver we can use close() and quite() methods. close() closes only current window. quite() closes all of the windows
        //driver.close();
        driver.quit();
    }
}
