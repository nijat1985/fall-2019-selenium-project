package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebtablesTests extends TestBase {
    @BeforeMethod
    public void SetUpMethod(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
    }

    @Test
    public void printTable(){
        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println("myTable.getText() = " + myTable.getText());
    }

    //print all headers
    @Test
    public void getHeaders(){
        //get all headers in a sibgle element
        WebElement header = driver.findElement(By.tagName("thead"));
        System.out.println("header.getText() = " + header.getText());
        
        //get all headers in a list
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        System.out.println("BrowserUtils.getElementsText(headers) = " + BrowserUtils.getElementsText(headers));
        
    }

    @Test
    public void getTableSize(){
        //get number of columns
        List<WebElement> coulmns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("coulmns.size() = " + coulmns.size());

        //get number of rows including header
        List<WebElement> rowsWithheader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rowsWithheader.size() = " + rowsWithheader.size());

        //get number of rows without header
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());

    }

    @Test
    public void getSingleRowByIndex(){
        //get the first row (in the body)
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("row.getText() = " + row.getText());

        //get the first row (in the body) dynamic xpath
        String xpath = getTableRowXpath(2);
        row = driver.findElement(By.xpath(xpath));
        System.out.println("row = " + row.getText());

    }

    //getTableRowXpath based on index
    public static String getTableRowXpath(int index){
        String xpath = "//table[@id='table1']/tbody/tr[" + index + "]";
        return xpath;
    }

    //Get single cell based on index
    @Test
    public void getSingleCellBasedOnIndex(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println("cell.getText() = " + cell.getText());

        String xpath = getCellXpathByIndex(2,3);
        cell = driver.findElement(By.xpath(xpath));
        System.out.println("cell.getText() = " + cell.getText());

    }

    //utility for xpath getting a cell from table
    public static String getCellXpathByIndex (int row,int column){
        String xpath = "//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        return xpath;
    }


    //go through the table using loops and get all values
    @Test
    public void iterateTheTableUsingLoops(){
        //get the number of rows
        int rowCount = getRowCount();
        //get the number of columns
        int colCount = getColCount();

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String xpath = getCellXpathByIndex(i,j);
                WebElement cell = driver.findElement(By.xpath(xpath));
                System.out.println("cell.getText() = " + cell.getText());
            }
            System.out.println();
        }

    }

    //returns number of  rows without the table headers
    public int getRowCount(){
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
    }

    public int getColCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
    }

}
