package OfficeHours.Day1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class SeleniumOH1 {


    public static void main(String[] args) throws Exception{
        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("vegetables");
        keysToSearch.add("berries");

        Iterator<String> iterator = keysToSearch.iterator(); //return Iterator type which we can use with all iterator methods
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //print before modification
        //add * to each String and print again

        Iterator<String> iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()){
            String temp = iterator1.next();
            System.out.println(temp);
            System.out.println("*" + temp);
        }



        //create map with <String, String>
        System.out.println("================= MAP ITERATOR ==============");
        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("student_id", "456365934569");
        personalInfo.put("magor", "computer science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(key + " " + personalInfo.get(key));
        }

//        Iterator<Entry<String,String>> mapIterator1 = personalInfo.entrySet().iterator();

        //===========================================
        //SELENIUM
        /*
        id - unique (it is not always available) - we always want to use it when its available
        class - classname
        name
        tag - every element will have a tag

will only work with link:
        linktext
        partial linktext

locator that is using html (syntax)
        css
        xpathh


        ================================
        <input id="global-enhancements-search-query" data-id="search-query"
        data-global-enhancements-search-input="" type="text" name="search_query"
        class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input
        wt-pr-xs-7" placeholder="Search for items or shops" value="" autocomplete="off" autocorrect="off"
         autocapitalize="off">

         input - tag
         key = "value" - attributes
         id="global-enhancements-search-query" - one of the attributes
         we can use id to locate the element

        name="search_query" - attribute - we can use name to locate the element
        class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input
        wt-pr-xs-7" - we can use class to locate the element

        When we want to find element it is always

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://etsy.com");

        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        Thread.sleep(300);
        searchBar.sendKeys("Wooden spoon");
        Thread.sleep(300);


        driver.close();

    }

}
