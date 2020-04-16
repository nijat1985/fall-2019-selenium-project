package homework_olimpics;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase3_CountryByMedal extends TestBase {

    @Test
    public void testCase3(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        System.out.println("getCountriesWithSilverMedal() = " + getCountriesWithSilverMedal());
    }



    //TODO Write a method that returns a list of countries by their silver medal count.
    private List<String> getCountriesWithSilverMedal(){
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<WebElement> silverMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));
        countries.remove(10);
        silverMedals.remove(11);
        silverMedals.remove(10);

        List<String> countriesString = BrowserUtils.getElementsText(countries);
        List<String> silverMedalsString = BrowserUtils.getElementsText(silverMedals);
        List<String> countriesWithSilverMedal = new ArrayList<>();

        for (int i = 0; i < countriesString.size(); i++) {
            countriesWithSilverMedal.add(countriesString.get(i) + " --> " + silverMedalsString.get(i));
        }



        return countriesWithSilverMedal;
    }
}
