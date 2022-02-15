package practice3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class C01_Ubung extends TestBase {




  @Test
    public  void  test01() {


      //// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
       // driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
      driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
      //// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin

    // String ogeler=driver.findElements()
      List<WebElement> tumOgeler=driver.findElements(By.xpath("//div[@class='shelf-item']"));
      System.out.println("tum elemenler listesi :"+tumOgeler.size());

      //// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

      for (int i=0; i<tumOgeler.size(); i++){
          System.out.println(i+1+".urun :"+tumOgeler.get(i).getText());
      }
      //// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
      List<WebElement> urunlerElementi = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));

      List<String> urunAdlari=new ArrayList<>();

    for (WebElement each: urunlerElementi) {
      urunAdlari.add(each.getText());
    }

      //// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    //(her urunden sadece 1 kez eklenecek)
   // WebElement sepetElement= driver.findElement(By.xpath("//span[@class['bag bag--float-cart-closed']"));

   /*****************************************************
    * Rondom sinifi,rastagele deger uretmek icin kullanilan bir siniftir,bizim verecegimiz aralikta rastegele  bir deger uretebilir
   rondom class kullanimi icin import gerekli ve obje olusturularak kullanilir
     su sekilde kullanilir;
   1. Random r=new Randow();
   2. int a=r.nextInt(10);
    burda 1'den baslar 10'a kadar degerler uretir,10 dahil degil
   ornek1:-1 ile 9 arasinda almak istersek 0-10 yapip cikan sonuctan 1 cikarabilirz
    Ornek2:1'den 100'e kadar rastgele bir sayi(sayi bir daha yazilmasin)istersek bir liste yapar,cikan sayiyi buraya atara
    i file kontrol ederiz bu sayi varmi yokmu
   eger sayi yazilmazsa ici bos kalirsa -2147483648 ve +2147486647 arasindaki butun int degerleri uretir
   **diger turrlerde sayi uretmek istiyorsak kullanilacak yontem
   long l=r.nextLong();
   float f=r.nextFloat();
   ............

    **************************************************************************/

    Random r = new Random();
    List<WebElement> addCarts = driver.findElements(By.xpath("//div[@class='shelf-item__buy-btn']"));

    for (int i = 1; i <=5 ; i++) {
      WebElement product =  addCarts.get(r.nextInt(addCarts.size()));
      product.click();
      addCarts.remove(product);
    }

    List<WebElement> productsInCart = driver.findElements(By.xpath("//p[@class='title']"));

    for (WebElement name : productsInCart)
      System.out.println(name.getText()+" sepete eklendi !");

      //// (Her ürün 1 defadan fazla eklenemez!)
      //// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

    List<WebElement> PricesElements = driver.findElements(By.xpath("//div[@class='shelf-item__price']"));
    for (int i = 1; i <=16 ; i++) {
      PricesElements.remove(0);
    }


    List<Double> Prices = new ArrayList<Double>();
    for (WebElement w:PricesElements) {

      Prices.add(Double.parseDouble(w.getText().replaceAll("[$'\"+-]","")));

    }

    double totalPrice = 0.00;
    for (Double i:Prices) {
      totalPrice +=i;

    }

    String TotalInSite = driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();
    Double totalPriceInSite = Double.parseDouble(TotalInSite.replaceAll("[$'\"+-]",""));
    Assert.assertEquals(totalPrice, totalPriceInSite);

      /*  List<WebElement> sepettekiUrunlerFiyatElementi = Driver.getDriver().findElements(By.xpath("//div[@class='float-cart__shelf-container']//div[@class='shelf-item__price']//p"));
             double expectedPrice =  0.0;
             for (WebElement each: sepettekiUrunlerFiyatElementi) {
             expectedPrice += Double.parseDouble(each.getText().replace("$ ",""));
                }
             WebElement sepetToplamFiyatElementi = Driver.getDriver().findElement(By.xpath("//p[@class='sub-price__val']"));
             double actualPrice = Double.parseDouble(sepetToplamFiyatElementi.getText().replace("$ ", ""));
             expectedPrice = (Math.round(expectedPrice*100.0)/100.0); // virgulden sonra 2 basamak olmasi icin.
             Assert.assertEquals(actualPrice, expectedPrice);  */


      //// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    if(totalPrice==totalPriceInSite) System.out.println("test pass");
      //// 7.Checkout'a tıklayın

      driver.findElement(By.xpath("//div[@class='Checkout']")).click();


  }



}
