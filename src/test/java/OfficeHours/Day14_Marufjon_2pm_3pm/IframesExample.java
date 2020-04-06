package OfficeHours.Day14_Marufjon_2pm_3pm;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframesExample extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        //TODO switch to iframe using id
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.tagName("h2")).getText());

        //TODO switch to iframe using webelement
        WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src=\"demo_iframe.htm\"]"));
        driver.switchTo().frame(innerFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        //TODO change back to default content
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector(".cm-m-xml.cm-meta")).getText());

    }
}
