package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        //Locator - LinkText
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        String textVersionOfExample3 = example3.getText();
        System.out.println("textVersionOfExample3 = " + textVersionOfExample3);
//        example3.click();

        //LinkText vs partialLinkText
        //I want to locate Example3 with only a part of it
        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));

        String text = example3_2.getText();
        System.out.println("text = " + text);

        /*
        Task:
        1. go to http://practice.cybertekschool.com/dynamic_loading
        2. Locate Cybertek_School element by using linkText and/or PartialLinkText
         */

        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School"));
        String cybertekSchoolText = cybertekSchool.getText();
        System.out.println("cybertekSchoolText = " + cybertekSchoolText);

        WebElement home = driver.findElement(By.linkText("Home"));
        String homeText = home.getText();
        System.out.println("homeText = " + homeText);


       // driver.quit();
    }
}
