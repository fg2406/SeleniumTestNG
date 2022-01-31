package tests.practice1;

import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;

public class C01 {


@Test(priority =3000)
    public  void b(){
    System.out.println("b");
}
@Test(priority =-2001,enabled = false) //enable=false yaparsak bunu ignore eder,calistirmaz
    public  void  a(){
    System.out.println("a");
}
@Test (priority = 2000)
    public  void c(){
    System.out.println("c");
}
}
