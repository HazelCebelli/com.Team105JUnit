package day05_jUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_beforeAfter {

    /* Üc farklı test method'u olusturun
    herbir method'un başında driver'i oluşturup
    1- amazon.com'a
    2- wisequarter.com
    3- youtube.com'a gidip
    title'ları yazdırın ve method'dan sonra driveri kapatın
     */
    WebDriver driver;

        @Before
        public void setup(){
       WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            System.out.println("setup methodu calisti");
   }

       @After
       public void tearDown(){
           System.out.println("tearDown calisti");
                driver.close();
       }


        @Test

        public void test01(){
        driver.get("https://www.amazon.com");
        driver.getTitle();
       }

        @Test
        public void test02(){
                driver.get("https://www.wisequarter.com");
                driver.getTitle();
        }

        @Test
        public void test03(){
                    driver.get("https://www.youtube.com");
                    driver.getTitle();
    }

}
