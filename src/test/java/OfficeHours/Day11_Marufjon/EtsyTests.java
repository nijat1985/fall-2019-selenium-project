package OfficeHours.Day11_Marufjon;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyTests extends TestBase {
    /*
    search for wooden spoon on etsy
    verify title contains the searchterm
    verify that default ship to location is Ship to
    verify Ship to countries include Australia
     */
    @Test
    public void verifyCountryList(){
        driver.get("https://etsy.com");

        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));
        input.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        //wait a little until title changes to right one
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains(expectedTitle));

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //verify ship location

        //wait until the shipTo dropdown is available
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));

        String expectedDefaultCountry = "United States";
        String actualDefaultCountry = shipToList.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(actualDefaultCountry,expectedDefaultCountry);

        //verify that ship o countries include Australia
        List<String> elementsText = BrowserUtils.getElementsText(shipToList.getOptions());
        Assert.assertTrue(elementsText.contains("Australia"));

        //verify free shipping is NOT clicked
        WebElement freeShipping = driver.findElement(By.name("free_shipping"));
        Assert.assertFalse(freeShipping.isSelected());

        //verify url changes when free shipping is clicked
        WebElement freeShippingLabel = driver.findElement(By.xpath("//label[.='FREE shipping']"));
        freeShippingLabel.click();

        String expectedUrl = "free_shipping=true";
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedUrl));


    }
}
