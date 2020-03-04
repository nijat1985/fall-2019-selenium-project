package com.cybertek.tests.day2_locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) throws Exception{
        /*
        https://cybertekschool.okta.com/

        <input type="text" placeholder="" name="username"
        id="okta-signin-username" value="" aria-label="" autocomplete="off">
         */
        //Task:
        //go to cybertek okta login page
        //write email to the text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.okta.com/");

        WebElement textBox = driver.findElement(By.id("okta-signin-username"));
        textBox.sendKeys("mehdiyevnicat1985@gmail.com");

        WebElement passBox = driver.findElement(By.id("okta-signin-password"));
        passBox.sendKeys("Nijat0702778773");

        driver.findElement(By.id("okta-signin-submit")).click();


        driver.findElement(By.xpath("//div[@id='okta-sign-in']/div[@class='auth-content']//div[@class='mfa-verify']/form[1]//input[@value='Send Push']")).click();








    }
}
