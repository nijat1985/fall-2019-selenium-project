package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateCalendarEventTests extends VytrackTestBase {
    @Test
    public void allDayEventCheckBoxTest(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));
        driver.get("https://qa3.vytrack.com/calendar/event/create"); //if we skip some steps when we are testing webpage this called atomic tests. like in this test case we have to login then click Activities then click create calendar then locate elements. But we can go directly createcalndar webpage skipping steps this atomic testing.

        assertFalse(createCalendarEventPage.allDayEventCheckBox.isSelected());

    }

    @Test
    public void repeatCheckBoxTest(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));
        driver.get("https://qa3.vytrack.com/calendar/event/create"); //if we skip some steps when we are testing webpage this called atomic tests. like in this test case we have to login then click Activities then click create calendar then locate elements. But we can go directly createcalndar webpage skipping steps this atomic testing.

        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventPage.repeatCheckBox));
        assertFalse(createCalendarEventPage.repeatCheckBox.isSelected());
    }
}
