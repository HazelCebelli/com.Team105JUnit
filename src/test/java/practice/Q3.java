package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q3 extends TestBase {

    @Test
    public void practice() throws InterruptedException {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
   driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully

//4. Click on 'Contact Us' button
        WebElement contactUsbButton=driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactUsbButton.click();

//5. Verify 'GET IN TOUCH' is visible
        WebElement inTouchYazisi=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));

        String actualYazi=inTouchYazisi.getText().trim();
        System.out.println(actualYazi);
        Assert.assertTrue(inTouchYazisi.isDisplayed());

//6. Enter name, email, subject and message
        WebElement firstName=driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String mailAdresi=faker.internet().emailAddress();
        Thread.sleep(2000);
        actions
                .click(firstName)
                .sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(mailAdresi+Keys.TAB)
                .sendKeys("Buzdaginin Gorunmeyen Yuzu"+Keys.TAB)
                .sendKeys("Ayse Hocama ve T105'e 2023 bol sans, basari ve mutluluk getirsin"+Keys.TAB)
                .perform();
//7. Upload fileYilbasina si
//8. Click 'Submit' button
//9. Click OK button
//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//11. Click 'Home' button and verify that landed to home page successfully


        /*
        WebElement uploadElement=driver.findElement(By.xpath("//input[@ name='upload_file']"));
 String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Belgeler\\merhabajava.docx";

uploadElement.sendKeys(dosyaYolu);
         */

    }



}
