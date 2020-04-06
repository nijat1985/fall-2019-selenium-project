package com.cybertek.base;

import com.cybertek.Pages.CreateCalendarEventPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.Pages.VehiclesPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;
    protected CreateCalendarEventPage createCalendarEventPage;


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        wait = new WebDriverWait(driver, 5);
        softAssert = new SoftAssert();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();
        createCalendarEventPage = new CreateCalendarEventPage();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(2000);
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
