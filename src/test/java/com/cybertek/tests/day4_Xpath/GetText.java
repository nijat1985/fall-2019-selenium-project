package com.cybertek.tests.day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to forgot password web page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        /*
        Task
        go to the forgot password page
        enter any email
        click retrieve password bttn
        verify that the confirmation text "Your e-mail's been sent!"
         */

        WebElement email = driver.findElement(By.name("email"));
        //enter email --< sendKeys()
        email.sendKeys("abc@gmail.com");

        // click "retrieve password" bttb
        //locate the bttn first
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        //submit email by clicking the "retrive password"
        retrievePassword.submit();

        // verify that the confirmation text "Your e-mail's been sent!"
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();
        //getText() -->
        String expectedMessage = "Your e-mail's been sent!";

        if (actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();

    }
}
