package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExample {
    @Test
    public void test(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));

        //browser url

        Properties properties = new Properties();
        properties.setProperty("browser","chrome");
        properties.setProperty("url", "https://practice.cybertekschool.com");

        String browserTest = properties.getProperty("browser");
        String url = properties.getProperty("url");
        System.out.println("browser = " + browserTest);
        System.out.println("url = " + url);

        //i need to read the browser/url from properties file
        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String pUrl = ConfigurationReader.getProperty("url");
        System.out.println("pUrl = " + pUrl);

        String str = Singleton.getInstance();
        System.out.println("str = " + str);

    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //get the url the from properties file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();
        String str = Singleton.getInstance();
        System.out.println("str = " + str);
    }

    @Test
    public void test3(){
        String str = Singleton.getInstance();
        System.out.println("str = " + str);
    }

}
