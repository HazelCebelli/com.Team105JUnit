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

public class C03 {
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



// ilk sayfaya geri donup sayfadaki yazinin
// "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        // elemental selenium linkini tiklayin
    driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        Thread.sleep(3000);
    driver.findElement(By.linkText("Elemental Selenium")).click();

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
    Set<String> tumWHDegerleriSeti= driver.getWindowHandles();
    String ikinciSayfaWHD="";
        for (String eachWhd: tumWHDegerleriSeti
             ) {
        if (!eachWhd.equals(ilkSayfaHandleDegeri)){
            ikinciSayfaWHD=eachWhd;
        }
    }

        driver.switchTo().window(ikinciSayfaWHD);

    String expectedEnBuyukKleime="Elemental Selenium";
    String actualEnBuyukKleime=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedEnBuyukKleime,actualEnBuyukKleime);

        // ilk sayfaya geri donup sayfadaki yazinin
        driver.switchTo().window(ilkSayfaHandleDegeri); //main window

        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin


    String expectedilkSayfaKleime="An iFrame containing the TinyMCE WYSIWYG Editor";
    String actualIlkSayfaKelime= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedilkSayfaKleime,actualIlkSayfaKelime);

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
