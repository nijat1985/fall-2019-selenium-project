package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.Pages.CreateCalendarEventPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.Pages.VehiclesPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;
    protected CreateCalendarEventPage createCalendarEventPage;

    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpSuite(){
        report = new ExtentReports();
        //i need to point to the location where report will ne create
        //System.getProperty("user.dir") --> gets my current folder
        //+ "test-output/report.html --> create folder test-output and in it create file report.html
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        //initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html reporter to the report object
        report.attachReporter(htmlReporter);

        //set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }

    @AfterSuite
    public void tearDownSuite(){
        //the report will be created when we call this line
        //if we dont call flush method it will not be generated
        //we do this at the end of the everything
        report.flush();
    }

    @Parameters("url")
    @BeforeMethod ()
    public void setUpMethod(@Optional String url){
        System.out.println("url = " + url);
        driver = Driver.getDriver();
        driver.manage().window().maximize();

        if (url == null) {
            driver.get(ConfigurationReader.getProperty("vytrack_url"));
        }else {
            driver.get(url);
        }
        wait = new WebDriverWait(driver, 5);
        softAssert = new SoftAssert();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();
        createCalendarEventPage = new CreateCalendarEventPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {

        //ITestResult (This is a class from testNG) gives information about current test: name, status
        //check if the test failed
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            //tell extent report that the test failed
            test.fail(iTestResult.getName());

            //take screen shot of the screen and save location
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());

            //show path to screenShot
            test.addScreenCaptureFromPath(screenshot);
        }

        Thread.sleep(2000);
        Driver.closeDriver();
        softAssert.assertAll();
    }
    

}
