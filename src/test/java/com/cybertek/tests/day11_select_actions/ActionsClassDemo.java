package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassDemo {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().fullscreen();

        actions = new Actions(driver);
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.tagName("img"));
        //TODO moveToElement() --> moves the mouse on top of given element
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
    }

    @Test
    public void hover2(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        //TODO move the mouse to enabled
        // wait
        // move the mouse to downloads
        // wait
        // click on pdf
        actions.moveToElement(enabled).
                pause(2000).
                moveToElement(downloads).
                pause(2000).
                moveToElement(pdf).
                click().
                build().perform();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);
      // actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.moveToElement(money).perform();
        actions.dragAndDrop(money,bank).perform();
        Thread.sleep(3000);
    }

    /*
    TODO do the drag and drop by chaining actions
    TODO move mouse to source/money
    TODO mouse down
    TODO move mouse to target/bank
    TODO mouse up
     */

    @Test
    public void dragAndDropAgain() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);
        actions.moveToElement(money).clickAndHold().moveToElement(bank).release().build().perform();
        Thread.sleep(3000);
    }




}
