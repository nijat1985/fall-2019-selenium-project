package com.cybertek.magic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    private int param;

    public SimpleTest(int param) {
        this.param = param;
    }

    @Test(dependsOnMethods = "AtestMethodTwo")
    public void BtestMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);

    }

    @Test()
    public void AtestMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
        Assert.assertTrue(false);
    }
}
