package com.cybertek.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //TODO given a list of elements, extract the text of the elements into new list of strings
    /**
     * takes a list of web elements
     * returns a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText().trim());
            }
        }
        return textValues;
    }

    /**
     * write a utility that takes a String title
     * changes to tab with given title,
     * if such title is not found, go back to original window
     * @param driver
     * @param title
     */

    public static void getNewWindowByTitle(WebDriver driver, String title){
        Set<String> windowHandle = driver.getWindowHandles();
        for (String window : windowHandle) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)){
                break;
            }
            driver.switchTo().defaultContent();
        }

    }

    /**
     * write a utility that takes a String url
     * changes to tab with given url,
     * if such url is not found, go back to original window
     * @param driver
     * @param url
     */

    public static void getNewWindowByUrl(WebDriver driver, String url){
        Set<String> windowHandle = driver.getWindowHandles();
        for (String window : windowHandle) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals(url)){
                break;
            }
            driver.switchTo().defaultContent();
        }
    }



    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }



    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /*
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


//    /**
//     * @param name screenshot name
//     * @return path to the screenshot
//     */
//    public static String getScreenshot(String name) {
//        //adding date and time to screenshot name, to make screenshot unique
//        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
//        //where we gonna store a screenshot
//        String path = "";
//
//        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
//        } else {
//            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
//        }
//
//        System.out.println("OS name: " + System.getProperty("os.name"));
//        System.out.println("Screenshot is here: " + path);
//        //since our reference type is a WebDriver
//        //we cannot see methods from TakesScreenshot interface
//        //that's why do casting
//        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
//        //take screenshot of web browser, and save it as a file
//        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        //where screenshot will be saved
//        File destination = new File(path);
//        try {
//            //copy file to the previously specified location
//            FileUtils.copyFile(source, destination);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return path;
//    }



}
