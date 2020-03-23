package com.cybertek.tests.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    //TODO given a list of elements, extract the text of the elements into new list of strings
    /**
     * takes a list of web elements
     * returns a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> listEl){
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl){
            listSt.add(element.getText());
        }
        return listSt;
    }
}
