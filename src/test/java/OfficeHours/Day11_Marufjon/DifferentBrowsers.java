package OfficeHours.Day11_Marufjon;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers extends TestBase {
    @Test
    public void test(){
        //which browser am I using right now
        //get the valur from properties file
        System.out.println("OPTION 1");
        System.out.println(ConfigurationReader.getProperty("browser"));

        //get the value from webdriver
        System.out.println("OPTION 2");
        System.out.println(driver);

        if (driver.toString().contains("ChromeDriver")){
            System.out.println("This is chrome");
        }

        System.out.println("OPTION 3");
        System.out.println(driver instanceof ChromeDriver);
        if (driver instanceof FirefoxDriver){
            System.out.println("This is firefox");
        }else if (driver instanceof ChromeDriver){
            System.out.println("This is chrome");
        }
    }
}
