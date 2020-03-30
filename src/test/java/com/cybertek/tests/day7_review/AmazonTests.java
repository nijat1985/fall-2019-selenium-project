package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTests {
    public static void main(String[] args) throws InterruptedException {
        //nameMatchTest();
        secondNameMatchTest();
    }
    /**
     * open browser
     * got to amazon
     * search for any item
     * remember the name of the second result
     * click on the second result
     * verify that product name is same in the product page

     */

    private static void secondNameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        String searchTerm = "disinfectant wipes";
        //OPTION 1: enter search term and hit enter
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
//        searchInput.sendKeys(searchTerm + Keys.ENTER);
        //OPTION 2: enter search term and click search btn
        searchInput.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement secondResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        System.out.println(secondResult.getText());
        String expectedName = secondResult.getText();
        secondResult.click();

        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();

        System.out.println(actualName);

        if (expectedName.equals(actualName)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedName = " + expectedName);
            System.out.println("actualName = " + actualName);
        }


        driver.quit();
    }

    /**
     * open browser
     * got to amazon
     * search for any item
     * remember the name of the first result
     * click on the first result
     * verify that product name is same in the product page

     */

    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        String searchTerm = "disinfectant wipes";
        //OPTION 1: enter search term and hit enter
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
//        searchInput.sendKeys(searchTerm + Keys.ENTER);
        //OPTION 2: enter search term and click search btn
        searchInput.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println(firstResult.getText());
        String expectedName = firstResult.getText();
        firstResult.click();

        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();

        System.out.println(actualName);

        if (expectedName.equals(actualName)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedName = " + expectedName);
            System.out.println("actualName = " + actualName);
        }


        driver.quit();
    }
}
