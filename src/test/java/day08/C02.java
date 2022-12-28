package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02 {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
        driver.quit();
    }
    /*
     https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */
    @Test
    public void test01() throws InterruptedException {
            //● https://the-internet.herokuapp.com/windows adresine gidin.
            driver.get("https://the-internet.herokuapp.com/windows");
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    String expectedSayfaYazisi="Opening a new window";
    String actualSayfaYazisi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String expectedSayfaTitle="The Internet";
    String actualsayfaTitle= driver.getTitle();
    String ilkSayfaHandleDegeri= driver.getWindowHandle();
        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);
    //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);
    /*
           Kontrolsuz acilan tab'a gecis yapmak icin
           1- ilk sayfada iken o sayfanin WHD alip kaydedin
           2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
              acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
           3- su anda elimizde 2 elementli bir Set var,
              elementlerden bir tanesi 1.sayfanin WHD
              1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
           4- bu sekilde 2.sayfanin WHD elde edildikten sonra
              WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
     */
    Set<String> tumWHDegerleriSeti= driver.getWindowHandles();
    String ikinciSayfaWHD="";
        for (String eachWhd: tumWHDegerleriSeti
             ) {
        if (!eachWhd.equals(ilkSayfaHandleDegeri)){
            ikinciSayfaWHD=eachWhd;
        }
    }
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
    String expectedNewSayfaTitle="New Window";
    String actualNewSayfaTitle= driver.getTitle();
        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    String expectedYeniSayfaYazi="New Window";
    String actualYenisayfaYazi= driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedYeniSayfaYazi,actualYenisayfaYazi);
    //● Bir önceki pencereye geri döndükten sonra
    // sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
    expectedSayfaTitle="The Internet";
    actualsayfaTitle= driver.getTitle();
        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);
        Thread.sleep(3000);



        /*
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());//mevcut sekmelerin listesini alma
String firstWindowHandle = windowHandles.get(0);//index sayısına göre geçiş
String firstWindowHandle2 = windowHandles.get(1);
String lastWindowHandle = windowHandles.get(windowHandles.size() - 1);
driver.switchTo().window(firstWindowHandle2);
driver.switchTo().window(firstWindowHandle);
Thread.sleep(3000);
driver.switchTo().window(lastWindowHandle);
Thread.sleep(3000);
         */

}}
