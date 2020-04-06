package OfficeHours.Day13_Marufjon_1pm_3pm;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice extends TestBase {
    @BeforeMethod
    public void setUoTests(){
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("10");
        driver.findElement(By.id("preview")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");

    }

    @Test
    public void testHeaderCount(){

        WebElement table = driver.findElement(By.tagName("table"));
        //get all the values in the table
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(),6);
    }

    /*
    verify that value of each entry under gender column is equal to Male or Female
     */

    @Test
    public void verifyGender(){
        List<WebElement> allGenders = driver.findElements(By.xpath("//table[@style]/tbody/tr/td[5]"));
        System.out.println("allGenders.size() = " + allGenders.size());

        List<String> genders = BrowserUtils.getElementsText(allGenders);
        for (String each: genders){
            Assert.assertTrue(each.equals("Male") || each.equals("Female"));
        }
    }

    //get cell in relation to another cell
    @Test
    public void verifyCellValueByOtherCell(){
        String firstname = "Jason";
        String xpath = "//table[@id='table1']//td[2][.='" + firstname + "']/../td[4]";
        WebElement amount = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(amount.getText(),"$100");
    }

    public String getXpathForValue(String value, String columnIdx){
        String xpath = "/table[@id='table1']//td[.='" + value + "']/../td[" + columnIdx + "]";
        return xpath;
    }

}
