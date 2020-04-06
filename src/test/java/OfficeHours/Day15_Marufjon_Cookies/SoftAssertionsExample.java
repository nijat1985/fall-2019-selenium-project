package OfficeHours.Day15_Marufjon_Cookies;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExample {
    @Test
    public void test(){
        Assert.assertEquals(1,2, "first assertion failed");
        Assert.assertEquals(2,2,"second assertion failed");

    }

    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(11,1, "first assertion failed");
        softAssert.assertEquals(22,2, "second assertion failed");

        //softAssert.assertAll();
        softAssert.assertAll("how are you");
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false, "1st assertion");
        System.out.println("First assertion done");

        Assert.assertTrue(true, "2nd assertion"); System.out.println("Second assertion done");
        Assert.assertTrue(true, "3rd assertion"); System.out.println("Third assertion done");

        softAssert.assertTrue(false, "1st assertion");System.out.println("Fourth assertion done");
        softAssert.assertAll();//after this line nothing runs its kinda hard part of soft assert. try to put it at the very end. We can initialize soft assert inside our test base inside before method and put softAssert.assertAll(); inside after method. Then we make sure that it will work properly

        Assert.assertTrue(true, "4th assertion"); System.out.println("Fifth assertion done");

    }
}
