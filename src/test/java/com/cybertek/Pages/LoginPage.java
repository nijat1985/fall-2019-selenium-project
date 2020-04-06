package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        //page object classes needs constructor. Here we have to call PageFactory class
        //from Selenium and pass a webdriver object and this class as param
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //FindBy --> we provide the locator for WebElement
    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement login;

    @FindBy(css = ".alert-error>div")
    public WebElement errorMessage;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }

}
