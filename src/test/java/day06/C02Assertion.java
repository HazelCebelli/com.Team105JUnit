package day06;

import org.junit.Assert;
import org.junit.Test;

public class C02Assertion {


    /*
    JUnit frameworku calistirilan testlerin passed veya failed olmasini raporlar ancak raporlamanin dogru sonuc vermesi icin testlerin
     */

    int P1yas=60;
    int P2yas=66;
    int P3yas=70;
    //not: emekli yasi 65

    @Test
    public void test01(){
    //P2nin emekli olabilcegini test edin
        Assert.assertTrue(P2yas>65);
    }

    @Test
    public void test02(){
        //P1nin emekli olamayacagini test edin
        Assert.assertFalse(P1yas>65);
    }


}
