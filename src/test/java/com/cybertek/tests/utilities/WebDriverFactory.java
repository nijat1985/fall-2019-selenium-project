package com.cybertek.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
        write a static return method which returns WebDriver
        name: getDriver
        it takes a String as a parameter --> Browser Type
        returns ChromeDriver and FirefoxDriver
         */
    public static WebDriver getDriver(String browserType) {
        //local variables
        WebDriver driver = null;
        switch (browserType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
