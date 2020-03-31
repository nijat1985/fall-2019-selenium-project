package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    //TODO given a list of elements, extract the text of the elements into new list of strings
    /**
     * takes a list of web elements
     * returns a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> listEl){
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl){
            listSt.add(element.getText().trim());
        }
        return listSt;
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

}
