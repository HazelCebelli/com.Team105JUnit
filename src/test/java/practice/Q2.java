package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class Q2 extends TestBase {
@Before
    public void beforeTest(){
        //  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
    }
    @Test
    public void titleTest(){

//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        Assert.assertTrue(driver.getTitle().contains("Best") );

//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin



    }

    @Test
    public void logoTest(){
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello!']"));
        WebElement bestBuy = driver.findElement(RelativeLocator.with(By.xpath("(//img[@class='logo'])[1]")).above(hello));

        Assert.assertTrue(bestBuy.isDisplayed());
    }


}
