package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlertsExamples {
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

    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        button.click();
        Thread.sleep(2000);
        WebElement nooo = driver.findElement(By.id("//span[.='No']"));
        nooo.click();
        Thread.sleep(2000);
    }

    @Test
    public void jsAlerts(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();

        Alert alert = driver.switchTo().alert();// we can do it if we have alert in the page otherwise its not gonna work.
        alert.accept();//it means that selenium webdriver pushs ok button on alert in order get rid of it. there are some actions can we do here like dismiss..

    }

    @Test
    public void jsAlertsCancel() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[2]"));
        button1.click();

        Alert alert = driver.switchTo().alert(); // we can do it if we have alert in the page otherwise its not gonna work.
        Thread.sleep(2000);
        alert.dismiss();//it means that selenium webdriver pushs cancel button on alert in order get rid of it.
    }

    @Test
    public void jsAlertsSendKeys() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[3]"));
        button1.click();
        Alert alert;
        try {
            alert = driver.switchTo().alert(); // we can do it if we have alert in the page otherwise its not gonna work.
            Thread.sleep(3000);
            alert.sendKeys("Admiral Kunkka");//send keys to alert
            Thread.sleep(2000);
            alert.accept();
            Thread.sleep(2000);
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

}
