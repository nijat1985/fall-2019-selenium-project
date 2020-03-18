package com.cybertek.tests.day9_testing_intro;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test//testNG sees this annotation and runs it
    public void test1(){
        System.out.println("test one");
    }

    @Ignore//ignores current method runs the other ones
    @Test
    public void test2(){
        System.out.println("test two");
    }

    @Test
    public void test3(){
        System.out.println("test three");
    }

}
