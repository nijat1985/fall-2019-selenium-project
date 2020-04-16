package homework_olimpics;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase5_GetSum extends TestBase {

    @Test
    public void getSum(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        System.out.println("getSum18() = " + getSum18().toString());
    }



    //TODO Write a method that returns a list of two countries whose sum of bronze medals is 18.

    private List<String> getSum18(){
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<WebElement> bronzeMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));

        List<String> countriesString = BrowserUtils.getElementsText(countries);
        List<String> bronzeMedalsString = BrowserUtils.getElementsText(bronzeMedals);
        List<Integer> bronzeMedalsInteger = new ArrayList<>();
        List<String> sumBronzeMedal18 = new ArrayList<>();
        for (String each : bronzeMedalsString) {
            bronzeMedalsInteger.add(Integer.parseInt(each));
        }

        outer: for (int i = 0; i < bronzeMedalsInteger.size(); i++) {
            inner: for (int j = 0; j < bronzeMedalsInteger.size(); j++) {
                if (((bronzeMedalsInteger.get(i)+bronzeMedalsInteger.get(j)) == 18) && (i != j)){
                    sumBronzeMedal18.add(countriesString.get(i));
                    sumBronzeMedal18.add(countriesString.get(j));
                    break outer;
                }
            }

        }

        return sumBronzeMedal18;
    }
}
