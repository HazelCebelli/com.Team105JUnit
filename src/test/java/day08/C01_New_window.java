package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_New_window {

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
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        Thread.sleep(3000);

        //yeni bir tabda WeiseQuarter'a gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");
        Thread.sleep(3000);

        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(3000);


    }

}
