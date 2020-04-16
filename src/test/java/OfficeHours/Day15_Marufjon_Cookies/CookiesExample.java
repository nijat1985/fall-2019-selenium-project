package OfficeHours.Day15_Marufjon_Cookies;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesExample extends TestBase {
    @Test
    public void test(){
        //print some cookies
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password", Keys.ENTER);

        System.out.println(driver.getCurrentUrl());

        
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());
        for (Cookie cookie: cookies){
            System.out.println("cookie.toString() = " + cookie.getName());
        }


        //delete all cookies
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());


        //print cookies again after deletion
        Set<Cookie> cookies1 = driver.manage().getCookies();
        for (Cookie cookie : cookies1) {
            System.out.println("cookie.getName() = " + cookie.getName());
        }
        //System.out.println("cookies1.size() = " + cookies1.size());

        //Add cookie
        Driver.closeDriver();
        driver = Driver.getDriver();
        driver.get("http://a.testaddressbook.com/addresses");
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
}
