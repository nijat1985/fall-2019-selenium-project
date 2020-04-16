package homework_olimpics;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase1_DefaultSortTest extends TestBase {

    @BeforeMethod
    public void setUp(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
    }


    @Test
    public void sortTests(){
//TODO 2. Verify that by default the Medal table is sorted by rank.
// To do that you need to capture all the cells in the Rank column and check
// if they are in ascending order (highlighted in the picture).

        List<WebElement> rank = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
        rank.remove(10);

        List<String> rankString = BrowserUtils.getElementsText(rank);
        List<Integer> rankInteger = new ArrayList<>();
        for (String each : rankString) {
            rankInteger.add(Integer.parseInt(each));
        }

        List<Integer> rankForSort = new ArrayList<>(rankInteger);
        Collections.sort(rankForSort);

        Assert.assertEquals(rankInteger, rankForSort);

//TODO 3. Click link NOC.
// 4. Now verify that the table is now sorted by the country names. To do that you
// need to capture all the names in the NOC column and check if they are in ascending/alphabetical order
// (highlighted in the picture).

        WebElement noc = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]"));
        noc.click();


        List<WebElement> countriesAfterClick = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a"));
        List<String> countriesAfterClickString = BrowserUtils.getElementsText(countriesAfterClick);
        List<String> countriesAfterClickStringForSort = BrowserUtils.getElementsText(countriesAfterClick);

        Collections.sort(countriesAfterClickStringForSort);

        Assert.assertEquals(countriesAfterClickStringForSort,countriesAfterClickString);


//TODO 5. Verify that Rank column is not in ascending order anymore.

        rank = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
        rankString = BrowserUtils.getElementsText(rank);

        List<String> rankForSortString = new ArrayList<>(rankString);
        Collections.sort(rankForSortString);

        Assert.assertEquals(rankString, rankForSortString);


    }

}
