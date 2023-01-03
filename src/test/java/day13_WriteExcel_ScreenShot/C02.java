package day13_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02 extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        //Tum sayfanin screen shotini almak icin
       // 1. obje olusturun
        TakesScreenshot tss= (TakesScreenshot) driver;

        //2. resmi son olarak kaydedecegimiz dosyayi olusturun
        // nerede olsuturacagimiz soylememiz lazim
        File tumSayfaScreenShot=new File("target/ekranResimleri/tumEkranSS.jpeg");

        //3. tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydedelim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        //4. Gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);



    }
}
