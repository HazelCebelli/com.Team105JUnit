package day12_WebTable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.DriverManager;
import java.util.List;

public class WebTables_Excel extends TestBase {
    @Test
    public void test01(){
// 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
// 2. Headers da bulunan basliklari yazdirin
        WebElement headerElementi=driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("headerElementi "+headerElementi.getText());

// 3. 3.sutunun basligini yazdirin
        List<WebElement> headsElements=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("3. baslik : "+ headsElements.get(2).getText().trim());

// 4. Tablodaki tum datalari yazdirin
        WebElement tumDataElementi=driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("tumDataElementi "+tumDataElementi.getText().trim());

// 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

// 6. Tablodaki satir sayisini yazdirin

// 7. Tablodaki sutun sayisini yazdirin

// 8. Tablodaki 3.kolonu yazdirin
      //  ((//div[@class=‘rt-tr-group’]))//div[1]/div[3]

// 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
//10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }
}
