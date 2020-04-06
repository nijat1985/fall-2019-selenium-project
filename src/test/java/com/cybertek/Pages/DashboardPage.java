package com.cybertek.Pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends VytrackPageBase {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
