package just_for_fun;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Swithces extends TestBase {
    @Test
    public void test(){
        driver.get("http://te.dev.secureci.com/Exercise2.html");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='slider round']"));
        for (WebElement each : elements){
            each.click();
        }

    }
}
