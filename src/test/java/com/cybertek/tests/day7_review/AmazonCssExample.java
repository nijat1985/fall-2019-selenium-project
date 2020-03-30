package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement todaysDeals = driver.findElement(By.cssSelector("a[tabindex = '47']"));
        todaysDeals.click();

        String expected = "Today's Deals";
        Thread.sleep(2000);
        WebElement topMessage = driver.findElement(By.cssSelector(".nav-a-content"));
        System.out.println(topMessage.getText());

        if (expected.equals(topMessage.getText())){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected: " + expected);
            System.out.println("actual: " + topMessage.getText());
        }

        WebElement bottomHeader = driver.findElement(By.cssSelector("h1>div:nth-of-type(1)"));
        System.out.println(bottomHeader.getText());

        if (expected.equals(bottomHeader.getText())){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + bottomHeader);
        }


        driver.quit();
    }
}
