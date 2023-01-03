package day13_WriteExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write_Excel_ScreenShot {
@Test
    public void test01() throws IOException {

    FileInputStream fis = new FileInputStream("src/test/java/day12_WebTable_Excel/ulkeler.xlsx");
    Workbook workbook = WorkbookFactory.create(fis);

    System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

    //satir ve sutun bilgisini parametre olarak alip o hucredeki bilgiyi yazdiran bir method olusturunuz

    dataYazdir(14,3);  //Dakka
}

    private void dataYazdir(int satir, int sutun) throws IOException {
        FileInputStream fis=new FileInputStream("src/test/java/day12_WebTable_Excel/ulkeler.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));
    }

    @Test
    public void test02() throws IOException {

    //NOT: Dosya kapaliyken calistimiyoruz excel dosyasini

        FileInputStream fis = new FileInputStream("src/test/java/day12_WebTable_Excel/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //5.sutun olarak "Nufus" basligi olusturunuz
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

       // 3.satirdaki nufus bilgisini 1.5 M yapalim
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        // 7.satirdaki nufus bilgisini 3000000 yapalim
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("1500000");

  // yapilan bu degisiklikler kopya uzerinde yani Workbookta oldu.
  // Bunlari excele yolamak icin FileOutputStrem olusturmamiz lazim
        FileOutputStream fos=new FileOutputStream("src/test/java/day12_WebTable_Excel/ulkeler.xlsx");
        workbook.write(fos);

    }






}

