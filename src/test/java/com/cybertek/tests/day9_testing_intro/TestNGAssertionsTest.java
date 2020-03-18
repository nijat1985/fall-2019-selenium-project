package com.cybertek.tests.day9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {
    @Test
    public void test1(){
        String expected = "one";
        String actual = "one";
        Assert.assertEquals(actual,expected);
        System.out.println("test 2 is complete");
    }

    @Test
    public void test2(){
        String expected = "one";
        String actual = "two";

        System.out.println("starting to compare");
        Assert.assertEquals(actual,expected);

        System.out.println("test 2 is complete");


    }

    @Test
    public void test3(){
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(actual,expected);
        System.out.println("test 2 is complete");
    }

    @Test
    public void test4(){
        String expected = "one";
        String actual = "one";
        System.out.println(expected.equals(actual));
        //Assert.assertTrue(expected.equals(actual));

        int e = 100;
        int a = 200;
        Assert.assertTrue(a>e);

    }

    @Test
    public void test5(){
        //verify that url is equal to https://www.google.com/
        String expected= "https://www.google.com/";
        String actual = "https://www.google.com/";

        Assert.assertEquals(expected, actual);

        //verify that title starts with java
        String expected1 = "java";
        String actual1 = "java - Google Search";
        Assert.assertTrue(actual1.contains(expected1));

    }


}
