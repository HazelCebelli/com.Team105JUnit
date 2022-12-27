package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */

    static WebDriver driver;

    @BeforeClass
    // @BeforeClass ve @AfterClass notasyonu kullanan method'lar
    // static olmak zorundadir
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Before
    public void beforeTets(){
        driver.get("http://www.google.com ");
    }

    @AfterClass
    public static void teardown() {
       driver.close();
    }

    @Test
    public void test01(){
       //The Lord of the Rings
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement sonuc=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());}

        @Test
        public void test02(){
            //"Brave Heart"
            driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart" + Keys.ENTER);
            WebElement sonuc2 = driver.findElement(By.id("result-stats"));
            System.out.println(sonuc2.getText());

        }
    @Test
    public void test03(){
        //"Harry Potter"

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter"+ Keys.ENTER);
        WebElement sonuc3=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc3.getText());


    }

}
