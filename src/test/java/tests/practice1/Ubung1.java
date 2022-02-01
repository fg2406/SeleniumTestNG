package tests.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Ubung1 extends TestBase {



   @Test
   public void test01() {
       //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
       driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");


       //click on action dialog button

       driver.findElement(By.xpath("//*[@id=\"action\"]")).click();

       //if need use explicitly wait
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));

       //click on the ok button

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dialog-mycodemyway-action']"))).click();

       // accept the iframe message/
       System.out.println(driver.switchTo().alert().getText());
       driver.switchTo().alert().accept();


       /* web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
       // pencereyi büyüt
       // eylem diyalog düğmesine tıklayın
       // kullanmanız gerekiyorsa açıkça bekleyin
       // tamam butonuna tıklayın
       // iframe mesajını kabul et */


   }

}
