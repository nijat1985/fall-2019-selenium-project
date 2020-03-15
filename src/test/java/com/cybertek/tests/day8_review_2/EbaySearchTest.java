package com.cybertek.tests.day8_review_2;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {
    /**
     * 1. Open browser
     * 2. Go to https://ebay.com
     * 3. Search for wooden spoon
     * 4. Save the total number of results
     * 5. Click on link All under the categories on the left menu
     * 6. Verify that number of results is bigger than the number in step 4
     * 7. Navigate back to previous research results page
     * 8. Verify that wooden spoon is still displayed in the search box
     * 9. Navigate back to home page
     * 10. Verify that search box is blank
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon" + Keys.ENTER);

        Thread.sleep(2000);
        WebElement countEl = driver.findElement(By.cssSelector("h1>span"));
        String count = countEl.getText();
        int countOne = Integer.parseInt(count.replace(",",""));
        System.out.println("countOne = " + countOne);

        WebElement all = driver.findElement(By.linkText("All"));
        all.click();

        Thread.sleep(2000);
        //reinstianilize element in order not to get Stale element exception
        countEl = driver.findElement(By.cssSelector("h1>span"));
        count = countEl.getText();
        int countTwo = Integer.parseInt(count.replace(",",""));
        System.out.println("countTwo = " + countTwo);

        if (countOne < countTwo){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("countOne = " + countOne);
            System.out.println("countTwo = " + countTwo);
        }

        driver.navigate().back();

        input = driver.findElement(By.id("gh-ac"));
        String woodenSpoon = input.getAttribute("value");
        System.out.println("input = " + woodenSpoon);

        if (woodenSpoon.equals("wooden spoon")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("woodenSpoon = " + "woodenSpoon");
            System.out.println("woodenSpoon = " + woodenSpoon);
        }

        driver.navigate().back();

        input = driver.findElement(By.id("gh-ac"));
        woodenSpoon = input.getAttribute("value");
        System.out.println("woodenSpoon = " + woodenSpoon);

        if (woodenSpoon.isEmpty()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Expected a blank value");
            System.out.println("Actual = " + woodenSpoon);
        }



        driver.quit();

    }
}
