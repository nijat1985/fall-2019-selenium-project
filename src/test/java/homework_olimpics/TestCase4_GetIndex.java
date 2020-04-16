package homework_olimpics;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestCase4_GetIndex extends TestBase {

    @Test
    public void testCase4(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        System.out.println("getIndex(\"Italy\") = " + Arrays.toString(getIndex("Italy")));
    }



    //TODO Write a method that takes country name and returns the row and column number of that country in that table.
    // Return type must be an array of ints.
    // Array length must be 2.
    private int[] getIndex(String countryName) {
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<String> countriesString = BrowserUtils.getElementsText(countries);
        int[] index = new int[2];
        for (int i = 0; i < countriesString.size(); i++) {
            if (countriesString.get(i).equals(countryName)){
                index[0] = i+1;
                break;
            }
        }
        index[1] = 2;

        return index;
    }
}
