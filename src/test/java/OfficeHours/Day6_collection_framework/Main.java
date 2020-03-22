package OfficeHours.Day6_collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //lets assume you are searching for iphone
        // many search results came in
        // i want you to store all the price element on the  result page
        // in the mean time i want you to store all the price text into a list
        // we can use findElements and getText together
        // it will give us a List<String> that contains prices
        // but we want to get List<Double>

//        String price = "100.99";
//        double priceNum = Double.parseDouble(price);
//        System.out.println("price = " + price);

        List<String> pricelstStr = new ArrayList<>(Arrays.asList("99.99", "149.99", "79.99", "149.99", "299.99", "599.99"));
        pricelstStr.add("999.99");
        System.out.println("pricelstStr = " + pricelstStr);

        // but we want to get List<Double>
        List<Double> prices = new ArrayList<>();
        for (String each : pricelstStr) {
            prices.add(Double.parseDouble(each));
        }

        System.out.println("prices = " + prices);

        // how do i have max price, min, average
        double max = 0.0;
        int count = 0;
        for (double each : prices) {
            if (each > max){
                max = each;
            }
            count++;
        }
        System.out.println("max = " + max);
        double min = prices.get(0);
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < min){
                min = prices.get(i);
            }
        }
        System.out.println("min = " + min);

        double sum = 0;
        for (Double each : prices) {
            sum += each;
        }
        double average = sum / count;
        System.out.println("average = " + average);

        //remove items above averge
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) > average){
                prices.remove(i);
                i--;
            }
        }
        System.out.println("prices = " + prices.toString());

        //get the unquie prices
        HashSet<Double> unique = new HashSet<>(prices);
        System.out.println("unique = " + unique);



    }
}
