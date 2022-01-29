package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistis  {

  @Test
  public  void  test01(){
      System.out.println(System.getProperty("user.home"));
      //masa
    //C:\Users\Redi\OneDrive\Masaüstü\Deneme\selenium

     String path= System.getProperty("user.home")+"\\Masaüstü\\Deneme\\selenium";
      System.out.println(path);

      System.out.println("user.dir :"+System.getProperty("user.dir")); //:C:\Users\Redi\IdeaProjects\com.batch44TestNG
      String dosyaYolu=System.getProperty("user.home")+"\\Masaüstü\\Deneme\\selenium";
      System.out.println(Files.exists(Paths.get(dosyaYolu)));

      //projemizde pom.xml oldugunu test edin
      //C:\Users\Redi\IdeaProjects\com.batch44TestNG\pom.xml
      System.out.println(System.getProperty("user.dir")); //projemin yolunu verir
      String pomPath=System.getProperty("user.dir")+"\\pom.xml";
      Assert.assertTrue(Files.exists(Paths.get(pomPath)));

  }


}
