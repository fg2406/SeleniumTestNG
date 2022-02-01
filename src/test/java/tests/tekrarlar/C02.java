package tests.tekrarlar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02 extends TestBase {

// 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

   @Test
   public void  test01() throws InterruptedException {
       driver.get("http://webdriveruniversity.com/IFrame/index.html");
       WebElement iframeLocate= driver.findElement(By.xpath("//iframe[@id='frame']"));
       driver.switchTo().frame(iframeLocate);  //suan iframe icindeyiz
       driver.findElement(By.xpath("//a[text()='Our Products']")).click();

       //3. “Cameras product”i tiklayin
       driver.findElement(By.xpath("//img[@id='camera-img']")).click();

       //4. Popup mesajini yazdirin
        Thread.sleep(5000);
        String mesaj=driver.findElement(By.xpath(" //*[@id=\"myModal\"]/div/div/div[2]")).getText();
       System.out.println(mesaj);

       //5. “close” butonuna basin
      driver.findElement(By.xpath("//button[text()='Close']")).click();
       driver.switchTo().defaultContent();

       //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
      driver.findElement(By.xpath("//*[@id=\"nav-title\"]")).click();

       //7. "http://webdriverunive;rsity.com/index.html" adresine gittigini test edin
       String expectedUrl="http://webdriveruniversity.com/index.html";
       String actualUrl=driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);
       driver.close();


   }

}
