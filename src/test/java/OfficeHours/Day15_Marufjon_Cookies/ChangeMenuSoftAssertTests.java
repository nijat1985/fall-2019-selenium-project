package OfficeHours.Day15_Marufjon_Cookies;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChangeMenuSoftAssertTests extends VytrackTestBase {
    // go to Vytrack
    //verify we are logged in
    // change menu to vehicles and verify title
    // change menu to custimers and verify title
    @Test
    public void test() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
        assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/login", "url failed");

        dashboardPage.changeMenu("Fleet","Vehicles");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("my Jeep car"), "Vehicles Page title did not match");

        dashboardPage.changeMenu("Customers","Accounts");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Accounts"), "Accounts Page title did not match");

    }
}
