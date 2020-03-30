package com.cybertek.tests.day5_more_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {

        //get chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to browser
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //represents an element from page
        //where the elements come from?
        //from the findElement method
        //how findElement finds element?
        //using locators
        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //start interacting with the element
        String txt = buttonOne.getText();
        System.out.println("txt = " + txt);

        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());

        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());


        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());

        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button 5']"));
        WebElement buttonSix = driver.findElement(By.xpath("//button[@id='disappearing_button']"));
        // element.getAttribute("value")  --. method to get text form element, used with input boxes a lot
        // get text of the element
        System.out.println(buttonSix.getAttribute("innerHTML"));

        //if none of the works use outerHTML it will give you the node
        System.out.println(buttonSix.getAttribute("outerHTML"));

        driver.quit();
    }
}
