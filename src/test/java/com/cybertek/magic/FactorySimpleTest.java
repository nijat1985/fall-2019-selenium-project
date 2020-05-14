package com.cybertek.magic;

import org.testng.annotations.*;

public class FactorySimpleTest {
    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new SimpleTest(0), new SimpleTest(20), new SimpleTest(30) };
    }

//    @Optional
//    @Parameters
//    @DataProvider
//    @Factory
//    @Ignore
//
//
//    @Test
//
//    @BeforeMethod
//    @AfterMethod
//
//    @BeforeClass
//    @AfterClass
//
//    @BeforeSuite
//    @AfterSuite
//
//    @BeforeTest
//    @AfterTest
//
//    @BeforeGroups
//    @AfterGroups






}
