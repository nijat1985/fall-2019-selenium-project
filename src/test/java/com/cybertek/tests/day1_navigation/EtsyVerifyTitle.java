package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;

public class EtsyVerifyTitle {
    public static void main(String[] args) {
        //Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/?utm_source=bing&utm_medium=cpc&utm_term=etsy_e&utm_campaign=Search_US_Brand_BNG_General-Brand_Core_All_HP_Exact&utm_ag=A1&utm_custom1=f7c812ac-9822-4ad3-b547-b514e13e8a10&utm_content=bing_131876476_2730742026_81638801061044_kwd-38923007297:aud-807618753:loc-190_c_&utm_custom2=131876476&msclkid=077a1d712c0115299ebb432d271821cf");

        String expectedResult = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualResult = driver.getTitle();

        driver.manage().window().maximize();

        if (expectedResult.equals(actualResult)){
            System.out.println("PASS...");
        }else{
            System.out.println("FAIL...");
            System.out.println("I expected: " + expectedResult);
            System.out.println("Actual result is: " + actualResult);
        }

        driver.close();

//        long startTime = System.currentTimeMillis();
//
//
//        long endTime = System.currentTimeMillis();



    }
}
