package day10;

import org.junit.Test;
import utilities.TestBase;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_File_Olusturma {

    @Test
    public void test01() throws FileNotFoundException {

    String filePath="\"C:\\Users\\cebel\\OneDrive\\Masaüstü\\MerhabaJava\"";
    FileInputStream fis=new FileInputStream(filePath);

    System.out.println(System.getProperty("user.dir"));


    System.out.println(System.getProperty("user.home"));

   // String dinamikDosyaYolu=System.getProperty("user.home")+"/Desctop.....";


}
}
