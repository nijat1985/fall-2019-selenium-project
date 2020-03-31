package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {
    /*
    go to practice website
    click on file upload link
    upload a file
    click submit
    verify file name is displayed in next page
     */

    @Test(description = "upload file test")
    public void fileUploadTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);



        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("/Users/nijat1985/Desktop/my_file.txt"); // in order to upload file we dont click choose file we do send keys

        WebElement fileSubmit = driver.findElement(By.id("file-submit"));
        fileSubmit.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(),"my_file.txt");

    }
}
