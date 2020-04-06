package OfficeHours.Day14_Marufjon_2pm_3pm;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutorExample extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();

        String text = "hello";
        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", webElement);
    }

    @Test
    public void highlight() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        WebElement text = driver.findElement(By.tagName("h1"));
        highlight(text);

        List<WebElement> elements = driver.findElements(By.cssSelector("li>a"));
        for (WebElement link : elements){
            highlight(link);
        }
    }

    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    }
}
