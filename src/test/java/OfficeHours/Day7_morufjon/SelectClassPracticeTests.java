package OfficeHours.Day7_morufjon;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectClassPracticeTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //TODO go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    // verify thet table has dropdown with values Family, Friends, Coworkers, Business, Contacts


    @Test
    public void test() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");

        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        //TODO getOptions() --> gives all available options as a list of web elements
        List<WebElement> allOptions = categories.getOptions();
        System.out.println("allOptions = " + allOptions.size());

        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("Family");
        expectedOptions.add("Friends");
        expectedOptions.add("Coworkers");
        expectedOptions.add("Businesses");
        expectedOptions.add("Contacts");

        //TODO given a list of elements, extract the text of the elements into new list of strings
        List<String> actualOptions = BrowserUtils.getElementsText(allOptions);


        Assert.assertEquals(actualOptions,expectedOptions);
    }

    //TODO go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    // select option Coworkers
    // verify that that Coworkers is now selected
    // select options Contacts
    // verify that contacts is selected

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");

        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        //select option Coworkers
        categories.selectByVisibleText("Coworkers");

        //verify that Coworkers option is now selected
        //getFirstSelectedOption() --> returns the currently selected option as web element
        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        String actual = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,"Coworkers");


        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        categories.selectByVisibleText("Contacts");
        //verify that Contacts option is now selected
        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        String actual2 = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual2,"Contacts");
    }

    /**
     * go to http://practice.cybertekschool.com/dropdown
     * verify taht days table has days sorted in ascending order
     */

    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select days = new Select(driver.findElement(By.id("day")));
        List<WebElement> options = days.getOptions();
        System.out.println("options.size() = " + options.size());

        //TODO I have a list of web elements, i need to verify if the values (numbers) are sorted in accending order
        List<String> stringList = BrowserUtils.getElementsText(options);
        List<Integer> integerList = new ArrayList<>();
        for (String each : stringList) {
            integerList.add(Integer.parseInt(each));
        }

        //verify list of ints is sorted

        //create copy of integerlist and store them into integerListCopy
        List<Integer> integerListCopy = new ArrayList<>(integerList);
        //sort the integerlist
        Collections.sort(integerList);

        //compare
        Assert.assertEquals(integerList, integerListCopy);

    }

    //TODO go to google.com
    // move your mouse on top of I am feeling lucky
    // verify that button now has a different text
    // Move the mouse away
    // Do this many times
    // When you get "I am feeling stellar" 3 times, print "Deal with it" in console and exit the program

    @Test
    public void test4(){
        driver.get("https://www.google.com/");

    }


}
