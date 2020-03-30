package com.cybertek.tests.day4_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class PracticeFactory {
    public static void main(String[] args) {
        //go to google

        //   WebDriverManager.chromedriver().setup();
        //    WebDriver driver = new ChromeDriver();


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");

        driver.close();



    }
}
