package homework_olimpics;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase2_TheFirstFromTheButtom extends TestBase {
    @Test
    public void testCase2(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        System.out.println("getCountryWithLeastGold() = " + getCountryWithLeastGold());
        System.out.println("getCountryWithLeastSilver() = " + getCountryWithLeastSilver());
        System.out.println("getCountryWithLeastBronze() = " + getCountryWithLeastBronze());

    }


    //TODO Write a method that returns the name of the country with the smallest number of gold medals.
    private String getCountryWithLeastGold(){
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<WebElement> goldMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));
        countries.remove(10);
        goldMedals.remove(11);
        goldMedals.remove(10);

        List<String> countriesString = BrowserUtils.getElementsText(countries);
        List<String> goldMedalsString = BrowserUtils.getElementsText(goldMedals);
        List<Integer> goldMedalsInteger = new ArrayList<>();
        for (String each : goldMedalsString) {
            goldMedalsInteger.add(Integer.parseInt(each));
        }
        int min = goldMedalsInteger.get(0);
        String country = "";
        for (int i = 0; i < goldMedalsInteger.size(); i++) {
            if (goldMedalsInteger.get(i) <= min){
                min = goldMedalsInteger.get(i);
                country = countriesString.get(i);
            }
        }



        return country;
    }


    //TODO Write a method that returns the name of the country with the smallest number of silver medals.
    private String getCountryWithLeastSilver(){
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<WebElement> silverMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));
        countries.remove(10);
        silverMedals.remove(11);
        silverMedals.remove(10);

        List<String> countriesString = BrowserUtils.getElementsText(countries);
        List<String> silverMedalsString = BrowserUtils.getElementsText(silverMedals);
        List<Integer> silverMedalsInteger = new ArrayList<>();
        for (String each : silverMedalsString) {
            silverMedalsInteger.add(Integer.parseInt(each));
        }
        int min = silverMedalsInteger.get(0);
        String country = "";
        for (int i = 0; i < silverMedalsInteger.size(); i++) {
            if (silverMedalsInteger.get(i) <= min){
                min = silverMedalsInteger.get(i);
                country = countriesString.get(i);
            }
        }



        return country;
    }


    //TODO Write a method that returns the name of the country with the smallest number of bronze medals.
    private String getCountryWithLeastBronze(){
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<WebElement> bronzeMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));
        countries.remove(10);
        bronzeMedals.remove(11);
        bronzeMedals.remove(10);

        List<String> countriesString = BrowserUtils.getElementsText(countries);
        List<String> bronzeMedalsString = BrowserUtils.getElementsText(bronzeMedals);
        List<Integer> bronzeMedalsInteger = new ArrayList<>();
        for (String each : bronzeMedalsString) {
            bronzeMedalsInteger.add(Integer.parseInt(each));
        }
        int min = bronzeMedalsInteger.get(0);
        String country = "";
        for (int i = 0; i < bronzeMedalsInteger.size(); i++) {
            if (bronzeMedalsInteger.get(i) <= min){
                min = bronzeMedalsInteger.get(i);
                country = countriesString.get(i);
            }
        }



        return country;
    }
}
