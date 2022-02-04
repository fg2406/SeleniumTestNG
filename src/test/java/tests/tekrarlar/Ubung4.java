package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Ubung4 {




   static WebDriver driver;
   @BeforeClass
   public  static  void setUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }

   @Test
   public  void  test01(){

       // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
       driver.get("http://webdriveruniversity.com/Actions");

       //    //2- Hover over Me First" kutusunun ustune gelin
      WebElement hoverMeButton= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
      hoverMeButton.click();


       WebElement link1= driver.findElement(By.xpath("//a[text()='Link 1']"));
       link1.click();




   }




 @AfterClass
    public static void tearDown(){
   driver.close();

 }

}
