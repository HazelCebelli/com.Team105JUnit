package day09;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FacebookActions extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com/");
        WebElement newAccount=driver.findElement(By.xpath("//a[.='Create new account']"));
        newAccount.click();

        WebElement firstName=driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String mailAdresi=faker.internet().emailAddress();
        actions
                .click(firstName)
                .sendKeys(faker.name().firstName()+Keys.TAB)
                .sendKeys(faker.name().lastName()+Keys.TAB)
                .sendKeys(mailAdresi+Keys.TAB)
                .sendKeys(mailAdresi+Keys.TAB)
                .sendKeys(faker.internet().password()+Keys.TAB+Keys.TAB)
                .sendKeys("23"+Keys.TAB)



                .perform();
        ReusableMethods.bekle(2);




    }
}
