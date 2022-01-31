package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {



  @Test
    public  void  screenTest(){
      driver.get("https://google.com");
      driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();
      //1.adim: screenshot almak icin obje olusstur ve deger olarak drivir'i atariz
      //deger olarak driverr'i kabul etmesi icin casting yapmamiz lazim
      TakesScreenshot tss=(TakesScreenshot)driver;


      //2.adim tum sayfanin screenshot 'ini almak icin bir File olustururuz ve dosya yolunu belirtiriz
      File tumSayfaSS=new File("src/11^^^^^^^^^^^^^^^^^^^^^^^^^,tumSayfa.png");


      //3.adim: olusturdugumuz file ile takescreenshot objesini iliskilendirelim
      tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

  }



}
