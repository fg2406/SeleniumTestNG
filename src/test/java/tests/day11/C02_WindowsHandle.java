package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowsHandle {



    WebDriver driver;

    @BeforeClass
    public void setUp() {


       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }



   @Test
    public  void  test1(){

        //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("https://the-internet.herokuapp.com/windows");

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       WebElement text= driver.findElement(By.tagName("h3"));

       SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals(text.getText(), "Opening a new window","sayfadaki yazi beklenenden farkli");

       //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
       softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa title'i beklenenden farkli");


        //● Click Here butonuna basın.
       // soruda windowhandle degerini bilmedigim bir window aciliyor
       // o sayfanin window handle degerini bulmak icin gectigim sayfalardaki
       // window handle degerlerini kaydetmeliyim

       String windowHandleDegeri1=driver.getWindowHandle();

       driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
       // once acilan yeni sayfanin handle degerini elde etmeliyim
       // once tum handle degerlerini alip bir set'e koyalim

       Set<String> handleDegerleri=driver.getWindowHandles();
       String handleDegerleri2="";
       for (String each: handleDegerleri
            ) {
           if (!handleDegerleri.equals(windowHandleDegeri1))
             handleDegerleri2=each;

       }
       System.out.println(handleDegerleri2);

         //yeni sayafaya gecis yapabilirim
       driver.switchTo().window(handleDegerleri2);

       //● Sayfadaki textin “New Window” olduğunu doğrulayın.

         String actualTitel=driver.findElement(By.tagName("h3")).getText();
         String expectedTitel="New Window";
         SoftAssert softAssert1=new SoftAssert();
         softAssert1.assertEquals(expectedTitel,actualTitel,"new window yazisi icermiyor");
         //softAssert.assertEquals(driver.getTitle(),"New Window","yeni sayfa title'i istenenden farkli");


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
       driver.switchTo().window(windowHandleDegeri1);
       Assert.assertEquals(driver.getTitle(),"The Internet");


    }

    @AfterClass
    public  void  tearDown(){
      driver.quit();
    }


}
