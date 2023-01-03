package utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

public class ReusableMethods {

    public static void bekle(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
        }


/*public static void tumSayfaScreenShotCek(WebDriver driver){

        // 1- TakeScreenshot objesi olustur
        TakesScreenshot tss= (TakesScreenshot) driver;
// 2- resmi son olarak kaydedecegimiz dosyayi olustur
            LocalDateTime ldt=(TakesScreenshot)driver;
        File tumSayfaScreenshot= new File("target/ekranResimleri/tumEkranSS.jpeg");
// 3- tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File geciciDopsya= tss.getScreenshotAs(OutputType.FILE);
// 4- gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(geciciDopsya,tumSayfaScreenshot);*/




    }


}
