package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    /*
     1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
     Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
     titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    logoTest => BestBuy logosunun görüntülendigini test edin
    FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    BestBuy.comBestBuy.com
    Best Buy | Official Online Store | Shop Now & Save
    Shop Best Buy for electronics, computers, appliances, cell phones, video games & more new tech. In-store pickup & free 2-day shipping on thousands of items.*/

    static WebDriver driver;

    @BeforeClass
    // @BeforeClass ve @AfterClass notasyonu kullanan method'lar
    // static olmak zorundadir
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/ ");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }




}
