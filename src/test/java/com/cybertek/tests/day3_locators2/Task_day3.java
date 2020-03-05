package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_day3 {
    /*
    Task:
    Go to amazon  https://www.amazon.com/
     Go to Ebay   https://www.ebay.com/
    Enter a search term
    Click on search button
    Verify title contains search term

     */

    public static void main(String[] args) {
        //locators --> ID, name, classname
        /*
        If class attributes value has a space or spaces,
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.ebay.com/");

        WebElement search_box = driver.findElement(By.name("_nkw"));
        search_box.sendKeys("wooden spoon", Keys.ENTER);
//        search_box = driver.findElement(By.id("gh-btn"));
//        search_box.click();

        if (driver.getTitle().contains("wooden spoon")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println(driver.getTitle());
        }

        driver.close();




    }
}
