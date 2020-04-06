package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.Pages.LoginPage;
import com.cybertek.base.VytrackTestBase;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTests2 extends VytrackTestBase {

    @Test(dataProvider = "usersList")
    public void test(String username, String password, String expectedName){
        loginPage.login(username,password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualName = dashboardPage.accountHolderName.getText();
        assertEquals(actualName,expectedName);
    }

    @DataProvider(name = "usersList")
    public Object[][] getUsers() {
        return new Object[][]
                {
                        {"user1", "UserUser123", "John Doe"},
                        {"user2", "UserUser123", "John Doe"},
                        {"user3", "UserUser123", "John Doe"},
                        {"user4", "UserUser123", "Kyleigh Reichert"},
                        {"user5", "UserUser123", "Nona Carroll"},
                        {"user6", "UserUser123", "Raphael Gusikowski"},
                        {"user7", "UserUser123", "Dominique Deckow"},
                        {"user8", "UserUser123", "Valentine Bode"},
                        {"user9", "UserUser123", "Deborah Wolf"},
                        {"user10", "UserUser123", "Toney Hegmann"},
                };
    }

}
