package com.cybertek.tests.day16_page_object_model;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.base.TestBase;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageHeadersTests extends VytrackTestBase {
    //go to vytrack
    //login as a driver
    //verify that header is Quick Launchpad

    @Test
    public void dashBoardPage(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username,password);


        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        assertEquals(actual, "Quick Launchpad");
    }

    //go to vytrack
    //go to fleet vehicle
    //login as a driver
    //verify that header is "Cars"

    @Test
    public void fleetVehiclesTest(){
        //use login to login page
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username,password);

        //use dashboard page cahnge page
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicle));
        dashboardPage.vehicle.click();

        //use vehicle page
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Cars");
    }

}
