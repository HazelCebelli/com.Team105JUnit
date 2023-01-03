package day12_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcelGUZELL {
    @Test
    public void test01() throws IOException {

        //dosya yolunu olusturalim
        String dosyaYolu="src/test/java/day12_WebTable_Excel/ulkeler.xlsx";

        //FileInputStream objesi olsturup,parametre olarak dosya yolunu yazalim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //excelin bir kopyasini olusturduk burda:
        Workbook workbook=WorkbookFactory.create(fis);

        //istedigimiz sayfaya gitmek icin sheet class olusturacagiz
        Sheet sheet=workbook.getSheet("Sayfa1");

        //Angola yazdiriniz
        Row row= sheet.getRow(5); //Angola yazdirmak icin once 5. satira gitmemeiz lazim

        //5.satirda 2. indexdeki datayi alalim
        Cell cell=row.getCell(2);
        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {
//   sayfa 1'e gidecek ayarlari yapalim
        String dosyaYolu="src/test/java/day12_WebTable_Excel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

// - 1.satirdaki 2.hucreye gidelim ve yazdiralim

          /*  Sheet sheet= workbook.getSheet("Sayfa1");
            Row row= sheet.getRow(0);
            Cell cell= row.getCell(1);    */

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

// - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
       String istenenHucreStr=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();  // toString yapmak zorundayiz yoksa Strin ve Cell uyumsuzlugu hatasi veriyor.


// - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String assertBaskent=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString(); //Kabil
        Assert.assertTrue(assertBaskent.equals("Kabil"));


// - Satir sayisini bulalim
        System.out.println("satir sayisi: "+(workbook.getSheet("Sayfa1").getLastRowNum()+1)); // index olarak aldigi icin +1 ekleriz!!!

// - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("2. sayfa fiziki satir sayisi indexi: "+(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()));

// - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
String key="";  // has to be unique
String value="";

        Map<String, String> ulkelerMap=new TreeMap<>();
        for(int i=0; i<=sonSatirIndexi; i++){
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
             value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+" "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+" "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);
        }
        System.out.println(ulkelerMap);


    }
}
