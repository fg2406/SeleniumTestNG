package tests.day12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Ubung02 extends TestBase {

    static  WebElement dropDownElementi;
     static Select select;
    static WebElement aramaKutusu;
    static WebElement urunuSepeteEkleElementi;
    static String urun1Title;
    static String  urun1Fiyat;
    static  String titleActual;
    static String fiyatActual;

    @BeforeMethod
  public  void  setUp1(){
        driver.get("https://www.amazon.com/");
        dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select =new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

  }



@Test
    public void test01() {
    //amazon gidin
    //arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin


    List<WebElement> dropDownListesi = select.getOptions();
    dropDownListesi.stream().forEach(t -> System.out.println(t.getText()));
    //dropdown menude 40 eleman old. dogrulayin
    int expectedSayi=40;
    int actualSayi=dropDownListesi.size();
    Assert.assertEquals(actualSayi,expectedSayi);
}

    @Test
    public void test02() {
        select.selectByValue("search-alias=electronics-intl-ship");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisiElementi.getText());
        String expectedSonucYazisi = "iphone";
        Assert.assertTrue(sonucYazisiElementi.getText().contains(expectedSonucYazisi));


        WebElement ilkUrunElementi = driver.findElement(By.xpath("//img[@class='s-image']"));
        WebElement ikinciUrunElementi = driver.findElement(with(By.tagName("img")).below(ilkUrunElementi));
        ikinciUrunElementi.click();

        urun1Title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        urun1Fiyat = driver.findElement(By.xpath("//td[@class='a-span12']")).getText();
        System.out.println(urun1Fiyat);
        System.out.println(urun1Title);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


    }


    @Test
    public  void test03(){
    //yeni bir sekme acip amazon sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //dropDown dan bebek bolumune gecin
        WebElement dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(dropDownElementi);
        select.selectByVisibleText("Baby");

        //bebek puset aratip bulundan sonuc sayisini yazdririn
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("baby jogger"+Keys.ENTER);
        WebElement sonucSayisiPuset=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("sonuc sayisi elementi "+sonucSayisiPuset.getText());

        //sonuc yazisinin puset icerdigini test edin
        Assert.assertTrue(sonucSayisiPuset.getText().contains("baby jogger"));

        //ucuncu ueune relative locater kullanarak tiklayin
        WebElement ikinciSonucElementi = driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement ucuncuSonucElementi = driver.findElement(with(By.tagName("img")).below(ikinciSonucElementi));
        ucuncuSonucElementi.click();



        //title ve fiyat bilgilerini assign edelim ve urunu sepete ekleyin
       titleActual=driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
       fiyatActual=driver.findElement(By.xpath("//span[@id='price_inside_buybox']")).getText();
       driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


    }


   @Test
    public  void  test04(){
        //sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
          WebElement sepetButonu=driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
          sepetButonu.click();

          String bebekArabasiFiyat=driver.findElement(By.xpath("//p[@class='a-spacing-mini'][1]")).getText();
          String bebekArabasiTitel=driver.findElement(By.xpath("//span[@class='a-truncate-cut'][1]")).getText();

       String iphoneFiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();
       String iphoneTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();
       Assert.assertEquals(urun1Fiyat, iphoneFiyat);
       Assert.assertEquals(fiyatActual,bebekArabasiFiyat);
       Assert.assertEquals(urun1Title, iphoneTitle);
       Assert.assertEquals(titleActual, bebekArabasiTitel);
   driver.quit();
   }

}


