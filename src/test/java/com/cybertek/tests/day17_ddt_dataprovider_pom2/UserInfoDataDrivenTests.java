package com.cybertek.tests.day17_ddt_dataprovider_pom2;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTests {
    @Test(dataProvider = "users") //if we put ", dataProviderClass = LoginPage.class" inside the parantheses it means it will go that class and will take data there
    public void test(String username, String email, int number){ // this order will same in dataProvider in array. So it will take user1 as username, UserUser123 as email, 25 as number
        System.out.println("openning application");
        System.out.println("login as: "+ username);
        System.out.println("number is: " + number);
        System.out.println("verify info");
    }

    @DataProvider(name = "users")
    public Object[][] getUsers(){
        return new Object[][] //the number of arrays inside this 2 Dimensional array define how many time Test will run.
                {
                        {"user1", "UserUser123", 25},
                        {"salesmanager355", "UserUser123", 26},
                        {"storemanager355", "UserUser123", 236},
                        {"salesmanager400", "UserUser123", 262}
                };
    }


}
