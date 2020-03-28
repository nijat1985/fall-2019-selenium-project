package com.cybertek.tests.day13_waits_and_synchronizations;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExamples {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test1Titletest(){
        driver.get("https://google.com");

        System.out.println(driver.getTitle());

        driver.get("https://store.steampowered.com");

        //explicit wait until text is visible
        wait.until(ExpectedConditions.titleContains("Steam"));

        System.out.println(driver.getTitle());
    }

    @Test
    public void test2WaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        //make sure that the username is visible
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");

    }


    @Test(description = "this test case will fail")
    public void test3WaitForVisibleFail(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //give not enough time. chenge the wait time
        wait.withTimeout(Duration.ofSeconds(2));
        //waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        //make sure that the username is visible
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");

    }

    @Test
    public void test4WaitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submut = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        //wait for element to disappear
        //wait until the overlay element disappear
        WebElement overlay = driver.findElement(By.className("loadingoverlay"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));

        //waits for given element to be clickable
        //wait.until(ExpectedConditions.elementToBeClickable(submut));
        submut.click();

    }


    @Test
    public void test4WaitForInvisibile(){
        driver.manage().window().maximize();
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();


        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //purposly did this. if we put 2 seconds it will pass
        WebElement myCalendar = driver.findElement(By.linkText("My Calendar"));

        //wait until the element with class loader-mask is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-mask")));//explicit wait is comes to play when we need it it is not like implicit wait which runs everytime when we find element
        myCalendar.click();//if the button outside the form we use click instead of submit
       // myCalendar.submit();//submit works when button inside the form

    }


    @Test
    public void test5Fluent(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);


        WebElement submitBtn = fluentWait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        submitBtn.click();

    }



}
