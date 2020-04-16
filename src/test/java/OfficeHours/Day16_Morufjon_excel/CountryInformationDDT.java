package OfficeHours.Day16_Morufjon_excel;

import com.cybertek.utilities.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountryInformationDDT {
    WebDriver driver;
    Workbook workbook;
    Sheet workSheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = Driver.getDriver();
        fileInputStream = new FileInputStream("src/test/resources/Countries.xlsx");
        workbook = WorkbookFactory.create(fileInputStream);
        workSheet = workbook.getSheet("Countries");
    }

    @Test
    public void test(){
        int count = workSheet.getPhysicalNumberOfRows();
        boolean match = true;
        for (int i = 1; i < count; i++) {
            Row currentRow = workSheet.getRow(i);
            String execute = currentRow.getCell(0).toString();
            System.out.println("execute = " + execute);
            if (execute.equals("y")){
                //continue test
                String country = currentRow.getCell(1).toString();
                String capital = currentRow.getCell(2).toString();
                driver.get("https://wikipedia.org");
                driver.findElement(By.id("searchInput")).sendKeys(country + Keys.ENTER);
                String actual = driver.findElement(By.xpath("//th[starts-with(text(),'Capital')]/following-sibling::td//a")).getText();
                if (capital.equals(actual)){
                    currentRow.getCell(3).setCellValue("PASS");
                }else {
                    currentRow.getCell(3).setCellValue("FAIL");

                    currentRow.createCell(4);
                    currentRow.getCell(4).setCellValue(actual);
                    match = false;
                }

            }else{
                //skip
                currentRow.getCell(3).setCellValue("SKIP");
                continue;
            }
        }

        assertTrue(match);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        Driver.closeDriver();
        fileOutputStream = new FileOutputStream("src/test/resources/Countries.xlsx");
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

    //th[starts-with(text(),'Capital')] --> giv me th tag which starts with Capital text
    //th[starts-with(text(),'Capital')]/../td/a --> giv me th tag which starts with Capital text
                                                  //go to parent
                                                  //go to child td
                                                  //go to child a
    //th[starts-with(text(),'Capital')]/following-sibling::td --> giv me th tag which starts with Capital text
                                                                  //then give following sibling td
                                                                  //then give me child of td which is a


}
