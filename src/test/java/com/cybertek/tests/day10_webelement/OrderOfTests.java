package com.cybertek.tests.day10_webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {
    String title;



    @Test(priority = 0, description = "i am testing functionality") //description will show in html report
    public void login(){
        System.out.println("open the browser");
        System.out.println("capturing title");
        title ="cbt";
    }


    @Test(priority = 1, dependsOnMethods = "login")//dependsOnMethods shows if this method depends on other method. If that method fails then this one will not run
    public void assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title,"cbt");
    }

    @Test(priority = 55)
    public void verifyOtherThings(){
        System.out.println("verifying something else");
    }

}
