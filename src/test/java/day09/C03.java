package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C03 extends TestBase {

        @Test
        public void test01(){
            //1- https://www.amazon.com/ adresine gidin
            driver.get("https://www.amazon.com/");
            //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
            //3- “Create a list” butonuna basin
            //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

            WebElement beklenecekElement=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            Actions action=new Actions(driver);







}
}
