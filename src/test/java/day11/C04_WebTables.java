package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){
//    1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
//   2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

//3.Web table tum body’sini yazdirin
        WebElement tumBody=driver.findElement(By.xpath("//tbody//tr//td"));
        System.out.println(tumBody);

//4.Web table’daki satir sayisinin 12 oldugunu test edin
        List<WebElement> tumStir=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(12,tumStir.size() );

//5.Tum satirlari yazdirin

//6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> ucuncuSatirSutunListesi=driver.findElements(By.xpath("//tbody/tr[3]/td"));
       // Assert.assertEquals();

//7. 5.sutunu yazdirin
        List<WebElement> besinciSutunListesi=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for(WebElement eachElement: besinciSutunListesi){
            System.out.println(eachElement.getText().trim());
        }

//8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        WebElement istenenDataElementi=getElement(3,5);
        ReusableMethods.bekle(5);
  }
  private WebElement getElement(int satir, int sutun){
        String dynamicXpath="//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement istenenElement=driver.findElement(By.xpath(dynamicXpath));
        return istenenElement;
  }

}
