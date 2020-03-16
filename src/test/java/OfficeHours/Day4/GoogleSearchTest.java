package OfficeHours.Day4;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;


public class GoogleSearchTest {
    /**
     * 1. Open browser
     * 2. Go to https://google.com
     * 3. Search for one of the strings the list searchStrs given below
     * 4. In the results pages, capture the url right above the first result
     * 5. Click on the first result
     * 6. Verify that url is equal to the value from step 4
     * 7. Navigate back
     * 8. Repeat the same steps for all search items in the list
     * Note: Do this exercise using a for loop. Here is the list that was mentioned step 3:
     * List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", “Selenium web browser automation" );
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");
        //List<String> searchStrs = Arrays.asList("Java");

        for (String searchStr : searchStrs){
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.clear();
            searchInput.sendKeys(searchStr + Keys.ENTER);

            Thread.sleep(2000);
            WebElement url = driver.findElement(By.cssSelector(".iUh30.tjvcx"));
            String url1 = url.getText();

            Thread.sleep(2000);
            WebElement link = driver.findElement(By.cssSelector("div.r>a>h3"));
            link.click();

            if (url1.equals(driver.getCurrentUrl())){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
                System.out.println("Expected = " + url1);
                System.out.println("Actual = " + driver.getCurrentUrl());
            }

            Thread.sleep(2000);
            driver.navigate().back();

        }

        driver.quit();

    }
}
