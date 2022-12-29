package day08;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_testBase extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        ReusableMethods.bekle(3);

    }
}
