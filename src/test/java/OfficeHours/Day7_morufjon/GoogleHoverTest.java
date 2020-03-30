package OfficeHours.Day7_morufjon;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHoverTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //TODO go to google.com
    // move your mouse on top of I am feeling lucky
    // verify that button now has a different text
    // Move the mouse away
    // Do this many times
    // When you get "I am feeling stellar" 3 times, print "Deal with it" in console and exit the program

    @Test
    public void test4(){
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("gbqfbb"));
        actions.moveToElement(button).perform();

        String notExpected = "I'm Feeling Lucky";
        String actual = "";
        int count = 0;
        while (count != 3) {
            actual = button.getAttribute("value");
            if (actual.equalsIgnoreCase(notExpected)){
                System.out.println("Deal with it");
                count++;
            }else {
                Assert.assertNotEquals(actual, notExpected);
            }
        }
    }
}
