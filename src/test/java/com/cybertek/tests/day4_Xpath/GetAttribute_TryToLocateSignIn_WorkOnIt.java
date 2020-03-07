package com.cybertek.tests.day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute_TryToLocateSignIn_WorkOnIt {
    public static void main(String[] args) {
        /*
            go to forgot password page'
            locate retrive password bttn
            print out submit value
            type='submit'
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation.herokuapp.com/sign-in");
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("abc@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1213213123");

        //  <button id="form_submit" class="radius" type="submit"><i class="icon-2x icon-signin">Retrieve password</i></button>


        WebElement signIn = driver.findElement(By.className("button is-dark"));
        System.out.println("signIn = " + signIn.getAttribute("type"));
        System.out.println("signIn = " + signIn.getAttribute("class"));
        System.out.println("signIn = " + signIn.getAttribute("id"));

        driver.quit();
    }
}
