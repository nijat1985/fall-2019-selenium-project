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

    @Test()//threadPoolSize = 4, invocationCount = 4, timeOut = 17000
    public void dashBoardPage(){
        test = report.createTest("Dashboard page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        test.info("Logging into application");


        loginPage.login(username,password);


        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();

        test.info("Verifiying page header text");

        assertEquals(actual, "Quick Launchpad");

        test.pass("Pass: Dashboard page title test");
    }

    //go to vytrack
    //go to fleet vehicle
    //login as a driver
    //verify that header is "Cars"

    @Test
    public void fleetVehiclesTest(){

        test = report.createTest("Vehicles page title test");

        //use login to login page
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        test.info("Logging into application");
        test.info("Username: " + username);
        test.info("Password: " + password);

        loginPage.login(username,password);


        test.info("Going to Fleet -> Vehicles");
        //use dashboard page cahnge page
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicle));
        dashboardPage.vehicle.click();


        //use vehicle page
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));

        test.info("Verifiying page header text");

        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Cars");

        test.pass("Pass: Vehicles page title test");
    }

    @Test
    public void customersContacts() throws InterruptedException {
        test = report.createTest("Contacts page title test");

        // use login to login
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        test.info("Username: " + username);
        test.info("Password: " + password);
        loginPage.login(username, password);
        // use dashbaord change page

        test.info("Going to Customers -> Contacts");
        dashboardPage.changeMenu("Customers", "Contacts");

        // use the fllet / vehicles page to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Contacts"));
        test.info("Verifying page header");
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Contacts");
        test.pass("PASS: Contacts page title test");

    }

}
