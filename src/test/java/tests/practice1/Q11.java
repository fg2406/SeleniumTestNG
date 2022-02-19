package tests.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;
/*
@DataProvider bir TestNG annotation'idir. Dolayisiyla sadece TestNG ile kullanilir.
Veri sağlamak için kullanılır. DDT (Data Driven Test) yapilir
Cucumber'daki Scenario Outline ile ayni isleve sahiptir
 */
public class Q11 extends TestBase {
  //http://amazon.com adresine gidiniz
    //araba,ev,anahtarlik,ayakkabi,gomlek kelimelerini arayiniz

    @Test(dataProvider="urunler")
    public  void  amazonTest(String kelime){
        driver.get("http://amazon.com");
        driver.findElement(By.xpath("/input[@id='twotabsearchtextbox']")).sendKeys(kelime+ Keys.ENTER);


    }
    @DataProvider(name="urunler")
    public  Object[][] getUurnler(){
        //  String [][] urunler={ {"araba"},{"ev"},{"anahtarlik"},{"ayakkabi"},{"gomlek"}};
             Object [][] urunler={ {"araba"},{"ev"},{"anahtarlik"},{"ayakkabi"},{"gomlek"}};
        return urunler;
    }

    //https://www.gittigidiyor.com/ adresine gidiniz
    //java,javascript ve python kelimelerini yazdiriniz

    @Test  (dataProvider = "aranacakKelimeler") //veri aldigimiz method ismi belirtilirse
    public  void  gittiGidiyorTest(String aranacakKelime){
      driver.get("https://www.gittigidiyor.com/");
      driver.findElement(By.xpath("//input[@name='k']")).sendKeys(aranacakKelime+Keys.ENTER);


   }

  @DataProvider
    public  static Object[][] aranacakKelimeler() {

          String data[][] = {{"java"}, {"javascript"}, {"python"}};
          return data;


      }


  }


