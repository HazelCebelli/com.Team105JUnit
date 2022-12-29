package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04 extends TestBase {

    @Test
    public void test01(){

//1- Bir Class olusturalim KeyboardActions1
//2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
//3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);

//4- aramanin gerceklestigini test edin




    }
}
