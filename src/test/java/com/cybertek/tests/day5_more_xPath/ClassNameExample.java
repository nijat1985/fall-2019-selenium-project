package com.cybertek.tests.day5_more_xPath;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        WebElement link = driver.findElement(By.className("nav-link"));
        System.out.println(link.getText());

        //class name doesn't work if the value of the class attribute has a space
//        WebElement loginBtn = driver.findElement(By.className("btn btn-primary"));
//        loginBtn.click();

        driver.quit();
    }
}
