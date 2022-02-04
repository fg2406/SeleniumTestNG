package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Ubung extends TestBase {




    @Test
    public  void  test01() throws InterruptedException {


        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String handleWindow= driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin

        //3."Login Portal" a tiklayin
        JavascriptExecutor jse=(JavascriptExecutor)driver;
       WebElement loginPortal= driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']"));
       jse.executeScript("arguments[0].click();",loginPortal);
        Set<String> handleDegerleri=driver.getWindowHandles();
        String handle2="";
        for (String each:handleDegerleri){
              if (!handleDegerleri.equals(handleWindow)){
                  handle2=each;
              }

        }
        driver.switchTo().window(handle2);

        //4.Diger window'a gecin
        Actions actions=new Actions(driver);
        WebElement user=driver.findElement(By.xpath("//input[@placeholder='Username']"));

        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        actions.click(user).
                keyDown(Keys.SHIFT).sendKeys("f").
                keyUp(Keys.SHIFT).sendKeys("iliz").sendKeys(Keys.TAB).
                sendKeys("12345").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();



        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        //8.Ok diyerek Popup'i kapatin

       String actualResult=driver.switchTo().alert().getText();
       String expectedResult="validation failed";
       Assert.assertTrue(actualResult.equals(expectedResult));
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(handleWindow);

        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertEquals(driver.getWindowHandle(),handleWindow);

         Thread.sleep(3000);
         driver.close();
    }
}
