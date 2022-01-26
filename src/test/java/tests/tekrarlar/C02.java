package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02 {




  WebDriver driver;
  SoftAssert softAssert;

  @BeforeClass
  public void  setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }

   @Test
    public  void  bbSayfa() {


       //1. “https://www.hepsiburada.com/” Adresine gidin
       driver.get("https://www.hepsiburada.com/");

       //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
       //baslikta location gerek yok
       String actualTitle= driver.getTitle();
       String exceptedTitel="Turkiye’nin En Buyuk Alisveris Sitesi";
       softAssert=new SoftAssert();
       softAssert.assertTrue(actualTitle.contains(exceptedTitel));



   }
    @Test  (dependsOnMethods ="bbSayfa")
    public  void arabaTest(){
       //3. search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);

        //4. bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']")).getText());

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String actualResult=driver.findElement(By.xpath("//h1[@class='searchResultSummaryBar-bold']")).getText();
        String exceptedResult="araba";
        softAssert.assertTrue(actualResult.contains(exceptedResult));

        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String sonucYazisi="oto";
        softAssert.assertFalse(actualResult.contains(sonucYazisi));
        softAssert.assertAll();  //rapor almak istiyorsak bunu yazmaliyiz



       }




   @AfterClass
    public  void  teardown(){

      driver.close();

   }

}
