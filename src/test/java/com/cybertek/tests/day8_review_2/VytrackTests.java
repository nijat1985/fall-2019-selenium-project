package com.cybertek.tests.day8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTests {

    public static void main(String[] args) throws InterruptedException {
        //titleTest();
        shortcutTest();
    }

    /**
     * 1. Open browser
     * 2. Go to Vytrack login page
     * 3. Login as a sales manager
     * 4. Verify Dashboard page is open
     * 5. Click on Shortcuts icon
     * 6. Click on link See full list
     * 7. Click on link Opportunities
     * 8. Verify Open opportunities page is open
     * 9. Click on Shortcuts icon
     * 10. Click on link See full list
     * 11. Click on link Vehicle Service Logs
     * 12. Verify error message text is You do not have
     * permission to perform this action.
     * 13. Verify Shortcut Actions List page is still open
     */
    private static void shortcutTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        password.submit();

        Thread.sleep(2000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        verifyStartsWith(expectedTitle, actualTitle);

        WebElement shortcutIcon = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortcutIcon.click();

        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();

        Thread.sleep(2000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        opportunities.click();

        Thread.sleep(2000);
        expectedTitle = "Open Opportunities";
        actualTitle = driver.getTitle();

        verifyStartsWith(expectedTitle,actualTitle);

        shortcutIcon.click();
        allLinks.click();

        Thread.sleep(2000);
        WebElement vehicleServiceLogs = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLogs.click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));

        verifyStartsWith("You do not have permission to perform this action", errorMessage.getText());
        verifyStartsWith("Shortcut Actions List", driver.getTitle());

        Thread.sleep(2000);
        driver.quit();
    }

    /**
     * 1. Open browser
     * 2. Go to Vytrack login page
     * 3. Login as any user
     * 4. Click on your name on top right
     * 5. Click on My Configuration
     * 6. Verify that page title starts with the same name on top
     * right
     */

    private static void titleTest() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        password.submit();

        Thread.sleep(2000);
        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        profileName.click();

        Thread.sleep(2000);
        WebElement myConfiguration = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        Thread.sleep(2000);
        myConfiguration.click();


        String expected = profileName.getText();
        Thread.sleep(2000);
        String actual = driver.getTitle();

        verifyStartsWith(expected, actual);


        Thread.sleep(2000);
        driver.quit();
    }

    private static void verifyStartsWith(String expected, String actual) {
        if (actual.startsWith(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }

    /**
     * write the method that takes 2 strings, verifies if string 1 starts with string 2
     */

//    private static void verifyStartsWith(String stringOne, String stringTwo){
//
//    }



}
