package com.cybertek.tests.day11_select_actions;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectClassTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }


    @Test
    public void printSelectedOption(){
        //find the element that have select tag
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //create a select class using the web element
        Select dropdownList = new Select(dropdown);

        //get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println("selectedOption = " + selectedOption.getText());

        //verify selected option
        Assert.assertEquals(selectedOption.getText(),"Please select an option");
    }

    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));

        //create select class
        Select states = new Select(dropdown);

        //TODO selectByVisibleText() --> select by the text of the option
        states.selectByVisibleText("Iowa");
        Thread.sleep(2000);
        states.selectByVisibleText("Vermont");
        Thread.sleep(2000);
        states.selectByVisibleText("Kentucky");

        //TODO selectByIndex(0) --> selects based on the index of the option, 0 based index
        states.selectByIndex(0);
        Thread.sleep(2000);
        states.selectByIndex(10);
        Thread.sleep(2000);
        states.selectByIndex(20);

        //TODO selectByValue() --> selects based on the value attribute of the option. It is not select by text
        states.selectByValue("VA");
        Thread.sleep(2000);
        states.selectByValue("SC");
        Thread.sleep(2000);
        states.selectByValue("CO");
    }


    @Test
    public void getAllAvailableOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));

        //print the current selection
        System.out.println(monthList.getFirstSelectedOption().getText());

        //TODO getOptions() --> returns all of the available options from dropdown
        List<WebElement> allOptions = monthList.getOptions();
        System.out.println("Number of month: " + allOptions.size());
        for (WebElement month : allOptions) {
            System.out.println(month.getText());
        }

        //TODO verify that month list always shows the current month as selected
        //TODO get the current month
        String expected = LocalDate.now().getMonth().name().toLowerCase();
        String actual = monthList.getFirstSelectedOption().getText().toLowerCase();
        Assert.assertEquals(expected,actual);

        //TODO verify that month list has following values values: January ...... December
        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        List<String> actualMonths = new ArrayList<>();
        for (WebElement allOption : allOptions) {
            actualMonths.add(allOption.getText());
        }

        Assert.assertEquals(actualMonths,expectedMonths);

    }

    @Test
    public void verifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));
        //TODO verify that list has 3 options
        int expectedSize = 3;
        int actualSize = list.getOptions().size();
        Assert.assertEquals(expectedSize, actualSize);

        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");
        List<String> actualValues = new ArrayList<>();
        for (WebElement option : list.getOptions()) {
            actualValues.add(option.getText());
        }

        Assert.assertEquals(actualValues,expectedValues);
    }


}
