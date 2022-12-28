package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

   static WebDriver driver;

   @BeforeClass
    public static void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

        /*Gerekli ayarlamaları yapıp
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin

    3 test methodu olusturup her method'da bir JsAlert'e basın
    ilgili method'ları kullanın
     */

    @Test   //TEST METHODLARI STATIC OLMAZ
    public void Alert01(){
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//*[text()=‘Click for JS Alert’]")).click();
    }

    @Test
    public void Alert02(){

    }
    @Test
    public void Alert03(){

    }
}
