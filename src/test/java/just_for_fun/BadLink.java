package just_for_fun;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BadLink extends TestBase {
    @Test
    public void test(){
        driver.get("http://te.dev.secureci.com/Exercise1.html");
        driver.findElement(By.xpath("//area[@href='BadLink.html']")).click();

    }
}
