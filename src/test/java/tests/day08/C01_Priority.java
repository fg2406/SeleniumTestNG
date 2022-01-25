package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {

@Test (priority = -9)
    public void youtubeTesti(){
    System.out.println("youtube testi calisti");
}

@Test
    public void amazonTesti(){ //priority atamazsak 0 kabul eder
    System.out.println("amazon testi calisti");
}

@Test
    public void bestbuyTesti(){
    System.out.println("bestbuy Testi calisti");
}

}
