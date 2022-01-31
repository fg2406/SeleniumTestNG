package tests.day12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Ubunf07 extends TestBase {

  // 1) "https://www.facebook.com/" SAYFASINA GiDiN
  // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
  // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
  // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
  // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN


  @Test
    public  void  test01(){

      driver.get("https://www.facebook.com/");
      //button[text()='Tüm Çerezlere İzin Ver']
       driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();
      WebElement hesapOlustur=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
      hesapOlustur.click();
      WebElement dropdawn= driver.findElement(By.xpath("//select[@id='month']"));
      Select options=new Select(dropdawn);
      List<WebElement> gunler=options.getOptions();
      gunler.stream().forEach(t-> System.out.print(t.getText()));

      //4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
       WebElement dropdawn1=driver.findElement(By.xpath("//select[@id='month']"));
       Select option1=new Select(dropdawn1);
       List<WebElement> aylar=option1.getOptions();
       aylar.stream().forEach(t-> System.out.print(t.getText()));

    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

     WebElement dropdown2=driver.findElement(By.xpath("//select[@id='year']"));
     Select option2=new Select(dropdawn);
     List<WebElement> yillar=option2.getOptions();
     yillar.stream().forEach(t-> System.out.print(t.getText()));

       driver.close();


  }




}
