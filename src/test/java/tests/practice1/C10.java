package tests.practice1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C10 extends TestBase {


  @Test
  public  void  facebookKayit() throws InterruptedException {


      //"https://facebook.com"  Adresine gidin
      driver.get("https://facebook.com");
      driver.findElement(By.xpath("//button[@title='Tüm Çerezlere İzin Ver']")).click();

      //“create new account”  butonuna basin
        WebElement createNew=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
         createNew.click();

         //“firstName” giris kutusuna bir isim yazin

      WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

      Actions actions=new Actions(driver); //actions class'ina ihtiyac vardir faker icin
      Faker faker=new Faker();  //faker kullanmak icin obje olusturmaliyiz yada static methodlari varsa
      String email=faker.internet().emailAddress();//emal yada tel tekrar girin diyecegi icin,faker her defasinda farkli birsey atayacagi icin
      //ilk atanacagi bir String'e atadik ki dogrulamada bunu kullanalim

      actions.click(isimKutusu).
             //isim yazin
               sendKeys(faker.name().name()).


              //“surname” giris kutusuna bir soyisim yazin
               sendKeys(Keys.TAB).
              sendKeys(faker.name().lastName()).

           //“email” giris kutusuna bir email yazin
                   sendKeys(Keys.TAB).
              sendKeys(email).
      //“email” onay kutusuna emaili tekrar yazin
              sendKeys(Keys.TAB).
              sendKeys(email).
      //Bir sifre girin
      sendKeys(Keys.TAB).
              sendKeys(faker.internet().password()).
      //Tarih icin gun secin
       sendKeys(Keys.TAB).
              sendKeys("13").

      //Tarih icin ay secin
      sendKeys(Keys.TAB).
              sendKeys("Mai").
      //Tarih icin yil secin
      sendKeys(Keys.TAB).sendKeys(Keys.TAB).
              sendKeys("1990").
      //Cinsiyeti secin
              sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
              sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

      //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

      WebElement kadinSecim= driver.findElement(By.xpath("//input[@value='1']"));
     // kadinSecim.click();
      WebElement erkekSecim=driver.findElement(By.xpath("//input[@value='2']"));

      Assert.assertTrue(kadinSecim.isSelected());
      kadinSecim.click();
      Assert.assertFalse(erkekSecim.isSelected());

      //Sayfayi kapatin
    Thread.sleep(3000);
    driver.close();
  }


}
