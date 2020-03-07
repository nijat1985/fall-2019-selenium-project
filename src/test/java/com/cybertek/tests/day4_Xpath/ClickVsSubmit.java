package com.cybertek.tests.day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSubmit {
    public static void main(String[] args) {
       /*
        Click()
        sybmit()
        task:
        1. go to forgot password web page
        http://practice.cybertekschool.com/forgot_password
        2. enter any email
        3. click "retrieve password" bttb
        4. verify the URL is:
        http://practice.cybertekschool.com/email_sent
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to forgot password web page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        //locate the email box first
        // enter any email
        WebElement email = driver.findElement(By.name("email"));
        //enter email --< sendKeys()
        email.sendKeys("abc@gmail.com");

        // click "retrieve password" bttb
        //locate the bttn first
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        //submit email by clicking the "retrive password"
        retrievePassword.submit();

        //    Verify  --> Expected result  vs Actual result
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }


        driver.close();


    }
}
