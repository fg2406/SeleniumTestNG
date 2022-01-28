package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03 {

   WebDriver driver;

   @BeforeClass
   public  void  setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //●https://the-internet.herokuapp.com/iframe adresine gidin.
     driver.get("https://the-internet.herokuapp.com/iframe");


   }

   @Test
   public  void iframeTest(){

      //○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
      WebElement text=driver.findElement(By.tagName("h3"));
      //System.out.println(text.isEnabled());

     //2yol SoftAseert
      SoftAssert softAssert=new SoftAssert();
      softAssert.assertTrue(text.isEnabled(),"iframe yazisi gorunmuyor");
      System.out.println(text.getText());

      //○Text Box’a “Merhaba Dunya!” yazin.
      WebElement iframe=driver.findElement(By.tagName("iframe"));
      driver.switchTo().frame(iframe);
      WebElement textBox= driver.findElement(By.tagName("p"));
      textBox.clear();
      textBox.sendKeys("merhaba dunya");
      driver.switchTo().defaultContent();

      //○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu
      WebElement linkTest= driver.findElement(By.xpath("//a[@target='_blank']"));
      SoftAssert softAssert1=new SoftAssert();
      softAssert1.assertTrue(linkTest.isDisplayed());
      linkTest.click();



   }


   @AfterClass
   public  void  tearDown(){
      driver.close();
   }

}
