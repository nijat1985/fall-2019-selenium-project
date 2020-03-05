package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {
        //create object from faker class
        Faker fakeData = new Faker();
        //I need first name
        String name = fakeData.name().firstName();
        System.out.println(name);

    }
}
