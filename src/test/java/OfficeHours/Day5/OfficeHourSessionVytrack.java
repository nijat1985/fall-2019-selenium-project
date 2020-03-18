package OfficeHours.Day5;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class OfficeHourSessionVytrack {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        Thread.sleep(2000);

        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a")); //(//a[@href='/contact'])[4] - this xpath also works
        contacts_link.click();

        Thread.sleep(2000);
        WebElement create_contact = driver.findElement(By.linkText("Create Contact"));
        create_contact.click();

        Thread.sleep(2000);
        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last Name", "Smith");
        contact1.put("Phone", "571-326-4545");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Group", "Sales Group");
        contact1.put("Country", "United States");

        System.out.println("contact1 = " + contact1);

        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name = 'field__first-name'])[1]"));
        WebElement last_name = driver.findElement(By.xpath("(//input[@data-name = 'field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state = driver.findElement(By.xpath("//input[@data-name='field__region-text']"));
        WebElement zipCode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("//input[@data-name='field__2']"));

        first_name.sendKeys(contact1.get("First Name"));
        last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
        street.sendKeys(contact1.get("Street"));
        city.sendKeys(contact1.get("City"));
        state.sendKeys(contact1.get("State"));
        zipCode.sendKeys(contact1.get("Zip Code"));

        if (contact1.get("Group").equalsIgnoreCase("true")){
            salesGroup.click();
        }


        /*
        To handle dropdowns in selenium we are using Select class
        to use it we have to ensure we select <select></select> tag in our dropdown
        to create select class we are using web element of <select></select> element from html (we need
        to locate our dropdown which have select tag
         */


        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdown = new Select(country); //this is special in selenium to hndle dropdowns
        /*
        it has diferent methods that help us to interct with dropdown
         */

        Thread.sleep(2000);
        country_dropdown.selectByVisibleText(contact1.get("Country"));




    }
}
