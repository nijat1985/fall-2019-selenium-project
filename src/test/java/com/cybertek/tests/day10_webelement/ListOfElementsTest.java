package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */

    @Test
    public void listOfRadioButtons(){
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //driver.findElements() --> returns list of elements
        List<WebElement> sports = driver.findElements(By.name("sport")); // if it cannot find the location of the element it gives you empty list and doesn't throw exception

        System.out.println(sports.size());
        for (WebElement radioButton: sports){
            Assert.assertFalse(radioButton.isSelected());
        }
    }
    /*
    go to practice website
    get all the links present in the page
    print their text
     */

    @Test
    public void getAllLinksTest(){
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    /*
    go to amazon.com
    search for lysol disinfecting wipes
    print the number of result
    print the first result
    print the second result
    print the last result
     */

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels" + Keys.ENTER);
        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        System.out.println("Number of results: " + allResults.size());

        System.out.println("First result: " + allResults.get(0).getText());
        System.out.println("First result: " + allResults.get(1).getText());
        System.out.println("Last result: " + allResults.get(allResults.size()-1).getText());
    }

    /*
    go to http://practice.cybertekschool.com/radio_buttons
    verify the all sports checkboxes are not checked by default
    randomly click any sport
    verify that that sport is clicked
    verify that all others are not clicked
    repeat the last step for 5 times
     */

    @Test
    public void checkRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> sports = driver.findElements(By.name("sport"));
        Random rd = new Random();

        for (WebElement radioButton: sports){
            Assert.assertFalse(radioButton.isSelected());
        }

        Thread.sleep(2000);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            int num = rd.nextInt(4);
            sports.get(num).click();
            System.out.println("Selecting button number: " + (num+1));
            for (int j = 0; j < sports.size(); j++) {
                if (j == num){
                    Assert.assertTrue(sports.get(num).isSelected());
                }else{
                    Assert.assertFalse(sports.get(j).isSelected());
                }
            }

        }

    }

}
